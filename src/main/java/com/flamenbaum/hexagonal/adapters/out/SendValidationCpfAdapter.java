package com.flamenbaum.hexagonal.adapters.out;

import com.flamenbaum.hexagonal.application.ports.out.SendCpfForValidationOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class SendValidationCpfAdapter implements SendCpfForValidationOutPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);

    }
}
