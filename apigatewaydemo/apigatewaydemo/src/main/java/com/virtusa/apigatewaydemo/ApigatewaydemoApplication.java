package com.virtusa.apigatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApigatewaydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewaydemoApplication.class, args);
	}

	@Bean
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
