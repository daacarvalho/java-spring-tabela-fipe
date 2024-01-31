package com.alura.tabelafipe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumoApi {
	
	public String obterDados(String endereco) {
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(endereco))
				.build();
		
		HttpResponse<String> httpResponse = null;
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		return httpResponse.body();
	}
}
