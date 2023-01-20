package com.example.demo.sevee.repository.modelo.to;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Funciones {
	
	public static <T> Predicate<T> distinctPorCodigo(Function<? super T, Object> keyExtractor) 
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	public static Integer provChange(String provincia) {
		Map<String, Integer> mapaProv = new HashMap<String, Integer>();
		mapaProv.put("AZUAY", 1);
		return mapaProv.get(provincia.toUpperCase());
	}
	
	public static Integer cantonChange(String canton) {
		Map<String, Integer> mapaProv = new HashMap<String, Integer>();
		mapaProv.put("CUENCA", 260);
		return mapaProv.get(canton.toUpperCase());
	}
}
