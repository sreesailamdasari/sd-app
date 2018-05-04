package com.sd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "HelloContoller")
public class HelloContoller {
	@ApiOperation(value = "HelloC")
	@RequestMapping(value = "api/post/helloworld", method = RequestMethod.GET)
	public ModelAndView hello() {
		String helloWorldMessage = "Hello world from java2blog!";
		return new ModelAndView("hello", "message", helloWorldMessage);
	}

	@RequestMapping(value = "api/post/hi", method = RequestMethod.GET)
	public String sayHai() {
		return "Hi from Hello Controller";
	}
}