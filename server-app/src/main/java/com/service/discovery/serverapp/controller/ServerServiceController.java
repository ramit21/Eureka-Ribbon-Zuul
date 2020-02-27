package com.service.discovery.serverapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.discovery.serverapp.model.GreetResponse;

@RestController
public class ServerServiceController {

	@Autowired
	private Environment env;
	
	@GetMapping("/server-app-service/greet/{name}")
	public GreetResponse getGreetingMessage(@PathVariable String name) {
		GreetResponse response = new GreetResponse("Hello "+name, 
				Integer.parseInt(env.getProperty("local.server.port")));
		return response;
	}
}

