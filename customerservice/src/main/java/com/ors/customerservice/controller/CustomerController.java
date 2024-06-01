package com.ors.customerservice.controller;

import com.ors.customerservice.dtos.CustomerDTO;
import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.entity.CustomerAddress;
import com.ors.customerservice.exceptions.NotFoundException;
import com.ors.customerservice.service.CustomerAddressService;
import com.ors.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/ors/v1/customers")
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
    //public List<CustomerDTO> getAllCustomers() throws NotFoundException {//2024
    public List<Customer> getAllCustomers() throws NotFoundException {
        return customerService.getAllCustomers();
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
        /*Optional<Customer> customer1 = customerService.getCustomerById(UUID.fromString(customerId));
        if (customer1.isPresent()) {
            customer.setCustomerId(UUID.fromString(customerId));
            customerAddressService.updateCustomerAddressById(customer1.get().getCustomerAddress().getCustomerAddressId(), customer1.getCustomerAddress());
            return customerService.addCustomer(customer);
        }else {
            throw new NotFoundException("Specified Customer not found");
        }*/
        return customerService.updateCustomer(customerId,customer);
    }
}
