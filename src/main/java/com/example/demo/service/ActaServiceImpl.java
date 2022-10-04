package com.example.demo.service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IActaRepo;
import com.example.demo.sevee.repository.modelo.Acta;

@Service
public class ActaServiceImpl implements IActaService{
	
	@Autowired
	private IActaRepo actaRepo;

	@Override
	public BigInteger sumaVotoBlanco(String act_tipo) {
		// TODO Auto-generated method stub
		List<Acta> lista = this.actaRepo.votosBlancos(act_tipo);
		BigInteger sum = new BigInteger("0");
		for (Acta acta : lista) {
			sum = sum.add(acta.getBlancos());
		}
		return sum;
	}

}
