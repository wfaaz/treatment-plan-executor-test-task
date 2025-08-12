package com.treatment.plan_scheduler.service;

import com.treatment.plan_scheduler.dto.TreatmentPlanDto;
import com.treatment.plan_scheduler.entity.TreatmentPlan;
import com.treatment.plan_scheduler.entity.TreatmentTask;
import com.treatment.plan_scheduler.mapper.TreatmentPlanMapper;
import com.treatment.plan_scheduler.model.TreatmentPlanStatus;
import com.treatment.plan_scheduler.model.TreatmentTaskStatus;
import com.treatment.plan_scheduler.repository.TreatmentPlanRepository;
import com.treatment.plan_scheduler.repository.TreatmentTaskRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;


@Service
public class ScheduleService {

    private Logger log = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    private TreatmentPlanRepository planRepository;

    @Autowired
    private TreatmentTaskRepository taskRepository;

    @Autowired
    private TreatmentPlanMapper treatmentPlanMapper;


    @Transactional
    @Scheduled(cron = "0 0 0 1 * ?")
    public void plansProlongationTask() {
        try {
            List<TreatmentPlan> prolongationPlans = planRepository.findByStatusInAndEndTimeGreaterThan(
                List.of(TreatmentPlanStatus.POSTPONED, TreatmentPlanStatus.SCHEDULED), LocalDateTime.now());
            if (!prolongationPlans.isEmpty()) {
                prolongationPlans.forEach(treatmentPlan -> treatmentPlan.setStatus(TreatmentPlanStatus.NEW));
            }
            planRepository.saveAll(prolongationPlans);
        } catch (Exception ex) {
            log.error("Failed to run plansProlongationTask");
        }
    }

    @Transactional
    @Scheduled(cron = "0 */10 * * * ?")
    public void checkNewTreatmentPlan() {
        log.info("checkNewTreatmentPlan task started.");
        List<TreatmentPlan> treatmentPlans = planRepository.findByStatus(TreatmentPlanStatus.NEW);
        if (!treatmentPlans.isEmpty()) {
            final LocalDate currentDate = LocalDate.now();

            treatmentPlans.stream()
                .map(treatmentPlan -> treatmentPlanMapper.entityToDto(treatmentPlan))
                .forEach(treatmentPlanDto ->
                    persistTreatmentTasksByPlan(treatmentPlanDto, currentDate));
        } else {
            log.warn("No treatmentPlans to process.");
        }
    }

    @Transactional
    private void persistTreatmentTasksByPlan(TreatmentPlanDto treatmentPlanDto, LocalDate currentDate) {
        TreatmentPlanStatus afterProcessStatus = null;
        TreatmentPlan persistedTreatmentPlan = null;
        final int currentMonthValue = currentDate.getMonthValue();
        try {
            LocalDate startDate = treatmentPlanDto.getStartTime().toLocalDate();
            if (startDate.getMonthValue() > currentMonthValue) {
                afterProcessStatus = TreatmentPlanStatus.POSTPONED;
            } else if (startDate.getMonthValue() < currentMonthValue) {
                afterProcessStatus = TreatmentPlanStatus.FAILED;
            } else {
                final LocalDate endDate;

                if (treatmentPlanDto.getEndTime() == null || treatmentPlanDto.getEndTime().toLocalDate().getMonthValue() > currentMonthValue) {
                    endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
                } else {
                    endDate = treatmentPlanDto.getEndTime().toLocalDate();
                }

                String[] recurrenceParts = treatmentPlanDto.getRecurrencePattern().split(" ");

                String cronExp = new StringJoiner(" ")
                    .add(recurrenceParts[0])    // seconds
                    .add(recurrenceParts[1])    // minute
                    .add(recurrenceParts[2])    // hour
                    .add(getCronDayOfMonth(startDate.getDayOfMonth(), endDate.getDayOfMonth()))  //CronDayOfMonth
                    .add(String.valueOf(currentMonthValue))  // cronMonth
                    .add(recurrenceParts[5])                 // cronDayOfWeek
                        .toString();

                afterProcessStatus = TreatmentPlanStatus.SCHEDULED;
                log.info("treatmentPlan={}, cronExp={}", treatmentPlanDto, cronExp);

                TreatmentPlan updatedTreatmentPlan = appendTasks(treatmentPlanDto, treatmentPlanDto.getStartTime(), cronExp);
                updatedTreatmentPlan.setStatus(afterProcessStatus);
                persistedTreatmentPlan = planRepository.save(updatedTreatmentPlan);
            }
            log.info("Plan={} - {}", persistedTreatmentPlan != null ? persistedTreatmentPlan : treatmentPlanDto, afterProcessStatus);
        } catch (Exception ex) {
            log.error("Failed to process TreatmentPlan={}", treatmentPlanDto, ex);
        }
    }

    private TreatmentPlan appendTasks(TreatmentPlanDto treatmentPlanDto, LocalDateTime starTime, String cronExp) {
        CronExpression generator = CronExpression.parse(cronExp);
        LocalDateTime nextExecutionTime = starTime;
        Set<TreatmentTask> persistedTasks = new HashSet<>();
        while (nextExecutionTime != null ) {
            nextExecutionTime = generator.next(nextExecutionTime);
            if (nextExecutionTime == null || nextExecutionTime.getYear() > starTime.getYear()) {
                break;
            }
            TreatmentTask persistedActionTask = appendTreatmentTask(treatmentPlanDto, nextExecutionTime);
            persistedTasks.add(persistedActionTask);
        }
        if (treatmentPlanDto.getTreatmentTasks() == null) {
            treatmentPlanDto.setTreatmentTasks(new HashSet<>());
        }
        treatmentPlanDto.getTreatmentTasks().addAll(persistedTasks);
        return treatmentPlanMapper.dtoToEntity(treatmentPlanDto);
    }

    private TreatmentTask appendTreatmentTask(TreatmentPlanDto treatmentPlanDto, LocalDateTime taskStartTime) {
        return taskRepository.saveAndFlush(new TreatmentTask(
            treatmentPlanDto.getPlanId(),
            treatmentPlanDto.getTreatmentAction(),
            treatmentPlanDto.getSubjectPatient(),
            taskStartTime,
            TreatmentTaskStatus.ACTIVE));
    }

    private String getCronDayOfMonth(int startDay, int endDay) {
        return (endDay == startDay ? String.valueOf(startDay) : startDay + "-" + endDay);
    }
}