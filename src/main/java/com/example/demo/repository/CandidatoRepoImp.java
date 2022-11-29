package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.sevee.repository.modelo.Candidato;

@Repository
@Transactional
public class CandidatoRepoImp implements ICandidatoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Candidato> buscarPorVuelta(Boolean vuelta) {
		// TODO Auto-generated method stub
		TypedQuery<Candidato> myQuery = this.entityManager.createQuery("SELECT DISTINCT c FROM Voto v JOIN v.candidato c WHERE v.vuelta =:vuelta", Candidato.class);
		myQuery.setParameter("vuelta", vuelta);
		return myQuery.getResultList();	
	}

}
