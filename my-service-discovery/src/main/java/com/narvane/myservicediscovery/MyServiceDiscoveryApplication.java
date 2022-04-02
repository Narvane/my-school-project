package com.narvane.myservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyServiceDiscoveryApplication.class, args);
	}

}
