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
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;

@RestController
@RequestMapping("/votos")
@CrossOrigin("http://localhost:8080/")
public class VotoRestFulController {

	@Autowired
	private IVotoService votoService;

	@GetMapping(path = "/votos/{numLista}")
	public List<Voto> muestraVotosAsopciados(@PathVariable("numLista") String numLista) {
		return this.votoService.votosAsociadoCandidato(numLista, true);
	}

	@GetMapping(path = "/votosCandidatoGeneral/{codCandidato}/{vuelta}")
	public BigInteger muestraVotosCandidato(@PathVariable("codCandidato")Integer codCandidato,@PathVariable("vuelta") Boolean vuelta) {
		return this.votoService.votoGeneralPorCandidato(codCandidato,vuelta) ;
	}

	@GetMapping(path = "/votosCandidatoGeneroGeneral/{codCandidato}/{genero}/{vuelta}")
	public BigInteger muestraVotosCandidatoGeneral(@PathVariable("codCandidato") Integer codCandidato,
			@PathVariable("genero") String genero, @PathVariable("vuelta") Boolean vuelta) {
		return this.votoService.votoCandidatoGeneroGeneral(codCandidato,genero, vuelta);
	}

}
