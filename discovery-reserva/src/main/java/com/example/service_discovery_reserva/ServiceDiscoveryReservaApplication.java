package com.example.service_discovery_reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryReservaApplication.class, args);
	}

}
