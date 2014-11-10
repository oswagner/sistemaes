package com.pucrs.prototipo.core;

import java.util.ArrayList;

public class Estado {

    private String sigla;
    private String nome;
    private ArrayList<Cidade> cidades;

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public ArrayList<Cidade> getCidades() {
	return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
	this.cidades = cidades;
    }

}
