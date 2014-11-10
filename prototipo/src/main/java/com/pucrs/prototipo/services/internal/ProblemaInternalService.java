package com.pucrs.prototipo.services.internal;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pucrs.prototipo.core.Problema;
import com.pucrs.prototipo.persistence.dao.ProblemaDAO;

public class ProblemaInternalService {

    ArrayList<Problema> problemas;

    public ArrayList<Problema> getAllProblems() {
	ProblemaDAO dao = new ProblemaDAO();
	try {
	    problemas = dao.getTodosProblemas();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return problemas;
    }

}
