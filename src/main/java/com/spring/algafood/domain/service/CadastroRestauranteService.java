package com.spring.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spring.algafood.domain.exception.EntidadeEmUsoException;
import com.spring.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.spring.algafood.domain.model.Cozinha;
import com.spring.algafood.domain.model.Restaurante;
import com.spring.algafood.domain.repository.CozinhaRepository;
import com.spring.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cozinha com código %d", cozinhaId)));
	
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}

	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
			
		}catch(EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro com o código %d ", restauranteId));	
		
		}catch(DataIntegrityViolationException e){
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", restauranteId));
		
		}
	}
}
