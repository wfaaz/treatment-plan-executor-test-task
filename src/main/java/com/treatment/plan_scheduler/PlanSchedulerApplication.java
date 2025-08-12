package com.treatment.plan_scheduler;

import com.treatment.plan_scheduler.repository.TreatmentPlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

import static com.treatment.plan_scheduler.utils.EntityUtils.plan1;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan2;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan3;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan4;
import static com.treatment.plan_scheduler.utils.EntityUtils.plan5;

@EnableScheduling
@SpringBootApplication
public class PlanSchedulerApplication implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(PlanSchedulerApplication.class);

    @Autowired
    TreatmentPlanRepository planRepository;

//    @Autowired
//    ScheduleService scheduleService; // uncomment if you prefer a direct call without a scheduler

    public static void main(String[] args) {
	SpringApplication.run(PlanSchedulerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        planRepository.saveAll(List.of(plan1, plan2, plan3, plan4, plan5));
        //scheduleService.checkNewTreatmentPlan();

	for (int i = 0;i < 12; i++ ) {
	    Thread.sleep(10000);
	}
	log.info("Bye-bye");
    }
}
