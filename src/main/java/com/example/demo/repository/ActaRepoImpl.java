package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.sevee.repository.modelo.Acta;
import com.example.demo.sevee.repository.modelo.Voto;

@Repository
@Transactional
public class ActaRepoImpl implements IActaRepo{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Acta> votosBlancos(String actTipo) {
		// TODO Auto-generated method stub
		TypedQuery<Acta> myQuery = this.em
				.createQuery("SELECT a FROM Acta a WHERE a.tipo =: actTipo", Acta.class);
		myQuery.setParameter("actTipo", actTipo);
		return myQuery.getResultList();
	}

	@Override
	public List<Acta> votosNulos(String actTipo) {
		TypedQuery<Acta> myQuery = this.em
				.createQuery("SELECT a FROM Acta a WHERE a.tipo =: actTipo", Acta.class);
		myQuery.setParameter("actTipo", actTipo);
		return myQuery.getResultList();
	}
	@Override
	public List<Acta> votosAusentes(String actTipo) {
		TypedQuery<Acta> myQuery = this.em
				.createQuery("SELECT a FROM Acta a WHERE a.tipo =: actTipo", Acta.class);
		myQuery.setParameter("actTipo", actTipo);
		return myQuery.getResultList();
	}

}
