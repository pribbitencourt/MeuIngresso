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
import meuingresso.model.implementation.Filme;

/**
 *
 * @author Aluno
 */
public class FilmeDAO extends AbstractDatabaseDAO implements IDatabaseDAO<Filme>{    
    private final String TABLE_NAME = "filme";
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_TITULO = "titulo";
    private final String COLUMN_GENERO = "genero";
    private final String COLUMN_DURACAO = "duracao";
    private final String COLUMN_PRODUTORA = "produtora";
    private final String COLUMN_CLASSIFICACAO = "classificacao";
    private final String COLUMN_DIRETOR = "diretor";
    private final String COLUMN_ATORES_PRINCIPAIS = "atoresPrincipais";
    private final String COLUMN_SINOPSE = "sinopse";
    private final String COLUMN_LEGENDA = "legenda";
    private final String COLUMN_IDIOMA = "idioma";
    
    private final String TABLE_BODY = "("
            + this.COLUMN_ID + "SERIAL PRIMARY KEY, "
            + this.COLUMN_TITULO + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_GENERO + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_DURACAO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_PRODUTORA +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_CLASSIFICACAO +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_DIRETOR +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_ATORES_PRINCIPAIS +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_SINOPSE +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_LEGENDA +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_IDIOMA +" VARCHAR(150) NOT NULL, "
            
            + ");";
    

    
    private final String SQL_INSERT = "INSERT INTO "
                        + TABLE_NAME
			+ "("
			+ COLUMN_TITULO + ", "
			+ COLUMN_GENERO + ", "
                        + COLUMN_DURACAO + ", "
                        + COLUMN_PRODUTORA + ", "
                        + COLUMN_CLASSIFICACAO + ", "
                        + COLUMN_DIRETOR + ", "
                        + COLUMN_ATORES_PRINCIPAIS + ", "
                        + COLUMN_SINOPSE + ", "   
                        + COLUMN_LEGENDA + ", "
                        + COLUMN_IDIOMA
			+ ")"
			+ " VALUES "
			+ "(?,?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_UPDATE = "UPDATE"
                        + TABLE_NAME
                        + " SET"
			+ COLUMN_TITULO + UPDATE_MARK + COMMA
			+ COLUMN_GENERO + UPDATE_MARK + COMMA
			+ COLUMN_DURACAO + UPDATE_MARK
                        + COLUMN_PRODUTORA + UPDATE_MARK
                        + COLUMN_CLASSIFICACAO + UPDATE_MARK
                        + COLUMN_DIRETOR + UPDATE_MARK
                        + COLUMN_ATORES_PRINCIPAIS + UPDATE_MARK
                        + COLUMN_SINOPSE + UPDATE_MARK
                        + COLUMN_LEGENDA + UPDATE_MARK
                        + COLUMN_IDIOMA + UPDATE_MARK
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
    public long insert(Filme object) throws SQLException {
        PreparedStatement statement =  objectToPreparedStatement(SQL_INSERT, object);
        executePreparedStatement(statement);
        long id = selectLastId();
        statement.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public void update(Filme object) throws SQLException {
        PreparedStatement statement = objectToPreparedStatement(SQL_UPDATE, object);
        statement.setLong(6, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public void delete(Filme object) throws SQLException {
        String query = sqlManager.generateQueryDelete(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public List<Filme> selectAll() throws SQLException {
        List<Filme> list = new ArrayList<Filme>();
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
    public Filme selectById(long id) throws SQLException {
        Filme object = null;
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
    public Filme resultSetToObject(ResultSet resultSet) throws SQLException {
        Filme object = new Filme();
        
        object.setId(resultSet.getLong(COLUMN_ID));
        object.setTitulo(resultSet.getString(COLUMN_TITULO));
        object.setAtoresPrincipais(resultSet.getString(COLUMN_ATORES_PRINCIPAIS));
        object.setClassificacao(resultSet.getString(COLUMN_CLASSIFICACAO));
        object.setDiretor(resultSet.getString(COLUMN_DIRETOR));
        object.setDuracao(resultSet.getString(COLUMN_DURACAO));
        object.setGenero(resultSet.getString(COLUMN_GENERO));
        object.setIdioma(resultSet.getString(COLUMN_IDIOMA));
        object.setLegenda(resultSet.getString(COLUMN_LEGENDA));
        object.setProdutora(resultSet.getString(COLUMN_PRODUTORA));
        object.setSinopse(resultSet.getString(COLUMN_SINOPSE));
        
        return object;
    }

    @Override
    public PreparedStatement objectToPreparedStatement(String query, Filme object) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        
        statement.setString(1, object.getTitulo());
        statement.setString(2, object.getGenero());
        statement.setString(3, object.getDuracao());
        statement.setString(4, object.getProdutora());
        statement.setString(5, object.getClassificacao());
        statement.setString(6, object.getDiretor());
        statement.setString(7, object.getAtoresPrincipais());
        statement.setString(8, object.getSinopse());
        statement.setString(9, object.getLegenda());
        statement.setString(10, object.getIdioma());
        
        
        return statement;
    }
    
}
