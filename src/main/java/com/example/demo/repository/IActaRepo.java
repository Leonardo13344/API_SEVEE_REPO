package com.example.demo.repository;

import java.util.List;

import com.example.demo.sevee.repository.modelo.Acta;

public interface IActaRepo {
	
	public List<Acta> votosBlancos(String actTipo);

}
