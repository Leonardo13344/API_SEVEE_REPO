package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto")
public class Voto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "voto_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "voto_cant_id")
	private Canton canton;
	
	@ManyToOne
	@JoinColumn(name = "voto_cand_id")
	private Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name = "voto_parr_id")
	private Parroquia parroquia;
	
	@ManyToOne
	@JoinColumn(name = "voto_prov_id")
	private Provincia provincia;
	
	@Column(name = "vot_validos")
	private BigInteger validos;
	
	@Column(name = "vot_genero")
	private String genero;
	
	@Column(name = "vot_vuelta")
	private boolean vuelta;
	
	@Column(name = "act_codigo")
	private BigInteger actaCodigo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public BigInteger getValidos() {
		return validos;
	}

	public void setValidos(BigInteger validos) {
		this.validos = validos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isVuelta() {
		return vuelta;
	}

	public void setVuelta(boolean vuelta) {
		this.vuelta = vuelta;
	}

	public BigInteger getActaCodigo() {
		return actaCodigo;
	}

	public void setActaCodigo(BigInteger actaCodigo) {
		this.actaCodigo = actaCodigo;
	}
	
	
	
}
