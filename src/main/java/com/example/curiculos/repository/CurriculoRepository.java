package com.example.curiculos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curiculos.entidade.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Long>{
	
}
