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
import com.example.demo.sevee.repository.modelo.Candidato;
import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoDTO;

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
	public BigInteger muestraVotosCandidato(@PathVariable("codCandidato") Integer codCandidato,
			@PathVariable("vuelta") Boolean vuelta) {
		return this.votoService.votoGeneralPorCandidato(codCandidato, vuelta);
	}

	@GetMapping(path = "/votosCandidatoGeneroGeneral/{codCandidato}/{genero}/{vuelta}")
	public BigInteger muestraVotosCandidatoGeneral(@PathVariable("codCandidato") Integer codCandidato,
			@PathVariable("genero") String genero, @PathVariable("vuelta") Boolean vuelta) {
		return this.votoService.votoCandidatoGeneroGeneral(codCandidato, genero, vuelta);
	}

	@GetMapping(path = "/votosGenero/{vuelta}/{genero}")
	public BigInteger votosTotalGenero(@PathVariable("vuelta") String vuelta, @PathVariable("genero") String genero) {
				
		Boolean vueltaB = true;
		if (vuelta.equalsIgnoreCase("presi1v")) {
			vueltaB = true;
		} else {
			vueltaB = false;
		}
			return this.votoService.votosSufragioPorGenero(vueltaB,genero);
		

	}

	@GetMapping(path = "/votosValidos/{vuelta}")
	public BigInteger votoValidoSum(@PathVariable("vuelta") String vuelta) {
		Boolean vueltaB = true;
		if (vuelta.equalsIgnoreCase("presi1v")) {
			vueltaB = true;
		} else {
			vueltaB = false;
		}
		return this.votoService.votoValidoSum(vueltaB);
	}

	@GetMapping(path = "/filtroIzquierdaCanton/{vuelta}/{provincia}/{canton}")
	public List<CandidatoDTO> busquedaIzquierda(@PathVariable("vuelta") Boolean vuelta,
			@PathVariable("provincia") String provincia, @PathVariable("canton") String canton) {
		return this.votoService.inforVueltaProvCant(vuelta, provincia.toUpperCase(), canton.toUpperCase());
	}
	
	
	@GetMapping(path = "/filtroIzquierdaParroquia/{vuelta}/{provincia}/{canton}/{parroquia}")
	public List<CandidatoDTO> busquedaIzquierdaParroquia(@PathVariable("vuelta") Boolean vuelta,
			@PathVariable("provincia") String provincia, @PathVariable("canton") String canton,@PathVariable("parroquia") String parroquia) {
		System.out.println(parroquia);
		return this.votoService.inforVueltaProvCantParr(vuelta, provincia.toUpperCase(), canton.toUpperCase(),parroquia.toUpperCase());
	}

}
