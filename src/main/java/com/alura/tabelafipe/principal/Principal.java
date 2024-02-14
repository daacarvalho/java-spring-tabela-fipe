package com.alura.tabelafipe.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alura.tabelafipe.model.AnoTipo;
import com.alura.tabelafipe.model.MeioDeTransporte;
import com.alura.tabelafipe.model.Modelo;
import com.alura.tabelafipe.model.Veiculo;
import com.alura.tabelafipe.service.ConsumoApi;
import com.alura.tabelafipe.service.ConverteDados;

public class Principal {
	
	Scanner scanner = new Scanner(System.in);
	ConsumoApi consumoApi = new ConsumoApi();
	ConverteDados conversor = new ConverteDados();
	
	String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
	String MARCAS = "/marcas";
	String MODELOS = "/modelos";
	String ANOS = "/anos";
	
	public void exibeMenu(String endereco) {
		System.out.println("""
				Digite o veículo desejado:
				
				carros
				
				motos
				
				caminhoes
				
				""");
		String tipoVeiculo = scanner.nextLine();
		
		String dados = consumoApi.obterDados(String.format("%s%s%s", BASE_URL,tipoVeiculo.toLowerCase(),MARCAS));
		
		List<MeioDeTransporte> marcas = conversor.montaListaDeDados(dados, MeioDeTransporte.class);
		System.out.println(marcas);
		
		System.out.println("Escolha a marca pelo código: ");
		Integer marca = scanner.nextInt();
		scanner.nextLine();
		
		String dadosMarca = consumoApi.obterDados(String.format("%s%s%s/%s%s", BASE_URL,tipoVeiculo.toLowerCase(),MARCAS,marca,MODELOS));
		
		Modelo modelo = conversor.converteDados(dadosMarca, Modelo.class);
		System.out.println(modelo);
		
		System.out.println("Digite um trecho do modelo que deseja: ");
		String trechoModelo = scanner.nextLine();
		
		modelo.modelos().stream().filter(m->m.nome().toLowerCase().contains(trechoModelo.toLowerCase())).forEach(System.out::println);
		
		System.out.println("Digite um código do modelo que deseja: ");
		String codigoModelo = scanner.nextLine();
		
		String modeloAnos = consumoApi.obterDados(String.format("%s%s%s/%s%s/%s%s", BASE_URL,tipoVeiculo.toLowerCase(),MARCAS,marca,MODELOS,codigoModelo,ANOS));
		List<AnoTipo> anoTipo = conversor.montaListaDeDados(modeloAnos, AnoTipo.class);
		anoTipo.forEach(System.out::println);

		System.out.println("Digite o ano do modelo que deseja: ");
		String anoModelo = scanner.nextLine();
		List<Veiculo> listaVeiculos = new ArrayList<>();

		for (int i = 0; i < anoTipo.size(); i++) {
			String anoDoModelo = consumoApi.obterDados(String.format("%s%s%s/%s%s/%s%s/%s", BASE_URL,tipoVeiculo.toLowerCase(),MARCAS,marca,MODELOS,codigoModelo,ANOS,anoTipo.get(i).ano()));
			listaVeiculos.add(conversor.converteDados(anoDoModelo, Veiculo.class));
		}

		System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
		listaVeiculos.forEach(System.out::println);
	}
}
