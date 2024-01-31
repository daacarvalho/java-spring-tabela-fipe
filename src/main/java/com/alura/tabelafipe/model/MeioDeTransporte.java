package com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record MeioDeTransporte(@JsonAlias("codigo") Integer codigo, @JsonAlias("nome")String nome) {
	
	@Override
	public String toString() {
        return String.format("\nNome: %s \n"
        		+ "Código: %d ",this.nome,this.codigo);
    }
}
