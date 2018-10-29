package com.jpa.demo.service.impl;

import com.jpa.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * ICustomerQuery class
 *
 * @author Administrator
 * @date 2018/10/29
 */
public interface ICustomerQuery{
    //分页条件查询
    Page<Customer> findCustomerNoCriteria(Integer page, Integer size);
    Page<Customer> findCustomerCriteria(Integer page, Integer size, Customer bookQuery);
}
