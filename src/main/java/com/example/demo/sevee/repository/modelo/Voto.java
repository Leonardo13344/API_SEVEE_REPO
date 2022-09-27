package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "voto_nombre_candidato")
	private String nombreCandidato;
	
	@Column(name = "voto_votos_totales")
	private BigInteger votosTotales;
	
	@Column(name = "voto_votos_nulos")
	private BigInteger votosNulos;
	
	@Column(name = "voto_votos_blancos")
	private BigInteger votosBlancos;
	
	@Column(name = "voto_votos_ausentes")
	private BigInteger votosAusentes;
	
	@Column(name = "voto_votos_validos")
	private BigInteger votosValidos;
	
	@Column(name = "voto_votos_genero")
	private String genero;
	
	@ManyToOne
	@JoinColumn(name = "voto_cant_nombre")
	private Canton canton;
	
	@ManyToOne
	@JoinColumn(name = "voto_cand_nombre")
	private Candidato candidato;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCandidato() {
		return nombreCandidato;
	}

	public void setNombreCandidato(String nombreCandidato) {
		this.nombreCandidato = nombreCandidato;
	}

	public BigInteger getVotosTotales() {
		return votosTotales;
	}

	public void setVotosTotales(BigInteger votosTotales) {
		this.votosTotales = votosTotales;
	}

	public BigInteger getVotosNulos() {
		return votosNulos;
	}

	public void setVotosNulos(BigInteger votosNulos) {
		this.votosNulos = votosNulos;
	}

	public BigInteger getVotosBlancos() {
		return votosBlancos;
	}

	public void setVotosBlancos(BigInteger votosBlancos) {
		this.votosBlancos = votosBlancos;
	}

	public BigInteger getVotosAusentes() {
		return votosAusentes;
	}

	public void setVotosAusentes(BigInteger votosAusentes) {
		this.votosAusentes = votosAusentes;
	}

	public BigInteger getVotosValidos() {
		return votosValidos;
	}

	public void setVotosValidos(BigInteger votosValidos) {
		this.votosValidos = votosValidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
	
	
	
}
