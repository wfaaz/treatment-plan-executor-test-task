# Read Me 
App built on base of Spring boot desktop app, Hibernate and cron scheduler;
There is two scheduled jobs present:
- postpone_job ->  changes status of 'POSTPONED' plans to 'NEW';
- main_job -> as first : filters out all dateTime deltas that not meet current month (change of status to 'POSTPONED');
as second : doing main test task job -> creates general cron template for the plan and parses all possible values;

## Plans examples: [Can be found here](src/main/java/com/treatment/plan_scheduler/utils/EntityUtils.java)


### App output example: 
```json
{
2025 - 08 - 11T18: 57: 00.122 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: checkNewTreatmentPlan task started.
2025 - 08 - 11T18: 57: 00.242 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: treatmentPlan = TreatmentPlanDto {
    planId = 1,
    treatmentAction = ACTION_A,
    treatmentTasks = [],
    subjectPatient = 'patient_1',
    startTime = 2025 - 08 - 12T10: 30,
    endTime = 2025 - 08 - 20T22: 30,
    recurrencePattern = '0 0 8,16 * * *',
    status = NEW
}, cronExp = 0 0 8, 16 12 - 20 8 *
2025 - 08 - 11T18: 57: 00.301 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: Plan = TreatmentPlan {
    planId = 1,
    treatmentAction = ACTION_A,
    treatmentTasks = [TreatmentTask {
            id = 12,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 18T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 6,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 15T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 17,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 20T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 3,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 13T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 9,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 16T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 7,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 15T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 8,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 16T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 2,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 13T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 13,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 18T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 5,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 14T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 10,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 17T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 4,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 14T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 16,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 20T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 14,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 19T08: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 15,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 19T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 11,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 17T16: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 1,
            treatmentPlan = null,
            treatmentPlanId = 1,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_1',
            startTime = 2025 - 08 - 12T16: 00,
            status = ACTIVE
        }
    ],
    subjectPatient = 'patient_1',
    startTime = 2025 - 08 - 12T10: 30,
    endTime = 2025 - 08 - 20T22: 30,
    recurrencePattern = '0 0 8,16 * * *',
    status = SCHEDULED
}
 - SCHEDULED
2025 - 08 - 11T18: 57: 00.302 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: treatmentPlan = TreatmentPlanDto {
    planId = 2,
    treatmentAction = ACTION_B,
    treatmentTasks = [],
    subjectPatient = 'patient_1',
    startTime = 2025 - 08 - 12T10: 30,
    endTime = 2025 - 08 - 14T16: 30,
    recurrencePattern = '0 0 12 ? * MON',
    status = NEW
}, cronExp = 0 0 12 12 - 14 8 MON
    2025 - 08 - 11T18: 57: 00.304 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: Plan = TreatmentPlan {
    planId = 2,
    treatmentAction = ACTION_B,
    treatmentTasks = [],
    subjectPatient = 'patient_1',
    startTime = 2025 - 08 - 12T10: 30,
    endTime = 2025 - 08 - 14T16: 30,
    recurrencePattern = '0 0 12 ? * MON',
    status = SCHEDULED
}
 - SCHEDULED
2025 - 08 - 11T18: 57: 00.305 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: Plan = TreatmentPlanDto {
    planId = 3,
    treatmentAction = ACTION_A,
    treatmentTasks = [],
    subjectPatient = 'patient_2',
    startTime = 2025 - 09 - 10T16: 00,
    endTime = 2025 - 09 - 30T23: 59,
    recurrencePattern = '0 0 8,14 * * *',
    status = NEW
}
 - POSTPONED
2025 - 08 - 11T18: 57: 00.305 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: treatmentPlan = TreatmentPlanDto {
    planId = 4,
    treatmentAction = ACTION_B,
    treatmentTasks = [],
    subjectPatient = 'patient_3',
    startTime = 2025 - 08 - 13T16: 00,
    endTime = null,
    recurrencePattern = '0 0 10 * * *',
    status = NEW
}, cronExp = 0 0 10 13 - 31 8 *
    2025 - 08 - 11T18: 57: 00.330 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: Plan = TreatmentPlan {
    planId = 4,
    treatmentAction = ACTION_B,
    treatmentTasks = [TreatmentTask {
            id = 21,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 17T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 35,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 31T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 27,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 23T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 29,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 25T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 20,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 16T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 24,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 20T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 28,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 24T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 32,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 28T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 25,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 21T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 31,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 27T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 33,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 29T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 18,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 14T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 22,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 18T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 26,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 22T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 30,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 26T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 34,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 30T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 19,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 15T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 23,
            treatmentPlan = null,
            treatmentPlanId = 4,
            treatmentAction = ACTION_B,
            subjectPatient = 'patient_3',
            startTime = 2025 - 08 - 19T10: 00,
            status = ACTIVE
        }
    ],
    subjectPatient = 'patient_3',
    startTime = 2025 - 08 - 13T16: 00,
    endTime = null,
    recurrencePattern = '0 0 10 * * *',
    status = SCHEDULED
}
 - SCHEDULED
2025 - 08 - 11T18: 57: 00.330 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: treatmentPlan = TreatmentPlanDto {
    planId = 5,
    treatmentAction = ACTION_A,
    treatmentTasks = [],
    subjectPatient = 'patient_4',
    startTime = 2025 - 08 - 05T12: 00,
    endTime = null,
    recurrencePattern = '0 0 10 * * *',
    status = NEW
}, cronExp = 0 0 10 5 - 31 8 *
    2025 - 08 - 11T18: 57: 00.362 + 02: 00 INFO 53028-- - [main]c.t.p.service.ScheduleService: Plan = TreatmentPlan {
    planId = 5,
    treatmentAction = ACTION_A,
    treatmentTasks = [TreatmentTask {
            id = 60,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 30T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 48,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 18T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 44,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 14T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 47,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 17T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 51,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 21T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 58,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 28T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 50,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 20T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 41,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 11T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 42,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 12T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 49,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 19T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 57,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 27T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 54,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 24T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 56,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 26T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 52,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 22T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 39,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 09T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 40,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 10T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 43,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 13T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 36,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 06T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 55,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 25T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 59,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 29T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 37,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 07T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 45,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 15T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 46,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 16T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 38,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 08T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 53,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 23T10: 00,
            status = ACTIVE
        }, TreatmentTask {
            id = 61,
            treatmentPlan = null,
            treatmentPlanId = 5,
            treatmentAction = ACTION_A,
            subjectPatient = 'patient_4',
            startTime = 2025 - 08 - 31T10: 00,
            status = ACTIVE
        }
    ],
    subjectPatient = 'patient_4',
    startTime = 2025 - 08 - 05T12: 00,
    endTime = null,
    recurrencePattern = '0 0 10 * * *',
    status = SCHEDULED
}
 - SCHEDULED
2025 - 08 - 11T18: 57: 00.363 + 02: 00 INFO 53028-- - [main]c.t.p.PlanSchedulerApplication: Bye - bye
}
