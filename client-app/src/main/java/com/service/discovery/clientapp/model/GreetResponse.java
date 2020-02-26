package com.service.discovery.clientapp.model;

public class GreetResponse {
	
	private String response;
	private int port;

	public GreetResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
