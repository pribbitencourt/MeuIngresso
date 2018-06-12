/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import meuingresso.Pessoa;

/**
 *
 * @author Aluno
 */
public interface PessoaDAO {

    public void create(String nome, String cpf, String email, String telefone, Date dataNascimento)throws SQLException;
    public List<Pessoa> retrieve() throws SQLException;
    public void update(Pessoa p) throws SQLException;
    public void delete(Pessoa p) throws SQLException;    
    
}
