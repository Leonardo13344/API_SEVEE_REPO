package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sevee.repository.modelo.Voto;

@Service
public class VotoServiceImpl implements IVotoService {

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
}
