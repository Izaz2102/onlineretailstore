package com.ors.customerservice.controller;

import com.ors.customerservice.dtos.CustomerDTO;
import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.entity.CustomerAddress;
import com.ors.customerservice.exceptions.NotFoundException;
import com.ors.customerservice.service.CustomerAddressService;
import com.ors.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/ors/api/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    private CustomerAddressService customerAddressService;
    public CustomerController(CustomerService customerService, CustomerAddressService customerAddressService) {
        this.customerService = customerService;
        this.customerAddressService = customerAddressService;
    }
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {return customerService.addCustomer(customer);}
    @GetMapping("/getCustomerById/{customerId}")
    //public CustomerDTO getCustomerById(@PathVariable("customerId") String customerId) throws NotFoundException {
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) throws NotFoundException{
        /*CustomerDTO dto = customerService.getCustomerById(UUID.fromString(customerId));
        if (dto.getCustomerId() == null) {
            throw new NotFoundException("Specified Customer not found");
        }
        return dto;*/
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }else {
            throw new NotFoundException("Specified Customer not found");
        }
    }
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() throws NotFoundException {
    //public ResponseEntity<HttpStatus> getAllCustomers() throws NotFoundException {
        return customerService.getAllCustomers();
        //customerService.getAllCustomers();
        //return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCustomerById/{customerId}")
    public String deleteCustomerById(@PathVariable("customerId") UUID customerId) throws NotFoundException {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if (customer.isPresent()) {
            customerService.deleteCustomerById(customerId);
            //customerAddressService.deleteCustomerAddressById(customer.get().getCustomerAddress().getCustomerAddressId());//2024
            return "Customer deleted successfully";
        }else {
            throw new NotFoundException("Specified Customer not found");
        }
    }
    @PutMapping("/updateCustomerById/{customerId}")
    public Customer updateCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) throws NotFoundException {
        Optional<Customer> customer1 = customerService.getCustomerById(customerId);
        if (customer1.isPresent()) {
            return customerService.updateCustomer(customerId,customer);
        }else {
            throw new NotFoundException("Specified Customer not found");
        }
    }
}
