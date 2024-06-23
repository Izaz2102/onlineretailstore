package com.ors.customerservice.service;

import com.ors.customerservice.dtos.CustomerDTO;
import com.ors.customerservice.entity.Customer;
import com.ors.customerservice.entity.CustomerAddress;
import com.ors.customerservice.exceptions.NotFoundException;
import com.ors.customerservice.repository.CustomerAddressRepository;
import com.ors.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerAddressRepository customerAddressRepository;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerAddressRepository customerAddressRepository) {
        this.customerRepository = customerRepository;
        this.customerAddressRepository = customerAddressRepository;
    }

    public Customer addCustomer(Customer customer) {
        //CustomerAddress customerAddress = customer.getCustomerAddressList().get(0);
        //customerAddressRepository.save(customerAddress);
        //customerRepository.save(customer);

        List<CustomerAddress> customerAddressList = customer.getCustomerAddressList();
        for(CustomerAddress customerAddress : customerAddressList) {
            customerAddressRepository.save(customerAddress);
        }
        customerRepository.save(customer);

        return customer;
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
    /*public List<CustomerDTO> getAllCustomers() throws NotFoundException {
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
    }*/
    public List<Customer> getAllCustomers() throws NotFoundException {
        List<Customer> allCust =  customerRepository.findAll();
        if (allCust.isEmpty()) {
            throw new NotFoundException("No customers found");
        }else {
            return allCust;
        }
    }
    public void deleteCustomerById(UUID customerId) {
        customerRepository.deleteById(customerId);
    }
    public Customer updateCustomer(UUID customerId, Customer customer) throws NotFoundException {
        Customer updatedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer not found.."+customerId));

        updatedCustomer.setCustomerName(customer.getCustomerName());
        updatedCustomer.setCustomerEmail(customer.getCustomerEmail());
        updatedCustomer.setCustomerBillingAddress(customer.getCustomerBillingAddress());
        updatedCustomer.setCustomerShippingAddress(customer.getCustomerShippingAddress());

        CustomerAddress updatedCustomerAddress = customerAddressRepository.findById(customer.getCustomerAddressList().get(0).getCustomerAddressId()).orElseThrow(() -> new NotFoundException("Customer Address not found.." + customer.getCustomerAddressList().get(0).getCustomerAddressId()));

        updatedCustomerAddress.setDoorNo(customer.getCustomerAddressList().get(0).getDoorNo());
        updatedCustomerAddress.setStreetName(customer.getCustomerAddressList().get(0).getStreetName());
        updatedCustomerAddress.setCity(customer.getCustomerAddressList().get(0).getCity());
        updatedCustomerAddress.setLayoutName(customer.getCustomerAddressList().get(0).getLayoutName());
        updatedCustomerAddress.setPinCode(customer.getCustomerAddressList().get(0).getPinCode());

        customerAddressRepository.save(updatedCustomerAddress);
        return customerRepository.save(updatedCustomer);
    }
}
