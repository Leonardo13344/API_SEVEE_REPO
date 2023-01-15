package com.example.demo.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IActaRepo;
import com.example.demo.repository.IVotoRepo;
import com.example.demo.sevee.repository.modelo.Acta;
import com.example.demo.sevee.repository.modelo.Candidato;
import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;

@Service
public class VotoServiceImpl implements IVotoService {

	@Autowired
	private IVotoRepo votoRepo;
	
	@Autowired
	private IActaRepo actaRepo;
	
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
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta) {
		List<Voto> lista = this.votoRepo.votosAsociadoCandidato(num_lista, vuelta);
		return lista;
	}
	
	@Override
	@Async
	public BigInteger votoGeneralPorCandidato(Integer codCandidato, Boolean vuelta) {
		// TODO Auto-generated method stub
		List<CandidatoGenero> lista = this.votoRepo.votoGeneralPorCandidato(new CandidatoGenero(codCandidato,vuelta));
		BigInteger acum = new BigInteger("0");
		for (CandidatoGenero voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}

	@Override
	@Async
	public BigInteger votoCandidatoGeneroGeneral(Integer codCandidato, String genero, Boolean vuelta) {
		List<CandidatoGenero> lista = this.votoRepo.votoCandidatoGeneroGeneral(new CandidatoGenero(genero,codCandidato,vuelta));
		BigInteger acum = new BigInteger("0");
		for (CandidatoGenero voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}
	
	public BigInteger votoValidoSum(Boolean vuelta){
		List<Voto> votosValidos = this.votoRepo.votosValidosSum(vuelta);
		String actTipo = "";
		if(vuelta) {
			actTipo = "presi1v";
		}else {
			actTipo = "presi2v";
		}
		List<Acta> blancos = this.actaRepo.votosBlancos(actTipo);
		List<Acta> nulos = this.actaRepo.votosNulos(actTipo);
		BigInteger sum = new BigInteger("0");
		for(Voto voto : votosValidos) {
			sum = sum.add(voto.getValidos());
		}
		for(Acta voto : blancos) {
			sum = sum.add(voto.getBlancos());
		}
		for(Acta voto : nulos) {
			sum = sum.add(voto.getNulos());
		}
		return sum;

	}

	@Override
	public List<Candidato> inforVueltaProvCant(Boolean vuelta, String provincia, String canton) {
		// TODO Auto-generated method stub
		List<Voto> votos = this.votoRepo.inforVueltaProvCant(vuelta, provincia, canton);
		//System.out.println(votos.get(0).getCandidato().getNombre());
		List<Candidato> candidatos = new ArrayList<>();
		for(Voto voto: votos) {
			candidatos.add(voto.getCandidato());
		}
		//votos.stream().map((v) -> v.getCandidato()).collect(Collectors.toList())
		return candidatos;
	}
}
