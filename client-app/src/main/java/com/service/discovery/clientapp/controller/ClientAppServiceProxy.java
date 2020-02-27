package com.service.discovery.clientapp.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.discovery.clientapp.model.GreetResponseClient;

@FeignClient(name="client-app-service", url="localhost:8100")
public interface ClientAppServiceProxy {
	
	@GetMapping("/server-app-service/greet/{name}")
	public GreetResponseClient getGreetingMessage(@PathVariable("name") String name);
		
}
