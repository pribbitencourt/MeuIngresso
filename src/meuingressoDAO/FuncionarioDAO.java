/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import meuingresso.Funcionario;

/**
 *
 * @author Aluno
 */
public interface FuncionarioDAO {
    public void create(Funcionario f)throws SQLException;
    public List<Funcionario> retrieve() throws SQLException;
    public void update(Funcionario f) throws SQLException;
    public void delete(Funcionario f) throws SQLException;    
}
