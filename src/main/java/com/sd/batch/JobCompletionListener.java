/**
 * 
 */
package com.sd.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author sreesdas
 *
 */
public class JobCompletionListener implements JobExecutionListener {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.STARTED)
			System.out.println("BATCH JOB STARTED");
	}

}
