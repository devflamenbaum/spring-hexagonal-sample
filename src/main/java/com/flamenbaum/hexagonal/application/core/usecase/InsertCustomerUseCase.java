package com.flamenbaum.hexagonal.application.core.usecase;

import com.flamenbaum.hexagonal.application.core.domain.Customer;
import com.flamenbaum.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.flamenbaum.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.flamenbaum.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.flamenbaum.hexagonal.application.ports.out.SendCpfForValidationOutPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutPort sendCpfForValidationOutPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutPort sendCpfForValidationOutPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutPort = sendCpfForValidationOutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutPort.send(customer.getCpf());
    }
}
