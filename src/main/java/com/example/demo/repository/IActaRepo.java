package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.sevee.repository.modelo.Acta;
import com.example.demo.sevee.repository.modelo.Voto;

public interface IActaRepo {
	
	public List<Acta> votosBlancos(String actTipo);
	public List<Acta> votosNulos(String actTipo);
	public List<Acta> votosAusentes(String actTipo);

}
