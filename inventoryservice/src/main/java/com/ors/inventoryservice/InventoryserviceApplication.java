package com.ors.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*ms
@EnableFeignClients
@EnableDiscoveryClient*/
public class InventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	}

}
