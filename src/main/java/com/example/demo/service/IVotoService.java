package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Voto;

public interface IVotoService {

	// 2
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta);

	public BigInteger votoSuma(List<Voto> votosAsociadoACandidato, Integer prov_id);

	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);

	// 5
	BigInteger votoGeneralPorCandidato(Integer codCandidato, boolean vuelta, Integer idProvincia, Integer idCanton);

	// 12
	BigInteger muestraPorGenero(String genero, Integer codCandidato, boolean vuelta, Integer idProvincia,
			Integer idCanton);
	
	public BigInteger votoValidoSum(Boolean vuleta);
}
