package com.pucrs.prototipo.services.internal;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pucrs.prototipo.core.Solucao;
import com.pucrs.prototipo.persistence.dao.SolucaoDAO;

public class SolutionInternalService {

    ArrayList<Solucao> solucoes;

    public ArrayList<Solucao> getSolutionsByProblems(ArrayList<Long> problems) {
	SolucaoDAO dao = new SolucaoDAO();
	try {
	    solucoes = dao.getSolutionsByProblems(problems);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return solucoes;
    }

}
