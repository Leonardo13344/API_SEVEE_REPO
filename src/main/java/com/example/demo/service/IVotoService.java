package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;
import com.example.demo.sevee.repository.modelo.to.TotalConteo;

public interface IVotoService {

	// 2
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta);

	public BigInteger votoSuma(List<Voto> votosAsociadoACandidato, Integer prov_id);

	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);

	// 5
	BigInteger votoGeneralPorCandidato(Integer codCandidato, Boolean vuelta);

	// 12
	BigInteger votoCandidatoGeneroGeneral(Integer codCandidato, String genero, Boolean vuelta);
	
	public BigInteger votoValidoSum(Boolean vuleta);
	
	BigInteger votosSufragioPorGenero(Boolean vuelta, String genero);
	
	List<CandidatoGenero> inforVueltaProvCant(Boolean vuelta, String provincia, String canton);

    public List<TotalConteo> votosTotalCandidato(Boolean vuelta);
}
