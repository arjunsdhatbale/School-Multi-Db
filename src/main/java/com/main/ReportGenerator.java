// package com.main;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class ReportGenerator {
//
//    private static final Logger logger = Logger.getLogger(ReportGenerator.class);
//
//    @PostConstruct
//    public void init() {
//        // Configure Log4j using properties file
//        PropertyConfigurator.configure(getClass().getClassLoader().getResource("log4j.properties"));
//        
//        // Log messages
//        logMessages();
//    }
//
//    private void logMessages() {
//        logger.trace("This is a trace message");
//        logger.debug("This is a debug message");
//        logger.info("This is an info message");
//        logger.warn("This is a warn message");
//        logger.error("This is an error message");
//        logger.fatal("This is a fatal message");
//    }
//}
