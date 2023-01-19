package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.sevee.repository.modelo.Candidato;

public interface ICandidatoService {
	Map<String, String> buscaPartidoPolitico(Boolean vuelta);
	List<Candidato> todosCandidatos();
}
