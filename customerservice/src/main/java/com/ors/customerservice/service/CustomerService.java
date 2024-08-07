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
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer not found.."+customerId));

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerEmail(customer.getCustomerEmail());
        existingCustomer.setCustomerBillingAddress(customer.getCustomerBillingAddress());
        existingCustomer.setCustomerShippingAddress(customer.getCustomerShippingAddress());

        //for single address
        /*CustomerAddress existingCusAdd = getCustomerAddress(customer, existingCustomer);
        customerAddressRepository.save(existingCusAdd);*/
        //for multiple address
        List<CustomerAddress> existingCusAddList = getCustomerAddressList(customer, existingCustomer);
        customerAddressRepository.saveAll(existingCusAddList);

        return customerRepository.save(existingCustomer);
    }

    private List<CustomerAddress> getCustomerAddressList(Customer customer, Customer existingCustomer) {
        List<CustomerAddress> existingCusAddList = existingCustomer.getCustomerAddressList();
        List<CustomerAddress> customerAddressList = customer.getCustomerAddressList();
        for (int i = 0; i < customerAddressList.size(); i++) {
            CustomerAddress existingCusAdd = existingCusAddList.get(i);
            existingCusAdd.setDoorNo(customerAddressList.get(i).getDoorNo());
            existingCusAdd.setStreetName(customerAddressList.get(i).getStreetName());
            existingCusAdd.setCity(customerAddressList.get(i).getCity());
            existingCusAdd.setLayoutName(customerAddressList.get(i).getLayoutName());
            existingCusAdd.setPinCode(customerAddressList.get(i).getPinCode());
        }
        return existingCusAddList;
    }

    private static CustomerAddress getCustomerAddress(Customer customer, Customer existingCustomer) {
        CustomerAddress existingCusAdd = existingCustomer.getCustomerAddressList().get(0);

        existingCusAdd.setDoorNo(customer.getCustomerAddressList().get(0).getDoorNo());
        existingCusAdd.setStreetName(customer.getCustomerAddressList().get(0).getStreetName());
        existingCusAdd.setCity(customer.getCustomerAddressList().get(0).getCity());
        existingCusAdd.setLayoutName(customer.getCustomerAddressList().get(0).getLayoutName());
        existingCusAdd.setPinCode(customer.getCustomerAddressList().get(0).getPinCode());
        return existingCusAdd;
    }
}
