package com.pucrs.prototipo.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pucrs.prototipo.core.Empresa;
import com.pucrs.prototipo.core.MetodosAgeis;
import com.pucrs.prototipo.core.NivelConhecimento;
import com.pucrs.prototipo.persistence.core.DatabaseConnection;

public class EmpresaDAO {

    private final String empresas = "empresas";
    private String values;

    public int create(Empresa empresa) throws SQLException {
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	setValues(empresa);
	int id = 0;
	String query = "INSERT INTO " + empresas + " VALUES(" + values + ");";
	System.out.println(query);
	try {
	    st.execute(query);
	    id = (nextId() - 1);
	} catch (SQLException e) {

	} finally {
	    DatabaseConnection.closeConnection();
	}
	return id;
    }

    public boolean delete(long id) throws SQLException {
	String query = "DELETE FROM " + empresas + " WHERE id=" + id + ";";
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	System.out.println(query);
	boolean execute = st.execute(query);

	return execute;
    }

    public Empresa getById(long id) throws SQLException {
	String query = "SELECT * FROM " + empresas + " WHERE id=" + id + ";";
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery(query);
	Empresa e = new Empresa();
	while (rs.next()) {
	    e.setId(rs.getLong(1));
	    e.setNome(rs.getString(2));
	    e.setEndereco(rs.getString(3));
	    e.setCidade(rs.getString(4));
	    e.setEstado(rs.getString(5));
	    e.setQtdFuncionarios(rs.getInt(6));
	    e.setQtdFuncionariosTi(rs.getInt(7));
	    if (rs.getInt(8) == 1) {
		e.setIsAgil(true);
	    } else {
		e.setIsAgil(false);
	    }

	    e.setAgilTempo(rs.getInt(9));

	    String metodo = rs.getString(10);

	    if (MetodosAgeis.SCRUM.getValue().equalsIgnoreCase(metodo)) {
		e.setMetodosAgeis(MetodosAgeis.SCRUM);
	    } else if (MetodosAgeis.KANBAN.getValue().equalsIgnoreCase(metodo)) {
		e.setMetodosAgeis(MetodosAgeis.KANBAN);
	    } else if (MetodosAgeis.XP.getValue().equalsIgnoreCase(metodo)) {
		e.setMetodosAgeis(MetodosAgeis.XP);
	    } else {
		MetodosAgeis other = MetodosAgeis.OTHER;
		other.setValue(metodo);
		e.setMetodosAgeis(other);
	    }
	    e.setNomeUsuario(rs.getString(11));
	    e.setEmail(rs.getString(12));
	    e.setUsuarioFuncao(rs.getString(13));
	    e.setTempoFuncao(rs.getInt(14));
	    e.setTempoNaEmpresa(rs.getInt(15));

	    if (rs.getInt(16) == 1) {
		e.setCursoGestao(true);
	    } else {
		e.setCursoGestao(false);
	    }

	    if (rs.getInt(17) == 1) {
		e.setCursoAgil(true);
	    } else {
		e.setCursoAgil(false);
	    }

	    e.setCursoGestaoTempo(rs.getInt(18));
	    e.setCursoAgilTempo(rs.getInt(19));

	    String conheGestao = rs.getString(20);

	    if (NivelConhecimento.POUCO.getValue().equalsIgnoreCase(conheGestao)) {
		e.setConheceGestao(NivelConhecimento.POUCO);
	    } else if (NivelConhecimento.MODERADO.getValue().equalsIgnoreCase(conheGestao)) {
		e.setConheceGestao(NivelConhecimento.MODERADO);
	    } else if (NivelConhecimento.AVANCADO.getValue().equalsIgnoreCase(conheGestao)) {
		e.setConheceGestao(NivelConhecimento.AVANCADO);
	    } else {
		e.setConheceGestao(NivelConhecimento.NENHUM);
	    }

	    String conheceAgil = rs.getString(21);

	    if (NivelConhecimento.POUCO.getValue().equalsIgnoreCase(conheceAgil)) {
		e.setConheceAgil(NivelConhecimento.POUCO);
	    } else if (NivelConhecimento.MODERADO.getValue().equalsIgnoreCase(conheceAgil)) {
		e.setConheceAgil(NivelConhecimento.MODERADO);
	    } else if (NivelConhecimento.AVANCADO.getValue().equalsIgnoreCase(conheceAgil)) {
		e.setConheceAgil(NivelConhecimento.AVANCADO);
	    } else {
		e.setConheceAgil(NivelConhecimento.NENHUM);
	    }
	}
	return e;
    }

    public boolean update(Empresa e) throws SQLException {
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();

	setUpdateValue(e);
	String query = "UPDATE " + empresas + " set " + values + " WHERE id =" + e.getId() + ";";
	boolean execute = st.execute(query);

	return execute;
    }

    public void closeConnection() {
	DatabaseConnection.closeConnection();
    }

    private void setValues(Empresa e) throws SQLException {
	StringBuffer buff = new StringBuffer();
	buff.append(" ");
	buff.append(nextId());
	buff.append(", ");
	buff.append("'" + e.getNome() + "'");
	buff.append(", ");
	buff.append("'" + e.getEndereco() + "'");
	buff.append(", ");
	buff.append("'" + e.getCidade() + "'");
	buff.append(", ");
	buff.append("'" + e.getEstado() + "'");
	buff.append(", ");
	buff.append(e.getQtdFuncionarios());
	buff.append(", ");
	buff.append(e.getQtdFuncionariosTi());
	buff.append(", ");
	buff.append(e.isAgil() ? 1 : 0);
	buff.append(", ");
	buff.append(e.getAgilTempo());
	buff.append(", ");
	if (e.getMetodosAgeis() == null) {
	    buff.append("''");
	} else {
	    buff.append("'" + e.getMetodosAgeis().getValue() + "'");
	}
	buff.append(", ");
	if (e.getNomeUsuario() == null) {
	    buff.append("''");
	} else {
	    buff.append("'" + e.getNomeUsuario() + "'");
	}

	buff.append(", ");
	buff.append("'" + e.getEmail() + "'");

	buff.append(", ");
	if (e.getUsuarioFuncao() == null) {
	    buff.append("''");
	} else {
	    buff.append("'" + e.getUsuarioFuncao() + "'");
	}
	buff.append(", ");
	buff.append(e.getTempoFuncao());
	buff.append(", ");
	buff.append(e.getTempoNaEmpresa());
	buff.append(", ");
	buff.append(e.isCursoGestao() ? 1 : 0);
	buff.append(", ");
	buff.append(e.isCursoAgil() ? 1 : 0);
	buff.append(", ");
	buff.append(e.getCursoGestaoTempo());
	buff.append(", ");
	buff.append(e.getCursoAgilTempo());
	buff.append(", ");
	if (e.getConheceGestao() == null) {
	    buff.append("''");
	} else {
	    buff.append("'" + e.getConheceGestao().getValue() + "'");
	}
	buff.append(", ");

	if (e.getConheceAgil() == null) {
	    buff.append("''");
	} else {
	    buff.append("'" + e.getConheceAgil().getValue() + "'");
	}

	String string = buff.toString();
	values = string;
    }

    private void setUpdateValue(Empresa e) {
	StringBuffer buff = new StringBuffer();
	buff.append("nome_empresa =");
	buff.append("'" + e.getNome() + "'");
	buff.append(", ");
	buff.append("endereco =");
	buff.append("'" + e.getEndereco() + "'");
	buff.append(", ");
	buff.append("cidade = ");
	buff.append("'" + e.getCidade() + "'");
	buff.append(", ");
	buff.append("estado = ");
	buff.append("'" + e.getEstado() + "'");
	buff.append(", ");
	buff.append("funcionarios_qtde = ");
	buff.append(e.getQtdFuncionarios());
	buff.append(", ");
	buff.append("funcionarios_ti_qtde = ");
	buff.append(e.getQtdFuncionariosTi());
	buff.append(", ");
	buff.append("metodos_ageis = ");
	buff.append(e.isAgil() ? 1 : 0);
	buff.append(", ");
	buff.append("metodos_tempo = ");
	buff.append(e.getAgilTempo());
	buff.append(", ");
	buff.append("quaisAgeis = ");
	buff.append("'" + e.getMetodosAgeis().getValue() + "'");
	buff.append(", ");
	buff.append("nome_funcionario = ");
	buff.append("'" + e.getNomeUsuario() + "'");
	buff.append(", ");
	buff.append("email = ");
	buff.append("'" + e.getEmail() + "'");
	buff.append(", ");
	buff.append("funcao_funcionario = ");
	buff.append("'" + e.getUsuarioFuncao() + "'");
	buff.append(", ");
	buff.append("funcao_tempo = ");
	buff.append(e.getTempoFuncao());
	buff.append(", ");
	buff.append("empresa_tempo = ");
	buff.append(e.getTempoNaEmpresa());
	buff.append(", ");
	buff.append("curso_gestao = ");
	buff.append(e.isCursoGestao() ? 1 : 0);
	buff.append(", ");
	buff.append("curso_metodos = ");
	buff.append(e.isCursoAgil() ? 1 : 0);
	buff.append(", ");
	buff.append("curso_gestao_tempo = ");
	buff.append(e.getCursoGestaoTempo());
	buff.append(", ");
	buff.append("curso_ageis_tempo = ");
	buff.append(e.getCursoAgilTempo());
	buff.append(", ");
	buff.append("gestao_conhecimento = ");
	buff.append("'" + e.getConheceGestao().getValue() + "'");
	buff.append(", ");
	buff.append("ageis_conhecimento = ");
	buff.append("'" + e.getConheceAgil().getValue() + "'");

	String string = buff.toString();
	values = string;
    }

    private int nextId() throws SQLException {
	Connection connection = DatabaseConnection.getConnection();
	Statement st = connection.createStatement();
	String query = "select max(id) from " + empresas + ";";
	ResultSet rs = st.executeQuery(query);
	int toReturn = 0;

	while (rs.next()) {
	    toReturn = rs.getInt(1);
	}
	return toReturn + 1;

    }
}
