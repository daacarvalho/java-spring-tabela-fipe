package com.alura.tabelafipe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Modelo(@JsonAlias("modelos") List<MeioDeTransporte> modelos,@JsonAlias("anos") List<AnoTipo> anos) {
	
	@Override
	public String toString() {
        return "Modelos: \n" + modelos
        		+ "\nAnos: \n" + anos;
    }
}
