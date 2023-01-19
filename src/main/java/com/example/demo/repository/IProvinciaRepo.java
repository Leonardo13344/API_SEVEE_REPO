package com.example.demo.repository;

import java.util.List;

import com.example.demo.sevee.repository.modelo.to.ProvinciaDTO;

public interface IProvinciaRepo {

	
	ProvinciaDTO obtenerDatos(Integer idProvincia,Integer idCanton,Integer idParroquia);
	
	ProvinciaDTO obtenerHastaCanton(Integer idProvincia,Integer idCanton);
	
}
