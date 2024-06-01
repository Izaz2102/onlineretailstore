package com.ors.customerservice.service;

import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.repository.CustomerAddressRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerAddressServiceImpl implements CustomerAddressService{
    private final CustomerAddressRepository customerAddressRepository;

    public CustomerAddressServiceImpl(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }
    /*@Override
    public void deleteCustomerAddressById(UUID customerAddressId) {
        customerAddressRepository.deleteById(customerAddressId);
    }*/

    /*@Override
    public Customer updateCustomerAddressById(UUID customerAddressId, CustomerAddressService customerAddressService) {
        return customerAddressRepository.update
    }*/
}
