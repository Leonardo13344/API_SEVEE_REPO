package com.example.demo.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IActaService;
import com.example.demo.service.IVotoService;

@RestController
@RequestMapping("/votos")
@CrossOrigin("http://localhost:8080/")
public class VotoRestFulController {
	
	@Autowired
	private IVotoService votoService;
	
		

}
