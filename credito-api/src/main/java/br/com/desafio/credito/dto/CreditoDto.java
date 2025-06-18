package br.com.desafio.credito.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.desafio.credito.entity.Credito;

public record CreditoDto( 
    String numeroCredito,
	String numeroNfse,
	LocalDate dataConstituicao,
	BigDecimal valorIssqn,
	String tipoCredito,
	String simplesNacional,
	BigDecimal aliquota,
	BigDecimal valorFaturado,
	BigDecimal valorDeducao,
	BigDecimal baseCalculo
) {
    public static CreditoDto from(Credito credito) {
        return new CreditoDto(
            credito.getNumeroCredito(),
            credito.getNumeroNfse(),
            credito.getDataConstituicao(),
            credito.getValorIssqn(),
            credito.getTipoCredito(),
            credito.isSimplesNacional() ? "Sim" : "Não",
            credito.getAliquota(),
            credito.getValorFaturado(),
            credito.getValorDeducao(),
            credito.getBaseCalculo()
        );
    }
}
