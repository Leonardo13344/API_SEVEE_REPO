package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Voto;

public interface IVotoRepo {

	//2
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta);
	
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);
	
	//5
	List<Voto> votoGeneralPorCandidato(Integer codCandidato, boolean vuelta, Integer idProvincia, Integer idCanton);

    //12
    List<Voto> muestraPorGenero(String genero,Integer codCandidato ,boolean vuelta,Integer idProvincia,Integer idCanton);
}
