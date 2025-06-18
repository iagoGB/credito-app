package br.com.desafio.credito.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import br.com.desafio.credito.dto.CreditoDto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditoIntegrationTest {

    private static final String CREDITO_URL = "/creditos/%s";
    
    @Autowired
    private TestRestTemplate restTemplate;


    /* Testes elaborados conforme os dados informados na base. */
    @Test
    public void deveRetornarDoisCreditosAoBuscarPorNumeroNfse() {
        var url = CREDITO_URL.formatted("7891011");
        var response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CreditoDto>>() {}
            );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void deveRetornarUmObjetoCreditoAoBuscarPorNumeroCredito() {

        var url = CREDITO_URL.formatted("/credito/123456");
        var response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CreditoDto>>() {}
            );

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody().size()).isEqualTo(1);
        assertThat(response.getBody().get(0).numeroCredito()).isEqualTo("123456");
    }
}
