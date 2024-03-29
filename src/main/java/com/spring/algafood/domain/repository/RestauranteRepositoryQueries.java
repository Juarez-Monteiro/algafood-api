package com.spring.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.spring.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {
	List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}
