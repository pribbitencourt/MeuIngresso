/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.DAO.abstractType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author priscillabittencourt
 */
public interface IDatabaseDAO<T> {
	
	public void createTable();
	
	public long insert(T object) throws SQLException;
	
	public void update(T object) throws SQLException;
	
	public void delete(T object) throws SQLException;
	
	public List<T> selectAll() throws SQLException;
	
	public T selectById(long id) throws SQLException;
	
	public long selectLastId() throws SQLException;
	
	public T resultSetToObject(ResultSet resultSet) throws SQLException;
	
	public PreparedStatement objectToPreparedStatement(String query, T object) throws SQLException;
	
}
