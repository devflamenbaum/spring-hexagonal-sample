package com.flamenbaum.hexagonal.adapters.out;

import com.flamenbaum.hexagonal.adapters.out.repository.CustomerRepository;
import com.flamenbaum.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.flamenbaum.hexagonal.application.core.domain.Customer;
import com.flamenbaum.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerMapper;

    @Override
    public Optional<Customer> find(String id) {

        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(e -> customerMapper.toCustomer(e));
    }
}
