/**
 * 
 */
package com.sd.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author sreesdas
 *
 */
@RestController
@Api
public class JobInvokerController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job processJob;

	@ApiOperation(value = "JobInvokerController")
	@RequestMapping(value = "/invokejob", method = RequestMethod.GET)
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(processJob, jobParameters);

		return "Batch job has been invoked";
	}

}
