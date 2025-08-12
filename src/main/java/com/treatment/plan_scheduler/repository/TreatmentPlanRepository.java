package com.treatment.plan_scheduler.repository;

import com.treatment.plan_scheduler.entity.TreatmentPlan;
import com.treatment.plan_scheduler.model.TreatmentPlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Integer> {

    List<TreatmentPlan> findBySubjectPatient(String subjectPatient);

    List<TreatmentPlan> findByStatus(TreatmentPlanStatus status);

    List<TreatmentPlan> findByStatusInAndEndTimeGreaterThan(Collection<TreatmentPlanStatus> treatmentPlanStatuses, LocalDateTime leftBoundary);
}
