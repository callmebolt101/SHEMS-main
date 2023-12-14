package com.example.shems.controller;

import com.example.shems.dto.CustomerDeviceLocationDTO;
import com.example.shems.model.Customer;
import com.example.shems.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

     @GetMapping("/{customerId}/devices-locations")
    public ResponseEntity<List<CustomerDeviceLocationDTO>> getCustomerDevicesAndLocations(@PathVariable Integer customerId) {
        LocalDate endDateLocal = LocalDate.now();

    // Start date 30 days before
        LocalDate startDateLocal = endDateLocal.minusDays(30);

// Convert to java.sql.Date
        Date startDate = Date.valueOf(startDateLocal);
        Date endDate = Date.valueOf(endDateLocal);  
        List<CustomerDeviceLocationDTO> data = customerService.getCustomerDevicesAndLocations(customerId, startDate, endDate);
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/test")
    public String testEndpoint() {
    return "Test endpoint response";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
        return customerService.update(id, customerDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteById(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}

