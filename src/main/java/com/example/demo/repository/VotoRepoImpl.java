package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	@Override
	public List<Voto> votoGeneralPorCandidato(Integer codCandidato, boolean vuelta, Integer idProvincia,
			Integer idCanton) {
		// TODO Auto-generated method stub
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.candidato.id=:codCandidato and v.vuelta=:vuelta and v.provincia.id=:idProv and v.canton.id=:idCanton",
				Voto.class);
		return myQ.setParameter("codCandidato", codCandidato)
				.setParameter("vuelta", vuelta)
				.setParameter("idProv", idProvincia)
				.setParameter("idCanton", idCanton)
				.getResultList();
	}

	@Override
	public List<Voto> muestraPorGenero(String genero, Integer codCandidato, boolean vuelta, Integer idProvincia,
									   Integer idCanton) {
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.candidato.id=:codCandidato and v.vuelta=:vuelta and v.genero=:genero and v.provincia.id=:idProv and v.canton.id=:idCanton",
				Voto.class);
		return myQ.setParameter("codCandidato", codCandidato).
				setParameter("vuelta", vuelta)
				.setParameter("genero", genero).
				setParameter("idProv", idProvincia).
				setParameter("idCanton", idCanton)
				.getResultList();
	}

	@Override
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta) {
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.candidatonumLista=:num_lista and v.vuelta=:vuelta",Voto.class);
		return myQ.setParameter("vuelta", vuelta).getResultList();
	}

	@Override
	public List<Voto> votosValidosSum(Boolean vuelta) {
		// TODO Auto-generated method stub
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.vuelta=:vuelta",Voto.class);
		return myQ.setParameter("vuelta", vuelta).getResultList();
	}
	

}
