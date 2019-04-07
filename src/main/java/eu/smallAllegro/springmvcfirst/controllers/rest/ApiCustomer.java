package eu.smallAllegro.springmvcfirst.controllers.rest;


import eu.smallAllegro.springmvcfirst.domain.Customer;
import eu.smallAllegro.springmvcfirst.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class ApiCustomer {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/")
    public List<Customer> getAllCustomers() {
        return service.listAllCustomers();
    }
}
