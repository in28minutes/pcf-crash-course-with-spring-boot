package com.in28minutes.microservices.currencyconversionservice.util.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InstanceInformationService {

	private static final String ENV_IP_ADDRESS = "CF_INSTANCE_IP";

	private static final String DEFAULT_VALUE_IP_ADDRESS = "UNKNOWN";

	private static final String ENV_INSTANCE_GUID = "CF_INSTANCE_GUID";

	private static final String DEFAULT_ENV_INSTANCE_GUID = "UNKNOWN";

	// @Value(${ENVIRONMENT_VARIABLE_NAME:DEFAULT_VALUE})
	@Value("${" + ENV_IP_ADDRESS + ":" + DEFAULT_VALUE_IP_ADDRESS + "}")
	private String instanceIpAddress;

	@Value("${" + ENV_INSTANCE_GUID + ":" + DEFAULT_ENV_INSTANCE_GUID + "}")
	private String instanceGuid;

	public String retrieveInstanceInfo() {

		return instanceGuid + " : " + instanceIpAddress;
	}

}
