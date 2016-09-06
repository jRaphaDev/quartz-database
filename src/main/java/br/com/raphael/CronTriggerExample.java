package br.com.raphael;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {
	
    public static void main( String[] args ) throws Exception {

    	JobDetail job = JobBuilder.newJob(HelloJob.class)
    			.withIdentity("helloJob", "group1")
    			.build();

    	Trigger trigger = TriggerBuilder
            	.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(
                		SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(40).repeatForever())            
                .build();
    	
    	//Agendamento
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
    	    
    }
}
