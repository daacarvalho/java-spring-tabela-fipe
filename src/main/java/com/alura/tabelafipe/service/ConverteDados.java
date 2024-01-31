package com.alura.tabelafipe.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public <T> T converteDados(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json,clazz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public <T> List<T> montaListaDeDados(String json, Class<T> clazz) {
		
		JsonNode jsonNode;
		List<T> listaDados = new ArrayList<T>();
		
		try {
			jsonNode = mapper.readTree(json);
			
			if (jsonNode.isArray()) {
	            for (JsonNode arrayElement : jsonNode) {
	            	listaDados.add(converteDados(arrayElement.toString(),clazz));
	            }
	        } 
			return listaDados;
			
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
