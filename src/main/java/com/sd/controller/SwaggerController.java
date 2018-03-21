package com.sd.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sd.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="SwagController")
public class SwaggerController {
	
	 protected final Logger log = (Logger) Logger.getInstance(SwaggerController.class);
	
	@ApiOperation(value = "Get Operation")
	@RequestMapping(value = "api/swagger/hi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person hiSwagger() {
		log.info("checking in the swagger contoller");
		Person person = new Person(10);
		return person;
	}
	@ApiOperation(value = "Get Operation",response = String.class)
	@RequestMapping(value = "api/swagger/str", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String singleMethod() {
		return "person";
	}

	@ApiOperation(value = "Post Operation", notes = "Post operation", response = String.class, httpMethod = "POST", nickname = "postMethod")
	@RequestMapping(value = "api/swagger/post", method = RequestMethod.POST  /*, produces = { "application/json" }*/)
	public String postSwaggwer() {
		return "post operation";
	}

}
