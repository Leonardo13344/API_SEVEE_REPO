package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.sevee.repository.modelo.Voto;

@Repository
@Transactional
public class VotoRepoImpl implements IVotoRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato) {
	
		return null;
	}


}
