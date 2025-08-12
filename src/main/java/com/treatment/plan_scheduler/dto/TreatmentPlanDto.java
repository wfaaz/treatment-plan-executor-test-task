package com.treatment.plan_scheduler.dto;

import com.treatment.plan_scheduler.entity.TreatmentTask;
import com.treatment.plan_scheduler.model.TreatmentAction;
import com.treatment.plan_scheduler.model.TreatmentPlanStatus;

import java.time.LocalDateTime;
import java.util.Set;

public class TreatmentPlanDto {

    private Integer planId;
    private TreatmentAction treatmentAction;
    private Set<TreatmentTask> treatmentTasks;
    private String subjectPatient;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String recurrencePattern;
    private TreatmentPlanStatus status;

    public TreatmentPlanDto() {
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public TreatmentAction getTreatmentAction() {
        return treatmentAction;
    }

    public void setTreatmentAction(TreatmentAction treatmentAction) {
        this.treatmentAction = treatmentAction;
    }

    public Set<TreatmentTask> getTreatmentTasks() {
        return treatmentTasks;
    }

    public void setTreatmentTasks(Set<TreatmentTask> treatmentTasks) {
        this.treatmentTasks = treatmentTasks;
    }

    public String getSubjectPatient() {
        return subjectPatient;
    }

    public void setSubjectPatient(String subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRecurrencePattern() {
        return recurrencePattern;
    }

    public void setRecurrencePattern(String recurrencePattern) {
        this.recurrencePattern = recurrencePattern;
    }

    public TreatmentPlanStatus getStatus() {
        return status;
    }

    public void setStatus(TreatmentPlanStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TreatmentPlanDto{" +
            "planId=" + planId +
            ", treatmentAction=" + treatmentAction +
            ", treatmentTasks=" + treatmentTasks +
            ", subjectPatient='" + subjectPatient + '\'' +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", recurrencePattern='" + recurrencePattern + '\'' +
            ", status=" + status +
            '}';
    }
}
