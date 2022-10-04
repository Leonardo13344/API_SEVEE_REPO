package com.example.demo.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IActaService;

@RestController
@RequestMapping("/actas")
@CrossOrigin("http://localhost:8080/")
public class ActaRestFulController {
	
	@Autowired
	private IActaService actaService;
	
	@GetMapping(path="/{actTipo}")
	public BigInteger votosBlancos(@PathVariable("actTipo") String actTipo) {
		return this.actaService.sumaVotoBlanco(actTipo);
	}

}
