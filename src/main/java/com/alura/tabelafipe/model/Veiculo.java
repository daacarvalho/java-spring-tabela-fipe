package com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Veiculo(@JsonAlias("TipoVeiculo") Integer tipoVeiculo, 
					  @JsonAlias("Valor") String valor,
					  @JsonAlias("Marca") String marca,
					  @JsonAlias("Modelo") String modelo,
					  @JsonAlias("AnoModelo") Integer anoModelo,
					  @JsonAlias("Combustivel") String combustivel,
					  @JsonAlias("CodigoFipe") String codigoFipe,
					  @JsonAlias("MesReferencia") String mesReferencia,
					  @JsonAlias("SiglaCombustivel") String siglaCombustivel) {
	
	@Override
	public String toString() {
        return """
        		
        		TipoVeiculo: %d
				Valor: %s
				Marca: %s
				Modelo: %s
				AnoModelo: %d
				Combustivel: %s
				CodigoFipe: %s
				MesReferencia: %s
				SiglaCombustivel: %s
        		""".formatted(this.tipoVeiculo,this.valor,this.marca,
        				this.modelo,this.anoModelo,this.combustivel,
        				this.codigoFipe,this.mesReferencia,this.siglaCombustivel);
    }

}
