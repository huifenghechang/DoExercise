package com.seu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.seu.entity.Customer;
import com.seu.service.CustomerService;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;


import java.util.List;

public class CustomerAction extends ActionSupport {
    public String list(){
        CustomerService customerService = new CustomerService();
        List<Customer> list = customerService.findAll();

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);
        return "list";
    }
}
