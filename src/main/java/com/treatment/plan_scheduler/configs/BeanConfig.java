//package com.treatment.plan_scheduler.configs;
//
//import com.treatment.plan_scheduler.entity.TreatmentPlan;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BeanConfig {
//
//    @Bean
//    SessionFactory getSessionFactory() {
//        Metadata metadata = new MetadataSources(new StandardServiceRegistryBuilder().build())
//            .addAnnotatedClass(TreatmentPlan.class)
//            .buildMetadata();
//
//        return metadata.buildSessionFactory();
//    }
//}
