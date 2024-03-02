package com.spring.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.algafood.domain.model.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	
	
}
