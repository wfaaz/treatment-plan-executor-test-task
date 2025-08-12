package com.treatment.plan_scheduler.utils;

import com.treatment.plan_scheduler.entity.TreatmentPlan;
import com.treatment.plan_scheduler.model.TreatmentAction;
import com.treatment.plan_scheduler.model.TreatmentPlanStatus;
import io.micrometer.common.util.StringUtils;

import java.time.LocalDateTime;

public class EntityUtils {

    public static TreatmentPlan plan1 =
        createTreatmentPlan(
            TreatmentAction.ACTION_A,
            "patient_1",
            "2025-08-12T10:30:00",
            "2025-08-20T22:30:00",
            "0 0 8,16 * * *"); // “every day at 08:00 and 16:00”

    public static TreatmentPlan plan2 =
        createTreatmentPlan(
            TreatmentAction.ACTION_B,
            "patient_1",
            "2025-08-12T10:30:00",
            "2025-08-14T16:30:00",
            "0 0 12 ? * MON"); //“every Monday at 12:00”

    public static TreatmentPlan plan3 =
        createTreatmentPlan(
            TreatmentAction.ACTION_A,
            "patient_2",
            "2025-09-10T16:00:00",
            "2025-09-30T23:59:00",
            "0 0 8,14 * * *"); // “every day at 08:00 and 14:00”

    public static TreatmentPlan plan4 =
        createTreatmentPlan(
            TreatmentAction.ACTION_B,
            "patient_3",
            "2025-08-13T16:00:00",
            "",
            "0 0 10 * * *");

    public static TreatmentPlan plan5 =
        createTreatmentPlan(
            TreatmentAction.ACTION_A,
            "patient_4",
            "2025-08-05T12:00:00",
            "",
            "0 0 10 * * *");


    public static TreatmentPlan createTreatmentPlan(
        TreatmentAction treatmentAction, String subjectPatient, String startTimeStr, String endTimeStr, String recurrencePattern) {
        return new TreatmentPlan(
            subjectPatient,
            treatmentAction,
            LocalDateTime.parse(startTimeStr),
            StringUtils.isNotBlank(endTimeStr) ? LocalDateTime.parse(endTimeStr) : null,
            recurrencePattern,
            TreatmentPlanStatus.NEW);
    }
}
