package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.ProvinciaDTO;

@Transactional
@Repository
public class ProvinciaRepoimpl implements IProvinciaRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public ProvinciaDTO obtenerDatos(Integer idProvincia, Integer idCanton, Integer idParroquia) {
		// TODO Auto-generated method stub
		TypedQuery<ProvinciaDTO> myQ = this.em.createQuery(
				"SELECT DISTINCT new com.example.demo.sevee.repository.modelo.to.ProvinciaDTO(v.provincia,v.canton,v.parroquia) FROM Voto v "
				+ "WHERE v.provincia.id=:idProvincia AND v.canton.id=:idCanton AND v.parroquia.id=:idParroquia",
				ProvinciaDTO.class);
		return myQ.setParameter("idProvincia", idProvincia)
				.setParameter("idCanton", idCanton)
				.setParameter("idParroquia", idParroquia)
				.getSingleResult();
	}

	@Override
	public ProvinciaDTO obtenerHastaCanton(Integer idProvincia, Integer idCanton) {
		TypedQuery<ProvinciaDTO> myQ = this.em.createQuery(
				"SELECT DISTINCT new com.example.demo.sevee.repository.modelo.to.ProvinciaDTO(v.provincia,v.canton) FROM Voto v "
				+ "WHERE v.provincia.id=:idProvincia AND v.canton.id=:idCanton",
				ProvinciaDTO.class);
		return myQ.setParameter("idProvincia", idProvincia)
				.setParameter("idCanton", idCanton)
				.getSingleResult();
	}

}
