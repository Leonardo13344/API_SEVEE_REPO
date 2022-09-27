package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "canton")
public class Canton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "cant_id")
	private Integer id;
	
	@Column(name = "cant_nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "cant_prov_nombre")
	private Provincia provincia;
	
	/*
	@OneToMany(mappedBy = "canton", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Parroquia> parroquia;
	*/

	@OneToMany(mappedBy = "canton", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	/*
	public List<Parroquia> getParroquia() {
		return parroquia;
	}

	public void setParroquia(List<Parroquia> parroquia) {
		this.parroquia = parroquia;
	}
	*/

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	
}
