package com.pucrs.prototipo.core;

public class Solucao {

    private long id;
    private String nome;
    private String descricao;
    private String metodologia;
    private String nomeProblema;

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

    public String getMetodologia() {
	return metodologia;
    }

    public void setMetodologia(String metodologia) {
	this.metodologia = metodologia;
    }

    public String getNomeProblema() {
	return nomeProblema;
    }

    public void setNomeProblema(String nomeProblema) {
	this.nomeProblema = nomeProblema;
    }

}
