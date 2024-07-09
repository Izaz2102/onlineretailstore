package com.ors.shoppingservice.feignclients;

import com.ors.shoppingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

    @PostMapping("/addCustomer")
    public Customer addCustomer();
}
