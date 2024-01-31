package com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AnoTipo(@JsonAlias("codigo") String ano, @JsonAlias("nome") String tipo) {
	
	@Override
	public String toString() {
        return String.format("\n Ano: %s \n"
        		+ "Tipo: %s ",this.ano,this.tipo);
    }
}
