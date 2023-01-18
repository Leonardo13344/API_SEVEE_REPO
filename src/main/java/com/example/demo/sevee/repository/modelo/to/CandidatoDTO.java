package com.example.demo.sevee.repository.modelo.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CandidatoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Boolean vuelta;
	private String genero;
	private Integer codCandidato ;
	private String candidatoNombre;
	private String candidatoApellido;
	private BigInteger validos;
	private Integer idProvincia;
	private String provNombre;
	private Integer idCanton;
	private String cantNombre;
	private Integer idParroquia;
	private String nombreParroquia;
    private BigDecimal porcentaje;
    private BigInteger validosGeneral;
	
	public CandidatoDTO() {
		
	}
		
	public CandidatoDTO(Integer codCandidato, Boolean vuelta) {
		super();
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
	}
	
	public CandidatoDTO(Integer codCandidato, Boolean vuelta,BigInteger validos) {
		super();
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
		this.validos=validos;
	}
	
	public CandidatoDTO(String genero, Integer codCandidato, Boolean vuelta) {
		super();
		this.genero = genero;
		this.codCandidato = codCandidato;
		this.vuelta = vuelta;
	}

	public CandidatoDTO( Integer codCandidato, Boolean vuelta,String genero,BigInteger validos) {
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
	
	public Boolean getVuelta() {
		return vuelta;
	}
	
	public void setVuelta(Boolean vuelta) {
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

	public String getCandidatoApellido() {
		return candidatoApellido;
	}

	public void setCandidatoApellido(String candidatoApellido) {
		this.candidatoApellido = candidatoApellido;
	}
	
	
	public Integer getIdParroquia() {
		return idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
	}

	public String getNombreParroquia() {
		return nombreParroquia;
	}

	public void setNombreParroquia(String nombreParroquia) {
		this.nombreParroquia = nombreParroquia;
	}
	
	
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public BigInteger getValidosGeneral() {
		return validosGeneral;
	}

	public void setValidosGeneral(BigInteger validosGeneral) {
		this.validosGeneral = validosGeneral;
	}
		
}
