package br.com.desafio.credito.controller;

import br.com.desafio.credito.service.CreditoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.credito.dto.CreditoDto;

@RestController
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoService creditoService;

    @GetMapping("/creditos/{numeroNfse}")
    public ResponseEntity<List<CreditoDto>> consultarCreditoPorNotaFiscal(@PathVariable String numeroNfse) {
        return ResponseEntity.ok(creditoService.consultarCreditoPorNotaFiscal(numeroNfse));
    }
    
}
