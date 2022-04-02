package com.narvane.myreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyReportApplication.class, args);
	}

}
