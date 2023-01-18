package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoDTO;

public interface IVotoRepo {

	//2
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta);
	
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);
	
	//5
	List<CandidatoDTO> votoGeneralPorCandidato(CandidatoDTO candidatoGen);

    //12
    List<CandidatoDTO> votoCandidatoGeneroGeneral(CandidatoDTO candidatoGen);
    
    List<Voto> votosValidosSum(Boolean vuelta);
    
    List<Voto> inforVueltaProvCant(Boolean vuelta, String provincia, String canton);
    
    List<Voto> inforVueltaProvCantParr(Boolean vuelta, String provincia, String canton,String parroquia);
    
    List<Voto> votosSufragioPorGenero(Boolean vuelta, String genero );
}
