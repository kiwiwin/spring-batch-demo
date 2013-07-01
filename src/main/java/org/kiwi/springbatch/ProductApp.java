package org.kiwi.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ProductApp {
    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApplicationContext context = new ClassPathXmlApplicationContext("job-config.xml");
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("productJob", Job.class);
        JobParametersBuilder builder = new JobParametersBuilder().addDate("date", new Date());
        JobExecution jobExecution = jobLauncher.run(job, builder.toJobParameters());
        System.out.println(jobExecution.getExitStatus().getExitCode());
    }
}
