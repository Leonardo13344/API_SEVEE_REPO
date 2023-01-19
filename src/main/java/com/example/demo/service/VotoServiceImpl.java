package com.example.demo.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IActaRepo;
import com.example.demo.repository.ICandidatoRepo;
import com.example.demo.repository.IVotoRepo;
import com.example.demo.repository.DTO.ResultadosNacionales;
import com.example.demo.sevee.repository.modelo.Acta;
import com.example.demo.sevee.repository.modelo.Candidato;
import com.example.demo.sevee.repository.modelo.Voto;
import com.example.demo.sevee.repository.modelo.to.CandidatoGenero;
import com.example.demo.sevee.repository.modelo.to.Funciones;

@Service
public class VotoServiceImpl implements IVotoService {

	@Autowired
	private IVotoRepo votoRepo;

	@Autowired
	private IActaRepo actaRepo;

	@Autowired
	private ICandidatoRepo candidatoRepo;

	@Override
	public BigInteger votoSuma(List<Voto> votosAsociadoACandidato, Integer prov_id) {
		// TODO Auto-generated method stub
		BigInteger sum = new BigInteger("0");
		for (Voto voto : votosAsociadoACandidato) {
			if (voto.getProvincia().getId() == prov_id) {
				sum = sum.add(voto.getValidos());
			}
		}
		return sum;
	}

	@Override
	public BigInteger muestraMasculino(List<Voto> votosAsociadoACandidato) {
		BigInteger sum = new BigInteger("0");
		for (Voto voto : votosAsociadoACandidato) {
			if (voto.getGenero() == "M") {
				sum = sum.add(voto.getValidos());
			}
		}
		return sum;
	}

	@Override
	public List<Voto> votosAsociadoCandidato(String num_lista, Boolean vuelta) {
		List<Voto> lista = this.votoRepo.votosAsociadoCandidato(num_lista, vuelta);
		return lista;
	}

	@Override
	@Async
	public BigInteger votoGeneralPorCandidato(Integer codCandidato, Boolean vuelta) {
		// TODO Auto-generated method stub
		List<CandidatoGenero> lista = this.votoRepo.votoGeneralPorCandidato(new CandidatoGenero(codCandidato, vuelta));
		BigInteger acum = BigInteger.ZERO;
		for (CandidatoGenero voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}

	@Override
	@Async
	public BigInteger votoCandidatoGeneroGeneral(Integer codCandidato, String genero, Boolean vuelta) {
		List<CandidatoGenero> lista = this.votoRepo
				.votoCandidatoGeneroGeneral(new CandidatoGenero(genero, codCandidato, vuelta));
		BigInteger acum = BigInteger.ZERO;
		for (CandidatoGenero voto : lista) {
			acum = acum.add(voto.getValidos());
		}
		return acum;
	}

	@Override
	public List<ResultadosNacionales> votoListaCandidatoGeneroGeneral( Boolean vuelta) {
		List<Candidato> listaCan = this.candidatoRepo.todosCandidatos();

		List<ResultadosNacionales> listResultadosNacionales = new ArrayList<>();
		for (Candidato candidato : listaCan) {
			BigInteger totalMujeres = this.votoCandidatoGeneroGeneral(candidato.getId(), "F", vuelta);
			BigInteger totalHombres = this.votoCandidatoGeneroGeneral(candidato.getId(), "M", vuelta);
			BigDecimal porcentaje = new BigDecimal(totalHombres.add(totalMujeres));
			
			listResultadosNacionales.add(new ResultadosNacionales(candidato.getApellido(),
					candidato.getNombrePartido(), totalMujeres, totalHombres, porcentaje));
		}
		
		return listResultadosNacionales;
	}

	@Override
	public BigInteger votosSufragioPorGenero(Boolean vuelta, String genero) {
		// TODO Auto-generated method stub
		List<Voto> votosGenero = this.votoRepo.votosSufragioPorGenero(vuelta, genero);
		BigInteger sum1 = new BigInteger("0");
		for (Voto voto : votosGenero) {
			sum1 = sum1.add(voto.getValidos());
		}
		return sum1;
	}

	public BigInteger votoValidoSum(Boolean vuelta) {
		List<Voto> votosValidos = this.votoRepo.votosValidosSum(vuelta);
		String actTipo = "";
		if (vuelta) {
			actTipo = "presi1v";
		} else {
			actTipo = "presi2v";
		}
		List<Acta> blancos = this.actaRepo.votosBlancos(actTipo);
		List<Acta> nulos = this.actaRepo.votosNulos(actTipo);
		BigInteger sum = new BigInteger("0");
		for (Voto voto : votosValidos) {
			sum = sum.add(voto.getValidos());
		}
		for (Acta voto : blancos) {
			sum = sum.add(voto.getBlancos());
		}
		for (Acta voto : nulos) {
			sum = sum.add(voto.getNulos());
		}
		return sum;
	}

	@Override
	public List<CandidatoGenero> inforVueltaProvCant(Boolean vuelta, String provincia, String canton) {
		// TODO Auto-generated method stub
		List<Voto> votos = this.votoRepo.inforVueltaProvCant(vuelta, provincia, canton);
		List<Integer> codCandList = votos.stream().filter(Funciones.distinctPorCodigo(c -> c.getCandidato().getId()))
				.map(x -> x.getCandidato().getId()).collect(Collectors.toList());

		List<CandidatoGenero> candidatos = new ArrayList<>();

		for (int i = 0; i < codCandList.size(); i++) {
			BigInteger acum1 = BigInteger.ZERO;
			for (int j = 0; j < votos.size(); j++) {
				if (codCandList.get(i).equals(votos.get(j).getCandidato().getId())) {
					acum1 = acum1.add(votos.get(j).getValidos());
				}
			}

			CandidatoGenero cg = new CandidatoGenero();
			cg.setCodCandidato(votos.get(i).getCandidato().getId());
			cg.setCandidatoNombre(votos.get(i).getCandidato().getNombre());
			cg.setCandidatoApellido(votos.get(i).getCandidato().getApellido());
			cg.setVuelta(vuelta);
			cg.setProvNombre(votos.get(i).getProvincia().getNombre());
			cg.setIdProvincia(votos.get(i).getProvincia().getId());
			cg.setCantNombre(votos.get(i).getCanton().getNombre());
			cg.setIdCanton(votos.get(i).getCanton().getId());
			cg.setValidos(acum1);

			candidatos.add(cg);

		}

		return candidatos;
	}

}
