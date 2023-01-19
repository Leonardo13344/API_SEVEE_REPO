package com.example.demo.repository.DTO;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ResultadosNacionales {

	String NombreCandidato;
	String nombrePartido;
	BigInteger totalMujeres;
	BigInteger totalHombres;
	BigDecimal porcentaje;

	public ResultadosNacionales(String nombreCandidato, String nombrePartido, BigInteger totalMujeres,
			BigInteger totalHombres, BigDecimal porcentaje) {
		super();
		NombreCandidato = nombreCandidato;
		this.nombrePartido = nombrePartido;
		this.totalMujeres = totalMujeres;
		this.totalHombres = totalHombres;
		this.porcentaje = porcentaje;
	}

	public String getNombreCandidato() {
		return NombreCandidato;
	}

	public void setNombreCandidato(String nombreCandidato) {
		NombreCandidato = nombreCandidato;
	}

	public String getNombrePartido() {
		return nombrePartido;
	}

	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}

	public BigInteger getTotalMujeres() {
		return totalMujeres;
	}

	public void setTotalMujeres(BigInteger totalMujeres) {
		this.totalMujeres = totalMujeres;
	}

	public BigInteger getTotalHombres() {
		return totalHombres;
	}

	public void setTotalHombres(BigInteger totalHombres) {
		this.totalHombres = totalHombres;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

}
