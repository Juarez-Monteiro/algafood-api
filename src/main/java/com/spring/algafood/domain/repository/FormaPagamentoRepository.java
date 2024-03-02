package com.spring.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.algafood.domain.model.FormaPagamento;
@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

}
