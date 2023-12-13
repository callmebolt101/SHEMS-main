package com.example.shems.service;

import com.example.shems.dto.CustomerDeviceLocationDTO;
import com.example.shems.model.Customer;
import com.example.shems.repository.CustomerDeviceLocationRepository;
import com.example.shems.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerDeviceLocationRepository repository;

    public List<CustomerDeviceLocationDTO> getCustomerDevicesAndLocations(Integer customerId) {
        return repository.findCustomerDevicesAndLocations(customerId);
    }
    
    // Get all customers
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Find a customer by ID
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    // Save or update a customer
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update a customer
    public Optional<Customer> update(Integer id, Customer customerDetails) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(customerDetails.getFirstName());
                    customer.setLastName(customerDetails.getLastName());
                    customer.setAddress(customerDetails.getAddress());
                    customer.setEmail(customerDetails.getEmail());
                    customer.setPhone(customerDetails.getPhone());
                    return customerRepository.save(customer);
                });
    }

    // Delete a customer
    public boolean deleteById(Integer id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return true;
                }).orElse(false);
    }
}

