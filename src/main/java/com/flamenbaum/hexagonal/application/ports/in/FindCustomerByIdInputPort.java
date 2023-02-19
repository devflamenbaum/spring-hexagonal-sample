package com.flamenbaum.hexagonal.application.ports.in;

import com.flamenbaum.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
