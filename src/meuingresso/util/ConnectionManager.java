/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author priscillabittencourt
 */
public class ConnectionManager {
    protected Connection connection;
    private ConfigDatabase configDB;
    
    private void connectJDBC() throws SQLException {
        try {
            connection = DriverManager.getConnection(configDB.URL, configDB.USER, configDB.PASSWORD);
        } catch (SQLException e) {
                System.out.println("Erro ao connectar com banco: " + e.getMessage());
                throw new SQLException("Sem conexão com o banco de dados!");
        }
    }

    public void closeConnection() {
        try {
            if (isConnected())
                connection.close();
        } catch (SQLException e) {
                System.out.println("N�o foi poss�vel fechar a conex�o com o banco, motivo: " + e.getMessage());
        }
    }

    protected boolean isConnected() throws SQLException {
        return connection != null && connection.isClosed();
    }

    public Connection getConnection() throws SQLException {
        if (!isConnected())
            connectJDBC();
        return connection;
    }
}
