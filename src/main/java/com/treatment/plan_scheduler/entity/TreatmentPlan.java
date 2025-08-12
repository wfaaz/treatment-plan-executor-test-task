package com.treatment.plan_scheduler.entity;

import com.treatment.plan_scheduler.model.TreatmentAction;
import com.treatment.plan_scheduler.model.TreatmentPlanStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class TreatmentPlan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer planId;

    @Column(nullable = false)
    private TreatmentAction treatmentAction;

    @OneToMany(mappedBy="treatmentPlan", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<TreatmentTask> treatmentTasks;

    @Column(nullable = false)
    private String subjectPatient;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String recurrencePattern;

    @Column(nullable = false)
    private TreatmentPlanStatus status;

    public TreatmentPlan() {
    }

    public TreatmentPlan(String subjectPatient, TreatmentAction treatmentAction, LocalDateTime startTime, LocalDateTime endTime,
                         String recurrencePattern, TreatmentPlanStatus status) {
        this.subjectPatient = subjectPatient;
        this.treatmentAction = treatmentAction;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recurrencePattern = recurrencePattern;
        this.status = status;
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
    public boolean equals(Object o) {
        if (!(o instanceof TreatmentPlan that)) return false;
        return Objects.equals(planId, that.planId) && treatmentAction == that.treatmentAction && Objects.equals(treatmentTasks, that.treatmentTasks) && Objects.equals(subjectPatient, that.subjectPatient) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(recurrencePattern, that.recurrencePattern) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, treatmentAction, treatmentTasks, subjectPatient, startTime, endTime, recurrencePattern, status);
    }

    @Override
    public String toString() {
        return "TreatmentPlan{" +
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
