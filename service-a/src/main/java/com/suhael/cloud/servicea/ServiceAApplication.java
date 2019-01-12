package com.suhael.cloud.servicea;

import com.suhael.cloud.servicea.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class ServiceAApplication {

	@Autowired
	private ServiceConfiguration configuration;

	@Value("${some.other.property}")
	private String someOtherProperty;

	@Value("${service.instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	@RequestMapping("/")
	public String message(@RequestHeader("x-location") String location) {
		return "Hello from " + instance + " from " + location;
	}

	@RequestMapping("/config")
	public String config(){
		StringBuilder sb = new StringBuilder();
		sb.append(configuration.getProperty());
		sb.append(" || ");
		sb.append(someOtherProperty);

		return sb.toString();
	}

}

