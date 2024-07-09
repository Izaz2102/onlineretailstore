package com.ors.shoppingservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-service")
public interface OrderServiceClient {
}
