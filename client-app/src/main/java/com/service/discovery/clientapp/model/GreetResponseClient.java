package com.service.discovery.clientapp.model;

/*
 * Replica class of GreetResponse for feignclient, as the actual response pojo
 * of the server is not available here.
 */
public class GreetResponseClient {
	
	private final String response;
	private final int port;

	public GreetResponseClient(String response, int port) {
		this.response = response;
		this.port = port;
	}

	public String getResponse() {
		return response;
	}

	public int getPort() {
		return port;
	}

}
