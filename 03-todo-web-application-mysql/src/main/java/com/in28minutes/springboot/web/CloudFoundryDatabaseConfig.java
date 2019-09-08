package com.in28minutes.springboot.web;

//import javax.sql.DataSource;
//
//import org.springframework.cloud.Cloud;
//import org.springframework.cloud.CloudFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("cloud")
//public  class CloudFoundryDatabaseConfig {
// 
//    @Bean
//    public Cloud cloud() {
//        return new CloudFactory().getCloud();
//    }
// 
//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = 
//        		cloud().getServiceConnector("todo-database", DataSource.class, null);
//        //Customized
//        return dataSource;
//    }
//}