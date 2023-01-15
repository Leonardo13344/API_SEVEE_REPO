package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;

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
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta) {
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.candidatonumLista=:num_lista and v.vuelta=:vuelta",Voto.class);
		return myQ.setParameter("vuelta", vuelta).getResultList();
	}

	@Override
	public List<CandidatoGenero> votoGeneralPorCandidato(CandidatoGenero candidatoGen) {
		// TODO Auto-generated method stub
		TypedQuery<CandidatoGenero> myQ = this.entityManager.createQuery(
				"SELECT new com.example.demo.sevee.repository.modelo.to.CandidatoGenero(v.candidato.id,v.vuelta,v.validos) "
						+ "FROM Voto v where v.candidato.id=:codCandidato and v.vuelta=:vuelta",
						CandidatoGenero.class);
		return myQ.setParameter("codCandidato", candidatoGen.getCodCandidato())
				.setParameter("vuelta", candidatoGen.getVuelta())
				.getResultList();
	}
	
	@Override
	public List<CandidatoGenero> votoCandidatoGeneroGeneral(CandidatoGenero candidatoGen) {
		// TODO Auto-generated method stub
		TypedQuery<CandidatoGenero> myQ = this.entityManager.createQuery(
				"SELECT new com.example.demo.sevee.repository.modelo.to.CandidatoGenero(v.candidato.id,v.vuelta,v.genero,v.validos) "
				+ "FROM Voto v where v.candidato.id=:codCandidato and v.vuelta=:vuelta and v.genero=:genero",
				CandidatoGenero.class);
		return myQ.setParameter("codCandidato", candidatoGen.getCodCandidato())
				.setParameter("vuelta", candidatoGen.getVuelta())
				.setParameter("genero", candidatoGen.getGenero())				
				.getResultList();
	}




	@Override
	public List<Voto> votosValidosSum(Boolean vuelta) {
		// TODO Auto-generated method stub
		TypedQuery<Voto> myQ = this.entityManager.createQuery(
				"SELECT v FROM Voto v where v.vuelta=:vuelta",Voto.class);
		return myQ.setParameter("vuelta", vuelta).getResultList();
	}
	

}
