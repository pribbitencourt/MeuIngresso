/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.SQLException;
import java.util.List;
import meuingresso.Cliente;

/**
 *
 * @author Aluno
 */
public interface ClienteDAO {
    public void create(String numeroSala)throws SQLException;
    public List<Cliente> retrieve() throws SQLException;
    public void update(Cliente c) throws SQLException;
    public void delete(Cliente c) throws SQLException;    
}
