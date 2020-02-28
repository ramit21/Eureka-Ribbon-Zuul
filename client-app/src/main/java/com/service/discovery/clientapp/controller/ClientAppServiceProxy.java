package com.service.discovery.clientapp.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.discovery.clientapp.model.GreetResponseClient;

@FeignClient(name="server-app-service")
@RibbonClient(name="server-app-service")
public interface ClientAppServiceProxy {
	
	@GetMapping("/server-app-service/greet/{name}")
	public GreetResponseClient getGreetingMessage(@PathVariable("name") String name);
		
}
