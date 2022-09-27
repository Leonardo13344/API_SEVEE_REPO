package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "voto_id")
	private Integer id;

	@Column(name = "cand_nombre")
	private String nombre;
	
	@Column(name = "cand_dignidad_codigo")
	private Integer dignidadCodigo;
	
	@Column(name = "cand_votos_primera_v")
	private BigInteger votosPrimeraV;
	
	@Column(name = "cand_votos_segunda_v")
	private BigInteger votosSegundaV;
	
	@Column(name = "cand_lista_perteneciente")
	private Integer listaPerteneciente;
	
	@OneToMany(mappedBy = "candidato", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDignidadCodigo() {
		return dignidadCodigo;
	}

	public void setDignidadCodigo(Integer dignidadCodigo) {
		this.dignidadCodigo = dignidadCodigo;
	}

	public BigInteger getVotosPrimeraV() {
		return votosPrimeraV;
	}

	public void setVotosPrimeraV(BigInteger votosPrimeraV) {
		this.votosPrimeraV = votosPrimeraV;
	}

	public BigInteger getVotosSegundaV() {
		return votosSegundaV;
	}

	public void setVotosSegundaV(BigInteger votosSegundaV) {
		this.votosSegundaV = votosSegundaV;
	}

	public Integer getListaPerteneciente() {
		return listaPerteneciente;
	}

	public void setListaPerteneciente(Integer listaPerteneciente) {
		this.listaPerteneciente = listaPerteneciente;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	
	
}
