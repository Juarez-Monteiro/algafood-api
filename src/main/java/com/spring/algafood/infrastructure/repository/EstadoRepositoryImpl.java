package com.spring.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.algafood.domain.model.Estado;
import com.spring.algafood.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> listar(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return  manager.merge(estado);
	}

	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Estado estado = buscar(id);
		if (estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(estado);
	}	
	
}
