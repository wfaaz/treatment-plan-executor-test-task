package com.treatment.plan_scheduler.mapper;

import com.treatment.plan_scheduler.dto.TreatmentPlanDto;
import com.treatment.plan_scheduler.entity.TreatmentPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreatmentPlanMapper {

    TreatmentPlanDto entityToDto(TreatmentPlan TreatmentPlanEntity);

    TreatmentPlan dtoToEntity(TreatmentPlanDto TreatmentPlanDto);
}