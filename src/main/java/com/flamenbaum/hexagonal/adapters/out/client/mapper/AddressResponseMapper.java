package com.flamenbaum.hexagonal.adapters.out.client.mapper;

import com.flamenbaum.hexagonal.adapters.out.client.response.AddressResponse;
import com.flamenbaum.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
