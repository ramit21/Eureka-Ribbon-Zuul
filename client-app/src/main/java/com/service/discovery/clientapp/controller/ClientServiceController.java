package com.service.discovery.clientapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.discovery.clientapp.model.GreetResponse;

@RestController
public class ClientServiceController {
	
	@Autowired
	private Environment env; //provided by spring
	
	@Autowired
	private ClientAppServiceProxy proxy;
	
	@GetMapping("/client-app-service/greet/{name}")
	public GreetResponse getGreetingFeign(@PathVariable String name) {
		GreetResponse response = proxy.getGreetingMessage("Ramit");
		response.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return response;
	}
}
