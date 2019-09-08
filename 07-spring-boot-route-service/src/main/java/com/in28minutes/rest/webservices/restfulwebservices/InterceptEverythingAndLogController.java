package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
public class InterceptEverythingAndLogController {

	//The X-CF-Forwarded-Url header contains the originally requested URL. 
	//The route service may choose to forward the request to this URL or to another.
	private static final String X_CF_FORWARDED_URL_HEADER = "X-CF-Forwarded-Url";

	private final static Logger LOGGER = LoggerFactory.getLogger(InterceptEverythingAndLogController.class);

	@Autowired
	private RestOperations restOperations;

	@RequestMapping()
	public ResponseEntity<byte[]> logRequestAndExecute(RequestEntity<byte[]> incomingRequest) {

		LOGGER.info("Intercepted Request: {}", incomingRequest);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.putAll(incomingRequest.getHeaders());

		URI uri = headers.remove(X_CF_FORWARDED_URL_HEADER).stream().findFirst().map(URI::create)
				.orElseThrow(() -> new RuntimeException("Header is missing " + X_CF_FORWARDED_URL_HEADER));

		RequestEntity<byte[]> outgoingRequest = new RequestEntity<>(incomingRequest.getBody(), headers, incomingRequest.getMethod(), uri);

		// Execute the request specified in the given RequestEntity and 
		// return the response as ResponseEntity.
		ResponseEntity<byte[]> response = restOperations.exchange(outgoingRequest, byte[].class);
		
		LOGGER.info("Sent Response: {}", response);
		
		return response;
	}
}