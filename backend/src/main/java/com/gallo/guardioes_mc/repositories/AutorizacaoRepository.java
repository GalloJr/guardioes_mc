package com.gallo.guardioes_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallo.guardioes_mc.entities.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
	public Autorizacao findByNome(String nome);
}