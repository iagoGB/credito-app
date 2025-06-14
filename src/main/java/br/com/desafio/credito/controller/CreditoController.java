package br.com.desafio.credito.controller;

import br.com.desafio.credito.service.CreditoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.credito.dto.CreditoDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDto>> consultarPorNotaFiscal(@PathVariable String numeroNfse) {
        return ResponseEntity.ok(creditoService.consultarPorNotaFiscal(numeroNfse));
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<List<CreditoDto>> consultarPorNumeroCredito(@PathVariable String numeroCredito) {
        return ResponseEntity.ok(creditoService.consultarPorNumeroCredito(numeroCredito));
    }

    
}
