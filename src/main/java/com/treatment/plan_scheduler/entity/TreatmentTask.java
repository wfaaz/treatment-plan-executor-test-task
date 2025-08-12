package com.treatment.plan_scheduler.entity;

import com.treatment.plan_scheduler.model.TreatmentAction;
import com.treatment.plan_scheduler.model.TreatmentTaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class TreatmentTask {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    private TreatmentPlan treatmentPlan;

    @Column(nullable = false)
    private Integer treatmentPlanId;

    @Column(nullable = false)
    private TreatmentAction treatmentAction;

    @Column(nullable = false)
    private String subjectPatient;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private TreatmentTaskStatus status;

    public TreatmentTask() {
    }

    public TreatmentTask(Integer treatmentPlanId, TreatmentAction treatmentAction, String subjectPatient,
                         LocalDateTime startTime, TreatmentTaskStatus status) {
        this.treatmentPlanId = treatmentPlanId;
        this.treatmentAction = treatmentAction;
        this.subjectPatient = subjectPatient;
        this.startTime = startTime;
        this.status = status;
    }

    public String getSubjectPatient() {
        return subjectPatient;
    }

    public void setSubjectPatient(String subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TreatmentPlan getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public Integer getTreatmentPlanId() {
        return treatmentPlanId;
    }

    public void setTreatmentPlanId(Integer treatmentPlanId) {
        this.treatmentPlanId = treatmentPlanId;
    }

    public TreatmentAction getTreatmentAction() {
        return treatmentAction;
    }

    public void setTreatmentAction(TreatmentAction treatmentAction) {
        this.treatmentAction = treatmentAction;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public TreatmentTaskStatus getStatus() {
        return status;
    }

    public void setStatus(TreatmentTaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TreatmentTask that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(treatmentPlan, that.treatmentPlan) && Objects.equals(treatmentPlanId, that.treatmentPlanId) && treatmentAction == that.treatmentAction && Objects.equals(subjectPatient, that.subjectPatient) && Objects.equals(startTime, that.startTime) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, treatmentPlan, treatmentPlanId, treatmentAction, subjectPatient, startTime, status);
    }

    @Override
    public String toString() {
        return "TreatmentTask{" +
            "id=" + id +
            ", treatmentPlan=" + treatmentPlan +
            ", treatmentPlanId=" + treatmentPlanId +
            ", treatmentAction=" + treatmentAction +
            ", subjectPatient='" + subjectPatient + '\'' +
            ", startTime=" + startTime +
            ", status=" + status +
            '}';
    }
}
