package com.alura.tabelafipe.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IConverteDados {
	
	<T> T converteDados(String json,Class<T> clazz) throws JsonMappingException, JsonProcessingException;
	
	<T> List<T> montaListaDeDados(String json,Class<T> clazz);
}
