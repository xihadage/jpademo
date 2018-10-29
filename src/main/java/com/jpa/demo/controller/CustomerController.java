package com.jpa.demo.controller;

import com.jpa.demo.entity.Customer;
import com.jpa.demo.repository.ICustomerRepository;
import com.jpa.demo.service.impl.ICustomerQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CustomerController class
 *
 * @author Administrator
 * @date 2018/10/29
 */
@RestController
public class CustomerController {

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    ICustomerQuery customerQuery;

    @GetMapping(value="/insert")
    private void insert(){
        customerRepository.save(new Customer("Jack","Bauer"));
        customerRepository.save(new Customer("Chloe","Brian"));
    }
    @GetMapping(value="/findAll")
    private List<Customer> findAll(){
        return customerRepository.findAll();
    }
    @GetMapping(value="/findByFirstName")
    private List<Customer> findByFirstName(){
        return customerRepository.findByFirstName("Jack");
    }
    @GetMapping(value="/findByLastName")
    private List<Customer> findByLastName(){
        return customerRepository.findByLastName("Bauer");
    }
    @GetMapping(value="/findByidRange")
    private List<Customer> findByidRange(){
        return customerRepository.findByidRange(1,4);
    }

    @GetMapping(value="/findCustomerById1")
    private List<Customer> findCustomerById1(){
        return customerRepository.findCustomerById1(1);
    }
    @GetMapping(value="/findCustomerByIdIsBetween")
    private List<Customer> findCustomerByIdIsBetween(){
        return customerRepository.findCustomerByIdIsBetween(1,4);
    }


    @GetMapping(value="/findCustomerNoCriteria")
    private Page<Customer> findCustomerNoCriteria(){
        return customerQuery.findCustomerNoCriteria(0,2);
    }
    @GetMapping(value="/findCustomerCriteria")
    private Page<Customer> findCustomerCriteria(){
        return customerQuery.findCustomerCriteria(0,2,new Customer("Jack","Bauer"));
    }


}
