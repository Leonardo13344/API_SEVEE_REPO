package com.example.demo.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICandidatoRepo;
import com.example.demo.sevee.repository.modelo.Candidato;
import com.example.demo.sevee.repository.modelo.Voto;

@Service
public class CandidatoServiceImpl implements ICandidatoService {

	@Autowired
	private ICandidatoRepo candidatoRepo;

	@Autowired
	private IVotoService votoService;

	@Override
	public Map<String, String> buscaPartidoPolitico(Boolean vuelta) {
		// TODO Auto-generated method stub
		List<Candidato> candidatos = candidatoRepo.buscarPorVuelta(vuelta);

		Map<String, String> hasMap = new HashMap<>();

		for (Candidato c : candidatos) {
			hasMap.put(String.valueOf(c.getId()),
					"Nombe: [" + c.getNombre() + "] Numero de Lista: [" + c.getNumLista() + "]");
		}

		return hasMap;
	}

	public List<Double> porcentajeCandidato(BigInteger votoGeneral, List<Voto> votosAsociadoACandidato) {
		List<Double> porcentajesPorProvincia = new ArrayList<>();
		for (int i = 1; i <= 28; i++) {
			BigInteger votosPorProvincia = votoService.votoSuma(votosAsociadoACandidato, i);
			Double porcentajeDeLaProvincia = votosPorProvincia.divide(votoGeneral).doubleValue();
			porcentajesPorProvincia.add(porcentajeDeLaProvincia);
		}
		return porcentajesPorProvincia;
	}

	@Override
	public List<Candidato> todosCandidatos() {
		return this.candidatoRepo.todosCandidatos();
	}
}
