package com.jpa.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Customer class
 *
 * @author Administrator
 * @date 2018/10/29
 */
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName =firstName;
        this.lastName =lastName;
    }
}

