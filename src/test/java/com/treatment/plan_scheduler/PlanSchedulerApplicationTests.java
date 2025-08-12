package com.treatment.plan_scheduler;

import com.treatment.plan_scheduler.entity.TreatmentPlan;
import com.treatment.plan_scheduler.entity.TreatmentTask;
import com.treatment.plan_scheduler.model.TreatmentAction;
import com.treatment.plan_scheduler.model.TreatmentTaskStatus;
import com.treatment.plan_scheduler.repository.TreatmentPlanRepository;
import com.treatment.plan_scheduler.repository.TreatmentTaskRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import static com.treatment.plan_scheduler.utils.EntityUtils.plan1;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan2;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan3;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlanSchedulerApplicationTests {

    @Autowired
    TreatmentPlanRepository planRepository;

    @Autowired
    TreatmentTaskRepository taskRepository;

    @Transactional
    @AfterEach
    public void cleanDb() {
        planRepository.deleteAll();
        //taskRepository.deleteAll();
        System.out.println("db cleaned");;
    }

    @Transactional
    @Test
    void createTreatmentPlan() {

        System.out.println("Hello world 2025.");

//        planRepository.saveAll(List.of(plan1, plan2, plan3));

        List<TreatmentPlan> actualPlans = planRepository.findAll();
        assertThat(actualPlans)
            .hasSize(3)
            .extracting(TreatmentPlan::getSubjectPatient)
            .containsExactly("patient_1", "patient_1", "patient_2");

        System.out.println("All TreatmentPlans:" + actualPlans);
    }

    @Transactional
    @Test
    public void addTreatmentTask() {
//        planRepository.saveAll(List.of(plan1, plan2, plan3));

        List<TreatmentPlan> treatmentPlans = planRepository.findBySubjectPatient("patient_1");
        for (TreatmentPlan treatmentPlan : treatmentPlans) {
            if (treatmentPlan.getTreatmentAction().equals(TreatmentAction.ACTION_B)) {
                TreatmentTask actionBTask = new TreatmentTask(
                    treatmentPlan.getPlanId(),
                    TreatmentAction.ACTION_B,
                    "patient_1",
                    LocalDateTime.parse("2025-08-12T23:59:00"),
                    TreatmentTaskStatus.ACTIVE);

                if (treatmentPlan.getTreatmentTasks() == null) {
                    treatmentPlan.setTreatmentTasks(new HashSet<>());
                }
                treatmentPlan.getTreatmentTasks().add(actionBTask);

                planRepository.save(treatmentPlan);
            }
        }

        System.out.println("All TreatmentTasks:" + taskRepository.findAll());
        System.out.println("patient_1 plans:" + planRepository.findBySubjectPatient("patient_1"));
    }
}
