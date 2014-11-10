package com.pucrs.prototipo.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pucrs.prototipo.core.Problema;
import com.pucrs.prototipo.persistence.core.DatabaseConnection;

public class ProblemaDAO {

    private final String empresasProblema = "empresas_problemas";
    private final String problema = "problemas";
    private final String empresas = "empresas";

    public ArrayList<Problema> getTodosProblemas() throws SQLException {
	String query = "SELECT * FROM " + problema + ";";
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	System.out.println(query);
	ResultSet rs = st.executeQuery(query);
	ArrayList<Problema> toReturn = new ArrayList<>();
	while (rs.next()) {
	    Problema p = new Problema();
	    p.setId(rs.getLong(1));
	    p.setNome(rs.getString(2));
	    p.setCategoria(rs.getString(3));
	    p.setDescricao(rs.getString(4));
	    if (!toReturn.contains(p.getId())) {
		toReturn.add(p);
	    }
	}
	return toReturn;
    }

    public ArrayList<Problema> getProblemasByEmpresaId(long id) throws SQLException {

	/*
	 * query = select p.id,p.nome,p.categoria,p.descricao from
	 * empresas_Problema ep join Problema p on p.id = ep.problema_id join
	 * empresas e on e.id = ep.empresa_id where e.id = id
	 */

	String query = "select p.id, p.nome, p.categoria, p.descricao from " + empresasProblema + " ep" + " join " + problema + " p on p.id = ep.problema_id"
		+ " join " + empresas + " e on e.id = ep.empresa_id where e.id=" + id + ";";

	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();

	ArrayList<Problema> toReturn = new ArrayList<>();

	ResultSet rs = st.executeQuery(query);
	while (rs.next()) {
	    Problema p = new Problema();
	    p.setId(rs.getLong(1));
	    p.setNome(rs.getString(2));
	    p.setCategoria(rs.getString(3));
	    p.setDescricao(rs.getString(4));
	    if (!toReturn.contains(p.getId())) {
		toReturn.add(p);
	    }
	}
	return toReturn;
    }

    public boolean setProblemsToEmpresa(long id, ArrayList<Long> problemas) throws SQLException {
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	boolean execute = false;
	for (Long idProblema : problemas) {
	    String query = "INSERT INTO " + empresasProblema + " values ( " + id + " , " + idProblema + " );";
	    execute = st.execute(query);
	}

	return execute;
    }
}
