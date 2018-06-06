/**
 * 
 */
package com.sd.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
		// String url = serviceURL + "/hi/hello";
		String url = "https://test.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9jfQT7vUue.H_vhe7zFZ0MkhiZJ53Ge3NElJLtf_gQtbHo1TWG8HV7TbEgWMbI7Yjo0WXFXG3z9Pj6eNV&client_secret=3758146947220243473&username=integration.api@capgemini.com.clientelng&password=Clientelling@123";

		return restTemplate.getForObject(url, String.class);
	}

	/**
	 * Consuming a service by postForEntity method, this method is exposed as a post
	 * operation if user post a request object(JSON) it will be automatically mapped
	 * to Request parameter.
	 */
	@ApiOperation(value = "Post test")
	@RequestMapping(value = "/api/posttest", method = RequestMethod.GET)
	public Employee postMethodTesting(/* @RequestBody Request request */) {
		String url = "https://test.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9jfQT7vUue.H_vhe7zFZ0MkhiZJ53Ge3NElJLtf_gQtbHo1TWG8HV7TbEgWMbI7Yjo0WXFXG3z9Pj6eNV&client_secret=3758146947220243473&username=integration.api@capgemini.com.clientelng&password=Clientelling@123";
		ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
		// return response.getBody();
		System.out.println(response.getBody());

		String jsonString = response.toString();

		JSONArray data;
		String[] token = null;
		try {
			JSONObject jsonResult = new JSONObject(jsonString);
			data = jsonResult.getJSONArray("data");
			if (data != null) {
				token = new String[data.length()];
				for (int i = 0; i < data.length(); i++) {
					token[i] = (String) data.get(0);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(token);
		// token[i]= data.getString("access_token");

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
