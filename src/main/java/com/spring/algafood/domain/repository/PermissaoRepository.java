package com.spring.algafood.domain.repository;

import java.util.List;

import com.spring.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao buscar(long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);
}
