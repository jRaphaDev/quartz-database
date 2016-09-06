package br.com.raphael;

import java.util.Date;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
	
	//static Log logger = LogFactory.getLog(HelloJob.class); 
	
	@SuppressWarnings("deprecation")
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//executa a tarefa.
		System.out.println("Rapha testando Quartz! " + new Date().getSeconds() + "s");	
	}
	
}
