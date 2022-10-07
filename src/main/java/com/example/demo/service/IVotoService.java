package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Voto;

public interface IVotoService {

	public BigInteger votoSuma(List<Voto> votosAsociadoACandidato, Integer prov_id);
}
