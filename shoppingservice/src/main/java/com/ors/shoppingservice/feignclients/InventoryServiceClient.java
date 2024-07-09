package com.ors.shoppingservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {
}
