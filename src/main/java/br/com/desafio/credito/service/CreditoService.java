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
}
