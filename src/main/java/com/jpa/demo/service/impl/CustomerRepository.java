package com.jpa.demo.service.impl;

import com.jpa.demo.entity.Customer;
import com.jpa.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerRepository class
 *
 * @author Administrator
 * @date 2018/10/29
 */
@Service
public class CustomerRepository implements ICustomerQuery {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerNoCriteria(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        return customerRepository.findAll(pageable);
    }
    @Override
    public Page<Customer> findCustomerCriteria(Integer page, Integer size, final Customer customerQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Customer> bookPage = customerRepository.findAll(new Specification<Customer>(){
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(null!=customerQuery.getId()&&!"".equals(customerQuery.getId())){
                    list.add(criteriaBuilder.equal(root.get("id").as(String.class), customerQuery.getId()));
                }
                if(null!=customerQuery.getFirstName()&&!"".equals(customerQuery.getFirstName())){
                    list.add(criteriaBuilder.equal(root.get("firstName").as(String.class), customerQuery.getFirstName()));
                }
                if(null!=customerQuery.getLastName()&&!"".equals(customerQuery.getLastName())){
                    list.add(criteriaBuilder.equal(root.get("lastName").as(String.class), customerQuery.getLastName()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        return bookPage;
    }
}
