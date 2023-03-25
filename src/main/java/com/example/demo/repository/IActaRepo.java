package com.example.demo.repository;

import java.util.List;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.example.demo.sevee.repository.modelo.Acta;

@State(Scope.Benchmark)
public interface IActaRepo {
	
	public List<Acta> votosBlancos(String actTipo);
	public List<Acta> votosNulos(String actTipo);
	public List<Acta> votosAusentes(String actTipo);

}
