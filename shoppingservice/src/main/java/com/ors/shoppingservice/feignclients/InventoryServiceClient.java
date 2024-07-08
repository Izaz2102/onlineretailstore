package com.ors.shoppingservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product-service")
public interface InventoryServiceClient {
}
