package com.virtusa.virtusaConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class VirtusaConfigServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VirtusaConfigServerApplication.class, args);
	}

}
