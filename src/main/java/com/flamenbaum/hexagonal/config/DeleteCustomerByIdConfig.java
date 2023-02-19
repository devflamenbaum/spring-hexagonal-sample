package com.flamenbaum.hexagonal.config;

import com.flamenbaum.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.flamenbaum.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.flamenbaum.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.flamenbaum.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.flamenbaum.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.flamenbaum.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
