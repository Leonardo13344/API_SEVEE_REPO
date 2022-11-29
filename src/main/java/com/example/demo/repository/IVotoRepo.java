package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Voto;

public interface IVotoRepo {
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato);
}
