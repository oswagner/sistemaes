package com.pucrs.prototipo.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.pucrs.prototipo.core.Empresa;
import com.pucrs.prototipo.core.MetodosAgeis;
import com.pucrs.prototipo.core.NivelConhecimento;
import com.pucrs.prototipo.core.Problema;
import com.pucrs.prototipo.core.Solucao;
import com.pucrs.prototipo.persistence.core.DatabaseConnection;
import com.pucrs.prototipo.persistence.dao.EmpresaDAO;
import com.pucrs.prototipo.persistence.dao.ProblemaDAO;
import com.pucrs.prototipo.persistence.dao.SolucaoDAO;

public class TesteDB {

    public static void main(String[] args) {

//	Empresa e = new Empresa();
//
//	e.setNome("Emprea1");
//	e.setEndereco("Rua X, nro 123");
//	e.setCidade("Porto Alegre");
//	e.setEstado("Rio Grande do Sul");
//	e.setQtdFuncionarios(10);
//	e.setQtdFuncionariosTi(5);
//	e.setAgil(false);
//	e.setAgilTempo(3);
//	MetodosAgeis other = MetodosAgeis.OTHER;
//	other.setValue("Rup");
//	e.setMetodosAgeis(other);
//	e.setNomeUsuario("Wagner");
//	e.setEmail("prog.wagner@gmail.com");
//	e.setTempoNaEmpresa(2);
//	e.setUsuarioFuncao("Desenvolvedor");
//	e.setTempoNaEmpresa(3);
//	e.setCursoGestao(true);
//	e.setCursoAgil(false);
//	e.setCursoGestaoTempo(3);
//	e.setCursoAgilTempo(0);
//	e.setConheceGestao(NivelConhecimento.AVANCADO);
//	e.setConheceAgil(NivelConhecimento.POUCO);
//
//	EmpresaDAO emp = new EmpresaDAO();
//	ProblemaDAO prob = new ProblemaDAO();
//	SolucaoDAO sol = new SolucaoDAO();
//
//	ArrayList<Long> problemas = new ArrayList<>();
//	problemas.add((long) 1);
//	problemas.add((long) 34);
//	try {
//	    DatabaseConnection.getConnection();
//	    System.out.println(DatabaseConnection.getStatu());
//	    emp.create(e);
//	    prob.setProblemsToEmpresa(1, problemas);
//
//	    ArrayList<Problema> problemasByEmpresaId = prob.getProblemasByEmpresaId(1);
//	    ArrayList<Long> problems = new ArrayList<>();
//
//	    for (Problema problema : problemasByEmpresaId) {
//		problems.add(problema.getId());
//	    }
//
//	    ArrayList<Solucao> solutionsByProblems = sol.getSolutionsByProblems(problems);
//
//	    for (Solucao solucao : solutionsByProblems) {
//		System.out.println(solucao.getNome());
//		System.out.println(solucao.getMetodologia());
//		System.out.println(solucao.getDescricao());
//	    }
//
//	} catch (SQLException e1) {
//	    e1.printStackTrace();
//	} finally {
//	    DatabaseConnection.closeConnection();
//	}
	
	Empresa e = new Empresa();
	
	System.out.println(e.getTempoFuncao());
	System.out.println(e.isCursoGestao());
    }
   
    
}
