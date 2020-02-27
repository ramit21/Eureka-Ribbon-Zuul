package com.service.discovery.serverapp.model;

public class GreetResponse {
	
	private final String message;
	private final int port;

	public GreetResponse(String message, int port) {
		this.message = message;
		this.port = port;
	}

	public String getResponse() {
		return message;
	}

	public int getPort() {
		return port;
	}
	
}
