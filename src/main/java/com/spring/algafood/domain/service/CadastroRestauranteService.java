package com.spring.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
