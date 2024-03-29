package com.spring.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.algafood.domain.exception.EntidadeEmUsoException;
import com.spring.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.spring.algafood.domain.model.Estado;
import com.spring.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
			
		}catch(EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro com o código %d ", estadoId));	
		
		}catch(DataIntegrityViolationException e){
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", estadoId));
		
		}
	}
	
}
