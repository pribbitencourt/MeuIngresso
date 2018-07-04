
package meuingresso.DAO.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import meuingresso.DAO.abstractType.AbstractDatabaseDAO;
import meuingresso.DAO.abstractType.IDatabaseDAO;
import meuingresso.model.implementation.Sala;

/**
 *
 * @author priscillabittencourt
 */
public class SalaDAO extends AbstractDatabaseDAO implements IDatabaseDAO<Sala> {

    private final String TABLE_NAME = "sala";
    private final String TABLE_BODY = "("
            + this.COLUMN_ID + "SERIAL PRIMARY KEY, "
            + this.COLUMN_NUMERO_ASSENTOS + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_NUMERO_SALA + "VARCHAR(150) NOT NULL, "
            + this.COLUMN_TIPO_SALA +" VARCHAR(150) NOT NULL"
            + ");";
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_NUMERO_ASSENTOS = "numero_assentos";
    private final String COLUMN_NUMERO_SALA = "numero_sala";
    private final String COLUMN_TIPO_SALA = "tipo_sala";
    
    private final String SQL_INSERT = "INSERT INTO "
                        + TABLE_NAME
			+ "("
			+ COLUMN_NUMERO_ASSENTOS + ", "
			+ COLUMN_NUMERO_SALA + ", "
			+ COLUMN_TIPO_SALA
			+ ")"
			+ " VALUES "
			+ "(?,?,?)";
	
	private final String SQL_UPDATE = "UPDATE"
                        + TABLE_NAME
                        + " SET"
			+ COLUMN_NUMERO_ASSENTOS + UPDATE_MARK + COMMA
			+ COLUMN_NUMERO_SALA + UPDATE_MARK + COMMA
			+ COLUMN_TIPO_SALA + UPDATE_MARK
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
    public long insert(Sala object) throws SQLException {
        PreparedStatement statement =  objectToPreparedStatement(SQL_INSERT, object);
        executePreparedStatement(statement);
        long id = selectLastId();
        System.out.println(id);
        statement.close();
        connection.closeConnection();
        return id;
    }

    @Override
    public void update(Sala object) throws SQLException {
        PreparedStatement statement = objectToPreparedStatement(SQL_UPDATE, object);
        statement.setLong(4, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public void delete(Sala object) throws SQLException {
        String query = sqlManager.generateQueryDelete(TABLE_NAME, COLUMN_ID);
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        statement.setLong(1, object.getId());
        executePreparedStatement(statement);
        statement.close();
        connection.closeConnection();
    }

    @Override
    public List<Sala> selectAll() throws SQLException {
        List<Sala> list = new ArrayList<Sala>();
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
    public Sala selectById(long id) throws SQLException {
        Sala object = null;
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
    public Sala resultSetToObject(ResultSet resultSet) throws SQLException {
        Sala object = new Sala();
        
        object.setId(resultSet.getLong(COLUMN_ID));
        object.setNumeroAssentos(resultSet.getString(COLUMN_NUMERO_ASSENTOS));
        object.setNumeroSala(resultSet.getString(COLUMN_NUMERO_SALA));
        object.setTipoSala(resultSet.getString(COLUMN_TIPO_SALA));
        
        return object;
    }

    @Override
    public PreparedStatement objectToPreparedStatement(String query, Sala object) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(query);
        
        statement.setString(1, object.getNumeroAssentos());
        statement.setString(2, object.getNumeroSala());
        statement.setString(3, object.getTipoSala());
        
        return statement;
    }
    
}
