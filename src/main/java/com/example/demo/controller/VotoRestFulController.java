package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IActaService;
import com.example.demo.service.IVotoService;
import com.example.demo.sevee.repository.modelo.Voto;

@RestController
@RequestMapping("/votos")
@CrossOrigin("http://localhost:8080/")
public class VotoRestFulController {
	
	@Autowired
	private IVotoService votoService;

	@GetMapping(path="/votos/{numLista}")
	public List<Voto> muestraVotosAsopciados(@PathVariable("numLista") String numLista) {
		return this.votoService.votosAsociadoCandidato(numLista, true);
	}
	
	@GetMapping(path="/votosValidos/{vuelta}")
	public BigInteger votoValidoSum(@PathVariable("vuelta") String vuelta) {
		Boolean vuletaB = true;
		if(vuelta.equalsIgnoreCase("presi1v")) {
			vuletaB = true;
		}else {
			vuletaB = false;
		}
		return this.votoService.votoValidoSum(vuletaB);
	}
	
}
