package com.pucrs.prototipo.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.pucrs.prototipo.core.Solucao;
import com.pucrs.prototipo.persistence.core.DatabaseConnection;

public class SolucaoDAO {

    private final String solucoes = "solucoes";
    private final String problemasSolucoes = "problemas_solucoes";
    private final String problemas = "problemas";

    public ArrayList<Solucao> getTodasSolucoes() throws SQLException {
	String query = "SELECT * FROM " + solucoes + ";";
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();

	ArrayList<Solucao> toReturn = new ArrayList<>();
	ResultSet rs = st.executeQuery(query);
	while (rs.next()) {
	    Solucao s = new Solucao();
	    s.setId(rs.getLong(1));
	    s.setNome(rs.getString(2));
	    s.setMetodologia(rs.getString(3));
	    s.setDescricao(rs.getString(4));
	    if (!toReturn.contains(s)) {
		toReturn.add(s);
	    }
	}
	return toReturn;
    }

    public ArrayList<Solucao> getSolutionsByProblems(ArrayList<Long> problems) throws SQLException {
	ArrayList<Solucao> toReturn = new ArrayList<>();

	StringBuilder builder = new StringBuilder();

	for (int i = 0; i < problems.size(); i++) {
	    builder.append(problems.get(i));
	    if (i != problems.size() - 1)
		builder.append(",");
	}

	String query = "SELECT s.id, s.nome, s.metodologia, s.descricao, p.nome FROM " + problemasSolucoes + " ps " + "join " + problemas + " p"
		+ " on p.id = ps.problema_id" + " join " + solucoes + " s" + " on s.id = ps.solucao_id" + " where p.id in (" + builder.toString() + " )";
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	
		
	ResultSet rs = st.executeQuery(query);

	while (rs.next()) {
	    Solucao s = new Solucao();
	    s.setId(rs.getLong(1));
	    s.setNome(rs.getString(2));
	    s.setMetodologia(rs.getString(3));
	    s.setDescricao(rs.getString(4));
	    s.setNomeProblema(rs.getString(5));
	    if (!toReturn.contains(s)) {
		toReturn.add(s);
	    }
	}

	return toReturn;
    }
}
