package com.ors.customerservice.service;

import com.ors.customerservice.dtos.CustomerDTO;
import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.exceptions.NotFoundException;
import com.ors.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //public CustomerDTO getCustomerById(UUID customerId) {
    public Optional<Customer> getCustomerById(UUID customerId) {
/*      Optional<Customer> byId = customerRepository.findById(customerId);
        CustomerDTO customerDTO = new CustomerDTO();
        if (byId.isPresent()) {
            Customer customer = byId.get();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCustomerName(customer.getCustomerName());
            customerDTO.setCustomerEmail(customer.getCustomerEmail());
            customerDTO.setCustomerBillingAddress(customer.getCustomerBillingAddress());
            customerDTO.setCustomerShippingAddress(customer.getCustomerShippingAddress());
        }
        return customerDTO;*/
        return customerRepository.findById(customerId);
    }
    public List<CustomerDTO> getAllCustomers() throws NotFoundException {
        List<Customer> allCust =  customerRepository.findAll();
        if (allCust.isEmpty()) {
            throw new NotFoundException("No customers found");
        }else {
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            for (Customer customer : allCust) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerId(customer.getCustomerId());
                customerDTO.setCustomerName(customer.getCustomerName());
                customerDTO.setCustomerEmail(customer.getCustomerEmail());
                customerDTO.setCustomerBillingAddress(customer.getCustomerBillingAddress());
                customerDTO.setCustomerShippingAddress(customer.getCustomerShippingAddress());
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        }
    }
    public void deleteCustomerById(UUID customerId) {
        customerRepository.deleteById(customerId);
    }
}
