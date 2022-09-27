package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parroquia")
public class Parroquia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "parr_id")
	private Integer id;
	
	@Column(name = "parr_nombre")
	private String nombre;

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
	
	/*
	@ManyToOne
	@JoinColumn(name = "parr_cant_nombre")
	private Canton canton;
	*/
	
	
}
