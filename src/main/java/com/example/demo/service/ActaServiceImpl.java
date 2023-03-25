package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IActaRepo;
import com.example.demo.sevee.repository.modelo.Acta;

@Service
// @State(Scope.Benchmark)
public class ActaServiceImpl implements IActaService{
	
	@Autowired
	private IActaRepo actaRepo;

	@Override
	// @Fork(value = 1, warmups = 1)
    // @Benchmark
    // @BenchmarkMode(Mode.Throughput)
	public BigInteger sumaVotoBlanco(String act_tipo) {
		// TODO Auto-generated method stub
		List<Acta> lista = this.actaRepo.votosBlancos(act_tipo);
		BigInteger sum = new BigInteger("0");
		for (Acta acta : lista) {
			sum = sum.add(acta.getBlancos());
		}
		return sum;
	}

	@Override
	public BigInteger sumaVotoNulo(String act_tipo) {
		List<Acta> lista = this.actaRepo.votosNulos(act_tipo);
		BigInteger sum = new BigInteger("0");
		for (Acta acta : lista) {
			sum = sum.add(acta.getNulos());
		}
		return sum;
	}

	@Override
	public BigInteger sumaVotoAusente(String actTipo) {
		// TODO LUIS
		List<Acta> lista = this.actaRepo.votosAusentes(actTipo);
		BigInteger sum = new BigInteger("0");
		for(Acta acta : lista) {
			sum = sum.add(acta.getAusentes());
		}
		return sum;
	}



}
