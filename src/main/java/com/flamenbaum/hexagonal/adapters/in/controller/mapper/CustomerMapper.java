package com.flamenbaum.hexagonal.adapters.in.controller.mapper;

import com.flamenbaum.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.flamenbaum.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.flamenbaum.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCostumer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
