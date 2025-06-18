package br.com.desafio.credito.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaPublisherService {

    private static final String TOPIC = "log-consulta-nfse";
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarLog(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}
