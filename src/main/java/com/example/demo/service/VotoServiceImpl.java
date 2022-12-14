package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVotoRepo;
import com.example.demo.sevee.repository.modelo.Voto;

@Service
public class VotoServiceImpl implements IVotoService {

	@Autowired
	private IVotoRepo votoRepo;
	
	@Override
	public BigInteger votoSuma(List<Voto> votosAsociadoACandidato, Integer prov_id) {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("0");
		for (Voto voto : votosAsociadoACandidato) {
			if (voto.getProvincia().getId() == prov_id) {
				sum = sum.add(voto.getValidos());
			}
		}
		return sum;
	}

	@Override
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato) {
		BigInteger sum = new BigInteger("0");
		for (Voto voto : votosAsociadoACandidato) {
			if (voto.getGenero()=="M") {
				sum = sum.add(voto.getValidos());
			}
		}
		return sum;
	}
	
	@Override
	@Async
	public BigInteger votoGeneralPorCandidato(Integer codCandidato, boolean vuelta, Integer idProvincia,
											  Integer idCanton) {
		// TODO Auto-generated method stub
		BigInteger acum = new BigInteger("0");
		List<Voto> lista = this.votoRepo.votoGeneralPorCandidato(codCandidato, vuelta, idProvincia, idCanton);
		for (Voto voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}

	@Override
	@Async
	public BigInteger muestraPorGenero(String genero, Integer codCandidato, boolean vuelta, Integer idProvincia,
									   Integer idCanton) {
		List<Voto> lista = this.votoRepo.muestraPorGenero(genero, codCandidato, vuelta, idProvincia, idCanton);
		BigInteger acum = new BigInteger("0");
		for (Voto voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}

	@Override
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta) {
		List<Voto> lista = this.votoRepo.votosAsociadoCandidato(num_lista, vuelta);
		return lista;
	}
}
