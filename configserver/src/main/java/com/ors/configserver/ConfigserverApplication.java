package com.ors.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/*ms
@EnableDiscoveryClient
@EnableConfigServer*/
public class ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication.class, args);
	}

}
