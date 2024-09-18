package com.space.traffic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "com.space.traffic.ws.rest")
public class ProjectoCliengoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectoCliengoApplication.class, args);
	}

}
