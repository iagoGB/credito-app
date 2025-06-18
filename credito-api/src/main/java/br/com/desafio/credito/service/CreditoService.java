package br.com.desafio.credito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.desafio.credito.dto.CreditoDto;
import br.com.desafio.credito.repository.CreditoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditoService {
    
    private final CreditoRepository creditoRepository;

    public List<CreditoDto> consultarPorNotaFiscal(String numeroNfse) {
        return creditoRepository.findAllByNumeroNfse(numeroNfse)
        .stream()
        .map(CreditoDto::from)
        .toList();
    }

    public List<CreditoDto> consultarPorNumeroCredito(String numeroCredito) {
        return creditoRepository.findAllByNumeroCredito(numeroCredito) 
        .stream()
        .map(CreditoDto::from)
        .toList();
    }
}
