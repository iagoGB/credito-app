package br.com.desafio.credito.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.credito.entity.Credito;
import br.com.desafio.credito.repository.CreditoRepository;
import br.com.desafio.credito.service.CreditoService;

@ExtendWith(MockitoExtension.class)
public class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;


    @Test
    public void deveConverterCreditoParaCreditoDtoCorretamente(){
        var credito = new Credito(); 
        credito.setId(10L);
        credito.setNumeroNfse("123");
        credito.setSimplesNacional(true);

        when(creditoRepository.findAllByNumeroNfse(anyString())).thenReturn(List.of(credito));
        var creditos = creditoService.consultarPorNotaFiscal("123");

        assertEquals(1, creditos.size());
        assertEquals("123", creditos.get(0).numeroNfse());
        assertEquals("Sim", creditos.get(0).simplesNacional());
    }
    
}
