package com.pucrs.prototipo.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Empresa {

    private long id;
    private String nome;
    private String endereco;
    private String estado;
    private String cidade;
    private int qtdFuncionarios;
    private int qtdFuncionariosTi;
    private boolean isAgil;
    private MetodosAgeis metodosAgeis;
    private int agilTempo;
    private Date ultimaConsulta;

    // user informations
    private String nomeUsuario;
    private String email;
    private int tempoNaEmpresa;
    private String usuarioFuncao;
    private int tempoFuncao;
    private boolean cursoGestao;
    private boolean cursoAgil;
    private int cursoGestaoTempo;
    private int cursoAgilTempo;
    private NivelConhecimento conheceAgil;
    private NivelConhecimento conheceGestao;

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

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	this.endereco = endereco;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public int getQtdFuncionarios() {
	return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
	this.qtdFuncionarios = qtdFuncionarios;
    }

    public int getQtdFuncionariosTi() {
	return qtdFuncionariosTi;
    }

    public void setQtdFuncionariosTi(int qtdFuncionariosTi) {
	this.qtdFuncionariosTi = qtdFuncionariosTi;
    }

    public boolean isAgil() {
	return this.isAgil;
    }

    public void setIsAgil(boolean isAgil) {
	this.isAgil = isAgil;
    }

    public MetodosAgeis getMetodosAgeis() {
	return metodosAgeis;
    }

    public void setMetodosAgeis(MetodosAgeis metodosAgeis) {
	this.metodosAgeis = metodosAgeis;
    }

    public int getAgilTempo() {
	return agilTempo;
    }

    public void setAgilTempo(int agilTempo) {
	this.agilTempo = agilTempo;
    }

    public Date getUltimaConsulta() {
	return ultimaConsulta;
    }

    public void setUltimaConsulta(Date ultimaConsulta) {
	this.ultimaConsulta = ultimaConsulta;
    }

    public String getNomeUsuario() {
	return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getTempoNaEmpresa() {
	return tempoNaEmpresa;
    }

    public void setTempoNaEmpresa(int tempoNaEmpresa) {
	this.tempoNaEmpresa = tempoNaEmpresa;
    }

    public String getUsuarioFuncao() {
	return usuarioFuncao;
    }

    public void setUsuarioFuncao(String usuarioFuncao) {
	this.usuarioFuncao = usuarioFuncao;
    }

    public boolean isCursoGestao() {
	return cursoGestao;
    }

    public void setCursoGestao(boolean cursoGestao) {
	this.cursoGestao = cursoGestao;
    }

    public boolean isCursoAgil() {
	return cursoAgil;
    }

    public void setCursoAgil(boolean cursoAgil) {
	this.cursoAgil = cursoAgil;
    }

    public int getTempoFuncao() {
	return tempoFuncao;
    }

    public void setTempoFuncao(int tempoFuncao) {
	this.tempoFuncao = tempoFuncao;
    }

    public int getCursoGestaoTempo() {
	return cursoGestaoTempo;
    }

    public void setCursoGestaoTempo(int cursoGestaoTempo) {
	this.cursoGestaoTempo = cursoGestaoTempo;
    }

    public int getCursoAgilTempo() {
	return cursoAgilTempo;
    }

    public void setCursoAgilTempo(int cursoAgilTempo) {
	this.cursoAgilTempo = cursoAgilTempo;
    }

    public NivelConhecimento getConheceGestao() {
	return conheceGestao;
    }

    public void setConheceGestao(NivelConhecimento conheceGestao) {
	this.conheceGestao = conheceGestao;
    }

    public NivelConhecimento getConheceAgil() {
	return conheceAgil;
    }

    public void setConheceAgil(NivelConhecimento conheceAgil) {
	this.conheceAgil = conheceAgil;
    }
}
