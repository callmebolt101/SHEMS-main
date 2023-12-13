package com.example.shems.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer") // Ensure this matches the case of your table name in MySQL
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID") // This should match the exact column name in your database
    private Integer customerID;

    @Column(name = "FirstName", length = 100) // Match this with your database column name
    private String firstName;

    @Column(name = "LastName", length = 100) // Match this with your database column name
    private String lastName;

    @Column(name = "Address", length = 200) // Match this with your database column name
    private String address;

    @Column(name = "Email", length = 100, unique = true) // Match this with your database column name
    private String email;

    @Column(name = "Phone", length = 15) // Match this with your database column name
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<Device> devices;

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    // Getters and setters

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer CustomerID) {
        this.customerID = CustomerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }
}
