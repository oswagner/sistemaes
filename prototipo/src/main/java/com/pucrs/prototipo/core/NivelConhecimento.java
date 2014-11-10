package com.pucrs.prototipo.core;

public enum NivelConhecimento {

    NENHUM("Nenhum"), POUCO("Pouco"), MODERADO("Moderado"), AVANCADO("Avaçado");

    private String value;

    private NivelConhecimento(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

}
