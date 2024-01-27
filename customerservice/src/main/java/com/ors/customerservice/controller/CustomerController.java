package com.ors.customerservice.controller;

import com.ors.customerservice.dtos.CustomerDTO;
import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.exceptions.NotFoundException;
import com.ors.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/ors/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    @GetMapping("/getCustomerById/{customerId}")
    //public CustomerDTO getCustomerById(@PathVariable("customerId") String customerId) throws NotFoundException {
    public Customer getCustomerById(@PathVariable("customerId") String customerId) throws NotFoundException{
        /*CustomerDTO dto = customerService.getCustomerById(UUID.fromString(customerId));
        if (dto.getCustomerId() == null) {
            throw new NotFoundException("Specified Customer not found");
        }
        return dto;*/
        Optional<Customer> customer = customerService.getCustomerById(UUID.fromString(customerId));
        if (customer.isPresent()) {
            return customer.get();
        }else {
            throw new NotFoundException("Specified Customer not found");
        }
    }
    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() throws NotFoundException {
        return customerService.getAllCustomers();
    }
}
