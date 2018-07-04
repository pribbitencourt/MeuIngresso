/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.DAO.abstractType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import meuingresso.DAO.implementation.SalaDAO;
import meuingresso.DAO.implementation.SessaoDAO;
import meuingresso.util.ConnectionManager;
import meuingresso.util.SQLManager;

/**
 *
 * @author priscillabittencourt
 */
public abstract class AbstractDatabaseDAO {
	protected ConnectionManager connection = new ConnectionManager();
        protected SQLManager sqlManager = new SQLManager();
        protected final String COMMA = ", ";
        protected final String UPDATE_MARK = " = ?";
        protected final String LAST_ID = "lastId";
        
	public static void createTables() {
            new SalaDAO().createTable();
            new SessaoDAO().createTable();
	}
        public void createTable(String table_name, String table_body) throws SQLException{
            String query = sqlManager.generateQueryCreateTable(table_name, table_body);
            executeQuery(query);
        }
	protected void executeQuery(String query) throws SQLException {
		Statement statement = connection.getConnection().createStatement();
		statement.executeUpdate(query);
		statement.close();
	}

	protected ResultSet executeQueryWithResult(String query) throws SQLException {
		Statement statement = connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}

	protected void executePreparedStatement(PreparedStatement statement) throws SQLException {
		statement.execute();
		statement.close();
	}

	protected ResultSet executePreparedStatementWithResult(PreparedStatement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery();
		return resultSet;
	}

	
}
