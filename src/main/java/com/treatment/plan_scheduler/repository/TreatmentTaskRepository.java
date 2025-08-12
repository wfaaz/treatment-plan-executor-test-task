package com.treatment.plan_scheduler.repository;

import com.treatment.plan_scheduler.entity.TreatmentPlan;
import com.treatment.plan_scheduler.entity.TreatmentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentTaskRepository extends JpaRepository<TreatmentTask, Integer> {

    List<TreatmentTask> findByTreatmentPlan(TreatmentPlan treatmentPlan);

    List<TreatmentTask> findByTreatmentPlan_PlanId(Integer planId);
}
