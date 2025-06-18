package br.com.desafio.credito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.credito.entity.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {
    
    List<Credito> findAllByNumeroNfse(String numeroNfse);

    List<Credito> findAllByNumeroCredito(String numeroCredito);
}