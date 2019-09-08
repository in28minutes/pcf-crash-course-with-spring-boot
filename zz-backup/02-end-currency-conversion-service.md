<!---
Current Directory : /in28Minutes/git/pcf-crash-course-with-spring-boot/06-currency-conversion-service
-->

## Complete Code Example


### /Dockerfile

```
FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8100
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
```
---

### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.microservices</groupId>
	<artifactId>06-currency-conversion-service</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
	<name>pcf-currency-conversion-service</name>

	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.7.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
		<maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
		<spring-cloud.version>Greenwich.RELEASE</spring-cloud.version>
		<spring-cloud-services.version>2.1.2.RELEASE</spring-cloud-services.version>
	</properties>

	<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-sleuth</artifactId>
		</dependency>

     	<dependency>
			<groupId>io.pivotal.spring.cloud</groupId>
			<artifactId>spring-cloud-services-starter-service-registry</artifactId>
		</dependency>

		<dependency>
			<groupId>io.pivotal.spring.cloud</groupId>
			<artifactId>spring-cloud-services-starter-circuit-breaker</artifactId>
		</dependency>

		<dependency>
			<groupId>io.pivotal.spring.cloud</groupId>
			<artifactId>spring-cloud-services-starter-config-client</artifactId>
		</dependency> 
 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

<!--  
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>-->

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.1</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
		</dependency>
		<dependency>
			<groupId>javax.activation</groupId>
			<artifactId>activation</artifactId>
			<version>1.1.1</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- <dependency> <groupId>org.springframework.cloud</groupId> <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId> 
			</dependency> <dependency> <groupId>org.springframework.cloud</groupId> <artifactId>spring-cloud-starter-netflix-ribbon</artifactId> 
			</dependency> -->

	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>io.pivotal.spring.cloud</groupId>
				<artifactId>spring-cloud-services-dependencies</artifactId>
				<version>${spring-cloud-services.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<finalName>currency-conversion-service</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<!-- Docker -->
			<!-- <plugin> <groupId>com.spotify</groupId> <artifactId>dockerfile-maven-plugin</artifactId> 
				<version>1.4.10</version> <executions> <execution> <id>default</id> <goals> 
				<goal>build</goal> <goal>push</goal> </goals> </execution> </executions> 
				<configuration> <repository>in28min/${project.name}</repository> <tag>${project.version}</tag> 
				<skipDockerInfo>true</skipDockerInfo> </configuration> </plugin> -->
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>
</project>
```
---

### /manifest.yml

```
applications:
- name: currency-conversion-service
  disk_quota: 1G
  instances: 1
  memory: 512M
# https://github.com/cloudfoundry/java-buildpack/issues/663
  env:
    JAVA_OPTS: '-XX:ReservedCodeCacheSize=32M -XX:MaxDirectMemorySize=32M'
    JBP_CONFIG_OPEN_JDK_JRE: '[memory_calculator: {stack_threads: 30}]'  
  path: target/currency-conversion-service.jar
  timeout: 120
  routes:
  - route: currency-conversion-service-ranga-101.cfapps.io
  buildpacks:
  - https://github.com/cloudfoundry/java-buildpack.git
  stack: cflinuxfs3
  services:
  - naming-server
  - config-server
  - hystrix-dashboard
```
---

### /src/test/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplicationTests.java

```java
package com.in28minutes.microservices.currencyconversionservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyConversionServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /src/main/resources/bootstrap.properties

```properties
spring.cloud.config.uri=http://localhost:8888
```
---

### /src/main/resources/application.properties

```properties
spring.application.name=currency-conversion-service
server.port=8100

management.endpoints.web.base-path=/manage
management.endpoints.web.exposure.include=*

eureka.client.service-url.default-zone=http://localhost:8761/eureka

#logging.level.org.springframework=debug

spring.security.user.name=in28minutes
spring.security.user.password=dummy
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/util/environment/EnvironmentConfigurationLogger.java

```java
package com.in28minutes.microservices.currencyconversionservice.util.environment;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentConfigurationLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentConfigurationLogger.class);

	@SuppressWarnings("rawtypes")
	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		final Environment environment = event.getApplicationContext().getEnvironment();
		LOGGER.info("====== Environment and configuration ======");
		LOGGER.info("Active profiles: {}", Arrays.toString(environment.getActiveProfiles()));
		final MutablePropertySources sources = ((AbstractEnvironment) environment).getPropertySources();
		StreamSupport.stream(sources.spliterator(), false).filter(ps -> ps instanceof EnumerablePropertySource)
				.map(ps -> ((EnumerablePropertySource) ps).getPropertyNames()).flatMap(Arrays::stream).distinct()
				.forEach(prop -> {
					LOGGER.info("{}", prop);
//					Object resolved = environment.getProperty(prop, Object.class);
//					if (resolved instanceof String) {
//						LOGGER.info("{}", environment.getProperty(prop));
//					}
				});
		LOGGER.info("===========================================");
	}

}
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/util/environment/InstanceInformationService.java

```java
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
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/security/SecurityConfiguration.java

```java
package com.in28minutes.microservices.currencyconversionservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests().anyRequest().permitAll()
        .and()
        .httpBasic().disable()
        .csrf().disable();
  }
}
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java

```java
package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.in28minutes.microservices.currencyconversionservice.resource")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/resource/CurrencyConversionController.java

```java
package com.in28minutes.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyconversionservice.util.environment.InstanceInformationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class CurrencyConversionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private InstanceInformationService instanceInformationService;

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@Value("${CONVERSION_PROFIT_PERCENTAGE:5}")
	private int conversionProfitPercentage;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod="convertCurrencyFallback")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		LOGGER.info("Received Request to convert from {} {} to {}. Profit - {} ", quantity, from, to, conversionProfitPercentage);

		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		//5
		BigDecimal HUNDRED = BigDecimal.valueOf(100);

		//100-5 - 95 - 0.95
		BigDecimal conversionMultiple = HUNDRED.subtract(
				BigDecimal.valueOf(conversionProfitPercentage)).divide(HUNDRED);
		
		//500 - 500 * 0.95 = 
		BigDecimal convertedValue = quantity.multiply(response.getConversionMultiple())
										.multiply(conversionMultiple);

		String conversionEnvironmentInfo = instanceInformationService.retrieveInstanceInfo();

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				convertedValue, response.getExchangeEnvironmentInfo(), conversionEnvironmentInfo);
	}
	
	public CurrencyConversionBean convertCurrencyFallback(String from,String to,
			BigDecimal quantity) {
		return new CurrencyConversionBean(0l, from, to, BigDecimal.ZERO, quantity,
				BigDecimal.ZERO, "An Error Occured", "An Error Occured");
	}

}
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/resource/CurrencyExchangeServiceProxy.java

```java
package com.in28minutes.microservices.currencyconversionservice.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

////http://localhost:8000
//@FeignClient(name = "currency-exchange-service", url="${CURRENCY_EXCHANGE_URI:http://localhost:8000}")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	///currency-exchange/from/EUR/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
```
---

### /src/main/java/com/in28minutes/microservices/currencyconversionservice/resource/CurrencyConversionBean.java

```java
package com.in28minutes.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;

	private String from;

	private String to;

	private BigDecimal conversionMultiple;

	private BigDecimal quantity;

	private BigDecimal totalCalculatedAmount;

	private String exchangeEnvironmentInfo;
	
	private String conversionEnvironmentInfo;

	public CurrencyConversionBean() {

	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, String exchangeEnvironmentInfo, String conversionEnvironmentInfo) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.exchangeEnvironmentInfo = exchangeEnvironmentInfo;
		this.conversionEnvironmentInfo = conversionEnvironmentInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getExchangeEnvironmentInfo() {
		return exchangeEnvironmentInfo;
	}

	public void setExchangeEnvironmentInfo(String environmentInfo) {
		this.exchangeEnvironmentInfo = environmentInfo;
	}

	public String getConversionEnvironmentInfo() {
		return conversionEnvironmentInfo;
	}

	public void setConversionEnvironmentInfo(String conversionEnvironmentInfo) {
		this.conversionEnvironmentInfo = conversionEnvironmentInfo;
	}

}
```
---
