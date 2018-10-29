package com.jpa.demo.repository;

import com.jpa.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ICustomerRepository class
 *
 * @author Administrator
 * @date 2018/10/29
 */
public interface ICustomerRepository  extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {
        List<Customer> findByLastName(String lastName);
        List<Customer> findByFirstName(String firstName);
        List<Customer> findCustomerByIdIsBetween(long id1, long id2);

        //范围查询
        @Query(value = "select id,firstName,lastName from Customer c where c.id>?1 and c.id<?2")
        List<Customer> findByidRange(long id1, long id2);

        //参数查询
        @Query(value = "select id,firstName,lastName from Customer c where c.id=:id")
        List<Customer> findCustomerById1(@Param("id") long id);

}
