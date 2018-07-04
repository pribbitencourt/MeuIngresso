/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.DAO.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import meuingresso.DAO.abstractType.AbstractDatabaseDAO;
import meuingresso.DAO.abstractType.IDatabaseDAO;
import meuingresso.model.implementation.Cliente;
import meuingresso.model.implementation.Funcionario;

/**
 *
 * @author Aluno
 */
public class ClienteDAO extends AbstractDatabaseDAO implements IDatabaseDAO<Cliente> {  
    private final String TABLE_NAME = "cliente";
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME = "nome";
    private final String COLUMN_CPF = "cpf";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_TELEFONE = "telefone";
    private final String COLUMN_DATA_NASCIMENTO = "data_nascimento";
    
    private final String TABLE_BODY = "("
            + this.COLUMN_ID + "SERIAL PRIMARY KEY, "
            + this.COLUMN_NOME + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_CPF + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_EMAIL +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_TELEFONE +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_DATA_NASCIMENTO +" VARCHAR(150) NOT NULL, "
            + ");";
    

    
    private final String SQL_INSERT = "INSERT INTO "
                        + TABLE_NAME
			+ "("
			+ COLUMN_NOME + ", "
			+ COLUMN_CPF + ", "
                        + COLUMN_EMAIL + ", "
                        + COLUMN_TELEFONE + ", "
                        + COLUMN_DATA_NASCIMENTO
			+ ")"
			+ " VALUES "
			+ "(?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_UPDATE = "UPDATE"
                        + TABLE_NAME
                        + " SET"
			+ COLUMN_NOME + UPDATE_MARK + COMMA
			+ COLUMN_CPF + UPDATE_MARK + COMMA
			+ COLUMN_EMAIL + UPDATE_MARK
                        + COLUMN_TELEFONE + UPDATE_MARK
                        + COLUMN_DATA_NASCIMENTO + UPDATE_MARK
			+ " WHERE " + COLUMN_ID + UPDATE_MARK;
    
    @Override
    public void createTable() {
        try {
            super.createTable(TABLE_NAME, TABLE_BODY);
        } catch (SQLException e) {
            System.out.println("Tabela "+TABLE_NAME+" não pode ser criada pelo motivo: "+ e.getMessage());
                    
        }
    }

    @Override
    public long insert(Cliente object) throws SQLException {
        PreparedStatement statement =  objectToPreparedStatement(SQL_INSERT, object);
        executePreparedStatement(statement);
        long id = selectLastId();
        statement.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public void update(Cliente object) throws SQLException {
        PreparedStatement statement = objectToPreparedStatement(SQL_UPDATE, object);
        statement.setLong(6, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public void delete(Cliente object) throws SQLException {
        String query = sqlManager.generateQueryDelete(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public List<Cliente> selectAll() throws SQLException {
        List<Cliente> list = new ArrayList<Cliente>();
        String query = sqlManager.generateQuerySelectAll(TABLE_NAME);
        ResultSet resultSet = executeQueryWithResult(query);
        if (resultSet != null) {
                while (resultSet.next()){
                        list.add(resultSetToObject(resultSet));
                }
        }
        resultSet.close();
        connection.closeConnection();
        return list;
    }

    @Override
    public Cliente selectById(long id) throws SQLException {
        Cliente object = null;
        String query = sqlManager.generateQuerySelectBy(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = executePreparedStatementWithResult(statement);;
        if (resultSet != null) {
            while (resultSet.next()){
                object = resultSetToObject(resultSet);
            }
        }
        statement.close();
        resultSet.close();
        connection.closeConnection();
        return object;
    }

    @Override
    public long selectLastId() throws SQLException {
        long id = 0;
        String query = sqlManager.generateQuerySelectLastId(TABLE_NAME, COLUMN_ID);
        ResultSet resultSet = executeQueryWithResult(query);
        if (resultSet != null) {
                while (resultSet.next()){
                        id = resultSet.getLong(this.LAST_ID);
                }
        }
        resultSet.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public Cliente resultSetToObject(ResultSet resultSet) throws SQLException {
        Cliente object = new Cliente();
        
        object.setId(resultSet.getLong(COLUMN_ID));
        object.setCpf(resultSet.getString(COLUMN_CPF));
        object.setDataNascimento(resultSet.getString(COLUMN_DATA_NASCIMENTO));
        object.setEmail(resultSet.getString(COLUMN_EMAIL));
        object.setNome(resultSet.getString(COLUMN_NOME));
        object.setTelefone(resultSet.getString(COLUMN_TELEFONE));

        
        return object;
    }

    @Override
    public PreparedStatement objectToPreparedStatement(String query, Cliente object) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        
        statement.setString(1, object.getCpf());
        statement.setString(2, object.getDataNascimento());
        statement.setString(3, object.getEmail());
        statement.setString(4, object.getNome());
        statement.setString(5, object.getTelefone());
        
        return statement;
    }
    
}
