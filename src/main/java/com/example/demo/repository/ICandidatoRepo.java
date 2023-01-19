package com.example.demo.repository;

import java.util.List;

import com.example.demo.sevee.repository.modelo.Candidato;

public interface ICandidatoRepo {

	List<Candidato> buscarPorVuelta(Boolean vuelta);
	List<Candidato> todosCandidatos();
}
