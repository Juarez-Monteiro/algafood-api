package com.spring.algafood.domain.repository;

import java.util.List;

import com.spring.algafood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	Estado salvar(Estado estado);
	Estado buscar(Long id);
	void remover(Long id);
	
}
