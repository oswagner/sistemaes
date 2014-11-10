package com.pucrs.prototipo.core;

public class Problema {

    private long id;
    private String nome;
    private String descricao;
    private String categoria;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }
}
