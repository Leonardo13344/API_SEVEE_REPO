package com.example.demo.sevee.repository.modelo.to;

import java.math.BigInteger;

public class CandidatoGenero {
	private String genero;
	private Integer codCandidato ;
	private String candidatoNombre;
	private String candidatoApellido;
	private Boolean vuelta;
	private Integer idProvincia;
	private Integer idCanton;
	private BigInteger validos;
	private String provNombre;
	private String cantNombre;
	
	
	public CandidatoGenero() {
		
	}
		
	public CandidatoGenero(Integer codCandidato, Boolean vuelta) {
		super();
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
	}
	
	public CandidatoGenero(Integer codCandidato, Boolean vuelta,BigInteger validos) {
		super();
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
		this.validos=validos;
	}
	
	public CandidatoGenero(String genero, Integer codCandidato, Boolean vuelta) {
		super();
		this.genero = genero;
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
	}

	public CandidatoGenero( Integer codCandidato, Boolean vuelta,String genero,BigInteger validos) {
		super();
		this.genero = genero;
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
		this.validos=validos;
	}


	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getCodCandidato() {
		return codCandidato;
	}
	public void setCodCandidato(Integer codCandidato) {
		this.codCandidato = codCandidato;
	}
	public boolean getVuelta() {
		return vuelta;
	}
	public void setVuelta(boolean vuelta) {
		this.vuelta = vuelta;
	}
	public Integer getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Integer getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}


	public BigInteger getValidos() {
		return validos;
	}


	public void setValidos(BigInteger validos) {
		this.validos = validos;
	}

	public String getProvNombre() {
		return provNombre;
	}

	public void setProvNombre(String provNombre) {
		this.provNombre = provNombre;
	}

	public String getCantNombre() {
		return cantNombre;
	}

	public void setCantNombre(String cantNombre) {
		this.cantNombre = cantNombre;
	}

	
	public String getCandidatoNombre() {
		return candidatoNombre;
	}

	public void setCandidatoNombre(String candidatoNombre) {
		this.candidatoNombre = candidatoNombre;
	}

	public void setVuelta(Boolean vuelta) {
		this.vuelta = vuelta;
	}
	
	

	public String getCandidatoApellido() {
		return candidatoApellido;
	}

	public void setCandidatoApellido(String candidatoApellido) {
		this.candidatoApellido = candidatoApellido;
	}
		
}
