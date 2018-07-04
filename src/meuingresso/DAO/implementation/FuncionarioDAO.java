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
import meuingresso.model.implementation.Funcionario;
import meuingresso.model.implementation.Sala;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO extends AbstractDatabaseDAO implements IDatabaseDAO<Funcionario> {
    private final String TABLE_NAME = "funcionario";
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME = "nome";
    private final String COLUMN_CPF = "cpf";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_TELEFONE = "telefone";
    private final String COLUMN_DATA_NASCIMENTO = "data_nascimento";
    private final String COLUMN_TURNO = "turno";
    private final String COLUMN_FUNCAO = "funcao";
    private final String COLUMN_SALARIO = "salario";
    private final String COLUMN_DATA_CONTRATACAO = "contratacao";
    
    private final String TABLE_BODY = "("
            + this.COLUMN_ID + "SERIAL PRIMARY KEY, "
            + this.COLUMN_NOME + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_CPF + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_EMAIL +" VARCHAR(150) NOT NULL"
            + this.COLUMN_TELEFONE +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_DATA_NASCIMENTO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_TURNO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_FUNCAO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_SALARIO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_DATA_CONTRATACAO +" VARCHAR(150) NOT NULL"
            + ");";
    

    
    private final String SQL_INSERT = "INSERT INTO "
                        + TABLE_NAME
			+ "("
			+ COLUMN_NOME + ", "
			+ COLUMN_CPF + ", "
                        + COLUMN_EMAIL + ", "
                        + COLUMN_TELEFONE + ", "
                        + COLUMN_DATA_NASCIMENTO + ", "
                        + COLUMN_TURNO + ", "
                        + COLUMN_FUNCAO + ", "
                        + COLUMN_SALARIO + ", "
                        + COLUMN_DATA_CONTRATACAO
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
                        + COLUMN_TURNO + UPDATE_MARK
                        + COLUMN_FUNCAO + UPDATE_MARK
                        + COLUMN_SALARIO + UPDATE_MARK
                        + COLUMN_DATA_CONTRATACAO + UPDATE_MARK
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
    public long insert(Funcionario object) throws SQLException {
        PreparedStatement statement =  objectToPreparedStatement(SQL_INSERT, object);
        executePreparedStatement(statement);
        long id = selectLastId();
        statement.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public void update(Funcionario object) throws SQLException {
        PreparedStatement statement = objectToPreparedStatement(SQL_UPDATE, object);
        statement.setLong(10, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public void delete(Funcionario object) throws SQLException {
        String query = sqlManager.generateQueryDelete(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public List<Funcionario> selectAll() throws SQLException {
        List<Funcionario> list = new ArrayList<Funcionario>();
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
    public Funcionario selectById(long id) throws SQLException {
        Funcionario object = null;
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
    public Funcionario resultSetToObject(ResultSet resultSet) throws SQLException {
        Funcionario object = new Funcionario();
        
        object.setId(resultSet.getLong(COLUMN_ID));
        object.setCpf(resultSet.getString(COLUMN_CPF));
        object.setDataContratacao(resultSet.getString(COLUMN_DATA_CONTRATACAO));
        object.setDataNascimento(resultSet.getString(COLUMN_DATA_NASCIMENTO));
        object.setEmail(resultSet.getString(COLUMN_EMAIL));
        object.setFuncao(resultSet.getString(COLUMN_FUNCAO));
        object.setNome(resultSet.getString(COLUMN_NOME));
        object.setSalario(resultSet.getString(COLUMN_SALARIO));
        object.setTelefone(resultSet.getString(COLUMN_TELEFONE));
        object.setTurno(resultSet.getString(COLUMN_TURNO));
        
        return object;
    }

    @Override
    public PreparedStatement objectToPreparedStatement(String query, Funcionario object) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        
        statement.setString(1, object.getCpf());
        statement.setString(2, object.getDataContratacao());
        statement.setString(3, object.getDataNascimento());
        statement.setString(4, object.getEmail());
        statement.setString(5, object.getFuncao());
        statement.setString(6, object.getNome());
        statement.setString(7, object.getSalario());
        statement.setString(8, object.getTelefone());
        statement.setString(9, object.getTurno());
        
        return statement;
    }
    
}
