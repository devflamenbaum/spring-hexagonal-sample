package com.flamenbaum.hexagonal.application.ports.out;

import com.flamenbaum.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
