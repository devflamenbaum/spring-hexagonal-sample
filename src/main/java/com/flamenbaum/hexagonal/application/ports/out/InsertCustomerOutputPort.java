package com.flamenbaum.hexagonal.application.ports.out;

import com.flamenbaum.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
