package com.example.demo.sevee.repository.modelo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acta")
public class Acta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "act_id")
	private Integer id;
	
	@Column(name = "act_blancos")
	private BigInteger blancos;
	
	@Column(name = "act_nulos")
	private BigInteger nulos;
	
	@Column(name = "act_ausentes")
	private BigInteger ausentes;
	
	@Column(name = "act_codigo")
	private BigInteger codigo;
	
	@Column(name = "act_tipo")
	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigInteger getBlancos() {
		return blancos;
	}

	public void setBlancos(BigInteger blancos) {
		this.blancos = blancos;
	}

	public BigInteger getNulos() {
		return nulos;
	}

	public void setNulos(BigInteger nulos) {
		this.nulos = nulos;
	}

	public BigInteger getAusentes() {
		return ausentes;
	}

	public void setAusentes(BigInteger ausentes) {
		this.ausentes = ausentes;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
