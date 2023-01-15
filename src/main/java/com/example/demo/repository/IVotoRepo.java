package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Candidato;
import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;

public interface IVotoRepo {

	//2
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta);
	
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);
	
	//5
	List<CandidatoGenero> votoGeneralPorCandidato(CandidatoGenero candidatoGen);

    //12
    List<CandidatoGenero> votoCandidatoGeneroGeneral(CandidatoGenero candidatoGen);
    
    List<Voto> votosValidosSum(Boolean vuelta);
    
    List<Voto> inforVueltaProvCant(Boolean vuelta, String provincia, String canton);
    
    List<Voto> votosSufragioPorGenero(Boolean vuelta, String genero );
}
