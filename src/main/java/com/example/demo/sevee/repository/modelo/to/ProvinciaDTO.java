package com.example.demo.sevee.repository.modelo.to;

import java.io.Serializable;

import com.example.demo.sevee.repository.modelo.Canton;
import com.example.demo.sevee.repository.modelo.Parroquia;
import com.example.demo.sevee.repository.modelo.Provincia;

public class ProvinciaDTO implements Serializable{	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Provincia provincia;
	private Canton canton;
	private Parroquia parroquia;

	public ProvinciaDTO () {
		super();
	}
	
	public ProvinciaDTO(Provincia provincia, Canton canton, Parroquia parroquia) {
		super();
		this.provincia = provincia;
		this.canton = canton;
		this.parroquia = parroquia;
	}
	
	public ProvinciaDTO(Provincia provincia, Canton canton) {
		super();
		this.provincia = provincia;
		this.canton = canton;
	}

	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	@Override
	public String toString() {
		return "ProvinciaDTO [provincia=" + provincia + ", canton=" + canton + ", parroquia=" + parroquia + "]";
	}

//	@Override
//	public String toString() {
//		return "ProvinciaDTO [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + ", idCaton="
//				+ idCaton + ", nombreCanton=" + nombreCanton + ", idParroquia=" + idParroquia + ", nombreParroquia="
//				+ nombreParroquia + "]";
//	}

  
	
	
}
