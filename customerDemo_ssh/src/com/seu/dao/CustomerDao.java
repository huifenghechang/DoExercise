package com.seu.dao;

import com.seu.entity.Customer;

import java.util.List;

public interface CustomerDao {
    public void saveCustomer(Customer customer);
    public List<Customer> findAllCustomer();
}
