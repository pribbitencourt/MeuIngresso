/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.SQLException;
import java.util.List;
import meuingresso.Filme;

/**
 *
 * @author Aluno
 */
public interface FilmeDAO {
    public void create(Filme filme)throws SQLException;
    public List<Filme> retrieve() throws SQLException;
    public void update(Filme filme) throws SQLException;
    public void delete(Filme filme) throws SQLException;    
}
