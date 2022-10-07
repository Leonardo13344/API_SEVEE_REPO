package com.example.demo.service;

import java.math.BigInteger;

public interface IActaService {
	
	
	public BigInteger sumaVotoBlanco(String act_tipo);
	
	public BigInteger sumaVotoNulo(String act_tipo);

	public BigInteger sumaVotoAusente(String actTipo);

}
