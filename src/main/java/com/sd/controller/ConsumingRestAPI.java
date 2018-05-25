/**
 * 
 */
package com.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sd.model.Employee;
import com.sd.model.Request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author sreesdas
 *
 */
@RestController
@Api(value = "Consuming API")
public class ConsumingRestAPI {

	@Autowired
	RestTemplate restTemplate;

	@Value("${operations.restURL}")
	String serviceURL;

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	@ApiOperation(value = "GET test")
	@RequestMapping(value = "/api/gettest", method = RequestMethod.GET)
	public String getMethodTesting() {
		String url = serviceURL + "/hi/hello";
		return restTemplate.getForObject(url, String.class);
	}

	/**
	 * Consuming a service by postForEntity method, this method is exposed as a post
	 * operation if user post a request object(JSON) it will be automatically mapped
	 * to Request parameter.
	 */
	@ApiOperation(value = "Post test")
	@RequestMapping(value = "/api/posttest", method = RequestMethod.GET)
	public Employee postMethodTesting(@RequestBody Request request) {
		ResponseEntity<String> response = restTemplate.postForEntity(serviceURL, request, String.class);
		// return response.getBody();
		return null;
	}

	/**
	 * Consuming a service by postForObject method, this method is exposed as a get
	 * operation if user doesn't post a request object we will create a new request
	 * and post it to the URL/service endpoint
	 */
	@GetMapping("/api/gettopost/test")
	String getAvailability() {
		return restTemplate.postForObject(serviceURL, createAvailabilityRequest(), String.class);
	}

	private Object createAvailabilityRequest() {
		Request req = new Request();
		req.setId(1);
		req.setName("sree");
		req.setStatus("in");
		return req;
	}
}
