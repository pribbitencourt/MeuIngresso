package meuingresso.DAO.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import meuingresso.DAO.abstractType.AbstractDatabaseDAO;
import meuingresso.DAO.abstractType.IDatabaseDAO;
import meuingresso.model.implementation.Sessao;

/**
 *
 * @author priscillabittencourt
 */
public class SessaoDAO extends AbstractDatabaseDAO implements IDatabaseDAO<Sessao>{
    
    private final String TABLE_NAME = "sessao";
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME_SESSAO = "nome_sessao";
    private final String COLUMN_DATA_INICIO = "data_inicio";
    private final String COLUMN_DATA_FIM = "data_fim";
    private final String COLUMN_HORARIO = "horario";
    
    private final String TABLE_BODY = "("
            + this.COLUMN_ID + "SERIAL PRIMARY KEY, "
            + this.COLUMN_NOME_SESSAO + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_DATA_INICIO + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_DATA_FIM +" VARCHAR(150) NOT NULL, "
            + this.COLUMN_HORARIO +" VARCHAR(150) NOT NULL"
            + ");";
    
    
    
    private final String SQL_INSERT = "INSERT INTO "
                        + TABLE_NAME
			+ "("
			+ COLUMN_NOME_SESSAO + ", "
			+ COLUMN_DATA_INICIO + ", "
			+ COLUMN_DATA_FIM + ", "
                        + COLUMN_HORARIO
			+ ")"
			+ " VALUES "
			+ "(?,?,?,?)";
	
	private final String SQL_UPDATE = "UPDATE "
                        + TABLE_NAME
                        + " SET"
			+ COLUMN_NOME_SESSAO + UPDATE_MARK + COMMA
			+ COLUMN_DATA_INICIO + UPDATE_MARK + COMMA
			+ COLUMN_DATA_FIM + UPDATE_MARK
                        + COLUMN_HORARIO + UPDATE_MARK
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
    public long insert(Sessao object) throws SQLException {
        PreparedStatement statement =  objectToPreparedStatement(SQL_INSERT, object);
        executePreparedStatement(statement);
        long id = selectLastId();
        statement.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public void update(Sessao object) throws SQLException {
        PreparedStatement statement = objectToPreparedStatement(SQL_UPDATE, object);
        statement.setLong(5, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public void delete(Sessao object) throws SQLException {
        String query = sqlManager.generateQueryDelete(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public List<Sessao> selectAll() throws SQLException {
        List<Sessao> list = new ArrayList<Sessao>();
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
    public Sessao selectById(long id) throws SQLException {
        Sessao object = null;
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
    public Sessao resultSetToObject(ResultSet resultSet) throws SQLException {
        Sessao object = new Sessao();
        
        object.setId(resultSet.getLong(COLUMN_ID));
        object.setNomeSessao(resultSet.getString(COLUMN_NOME_SESSAO));
        object.setDataInicio(resultSet.getString(COLUMN_DATA_INICIO));
        object.setDataFim(resultSet.getString(COLUMN_DATA_FIM));
        object.setHorario(resultSet.getString(COLUMN_HORARIO));
        
        return object;
    }

    @Override
    public PreparedStatement objectToPreparedStatement(String query, Sessao object) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        
        statement.setString(1, object.getNome_sessao());
        statement.setString(2, object.getDataInicio());
        statement.setString(3, object.getDataFim());
        statement.setString(4, object.getHorario());
        
        return statement;
    }
}
