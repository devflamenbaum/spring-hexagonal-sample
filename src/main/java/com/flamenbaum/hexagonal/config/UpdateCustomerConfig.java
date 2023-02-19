package com.flamenbaum.hexagonal.config;

import com.flamenbaum.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.flamenbaum.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.flamenbaum.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.flamenbaum.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.flamenbaum.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
