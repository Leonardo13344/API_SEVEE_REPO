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
	@Column(name = "cand_id")
	private Integer id;

	@Column(name = "cand_nombres")
	private String nombre;
	
	@Column(name = "cand_apellidos")
	private String apellido;
	
	@Column(name = "cand_nombre_partido")
	private String nombrePartido;
	
	@Column(name = "cand_num_lista")
	private String numLista;
	
	@Column(name = "cand_dignidad")
	private BigInteger dignidad;
	
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombrePartido() {
		return nombrePartido;
	}

	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}

	public String getNumLista() {
		return numLista;
	}

	public void setNumLista(String numLista) {
		this.numLista = numLista;
	}

	public BigInteger getDignidad() {
		return dignidad;
	}

	public void setDignidad(BigInteger dignidad) {
		this.dignidad = dignidad;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	
	
	
	
}
