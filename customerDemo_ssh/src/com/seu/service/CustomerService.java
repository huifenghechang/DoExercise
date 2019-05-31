package com.seu.service;

import com.seu.dao.CustomerDao;
import com.seu.dao.CustomerDaoImp;
import com.seu.entity.Customer;
import com.seu.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerService {
//    private CustomerDao customerDao;
//
//    public void setCustomerDao(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }

    public void saveCustomer(Customer customer){
        CustomerDao customerDao = new CustomerDaoImp();
        customerDao.saveCustomer(customer);
    }
    public List<Customer> findAll(){
        CustomerDao customerDao = new CustomerDaoImp();
        return customerDao.findAllCustomer();
    }
}
