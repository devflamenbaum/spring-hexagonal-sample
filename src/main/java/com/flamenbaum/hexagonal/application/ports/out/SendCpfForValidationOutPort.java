package com.flamenbaum.hexagonal.application.ports.out;

public interface SendCpfForValidationOutPort {

    void send(String cpf);
}
