package com.pucrs.prototipo.services.internal;

import java.sql.SQLException;

import com.pucrs.prototipo.core.Empresa;
import com.pucrs.prototipo.persistence.dao.EmpresaDAO;

public class EmpresaInternalService {

    public int cadastraEmpresa(Empresa empresa) {
	EmpresaDAO dao = new EmpresaDAO();
	int id = 0;
	try {
	    id = dao.create(empresa);
	} catch (SQLException e) {

	    e.printStackTrace();
	} finally {
	    dao.closeConnection();
	}
	return id;
    }

    public Empresa findEmpresaById(long id) {
	EmpresaDAO dao = new EmpresaDAO();
	Empresa empresa = null;
	try {
	    empresa = dao.getById(id);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    dao.closeConnection();
	}

	if (empresa == null)
	    throw new NullPointerException();

	return empresa;
    }

}
