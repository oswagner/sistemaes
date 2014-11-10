package com.pucrs.prototipo.persistence.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static boolean status;

    public DatabaseConnection() {

    }

    public static Connection getConnection() {

	Connection connection = null;
	try {
	    String driver = "com.mysql.jdbc.Driver";

	    Class.forName(driver);

	    String nomeServidor = "localhost:3306";
	    String nomeDatabase = "prototipo_db";
	    String url = "jdbc:mysql://" + nomeServidor + "/" + nomeDatabase;
	    String user = "root";
	    String pass = "";

	    connection = DriverManager.getConnection(url, user, pass);

	    if (connection == null) {
		status = false;
	    } else {
		status = true;
	    }

	    return connection;

	} catch (ClassNotFoundException e) {
	    System.out.println("nao achou o driver");
	    e.printStackTrace();
	    return null;
	} catch (SQLException e) {
	    System.out.println("problema de conexao");
	    e.printStackTrace();
	    return null;
	}
    }

    public static boolean getStatu() {
	return status;
    }

    public static boolean closeConnection() {
	try {
	    getConnection().close();
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

}
