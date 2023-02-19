package com.flamenbaum.hexagonal.application.core.usecase;

import com.flamenbaum.hexagonal.application.core.domain.Customer;
import com.flamenbaum.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.flamenbaum.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import java.util.Optional;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(RuntimeException::new);
    }
}
