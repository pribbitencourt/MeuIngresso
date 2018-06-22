/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import meuingresso.Pessoa;

/*
create table Pessoa (
id serial,
nome text,
cpf text,
email text,
telefone text,
dataNascimento date);
alter table Pessoa add primary key (id);
*/

public class PessoaDAOPG implements PessoaDAO{

    @Override
    public void create(String nome, String cpf, String email, String telefone, Date dataNascimento) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/rrieiro", "postgres", "aluno");
        Statement st = conn.createStatement();
        String sql = String.format("INSERT INTO Pessoa(nome, cpf, email, telefone, dataNascimento) values ('%s', '%s', '%s', '%s', '%s');",
                nome, cpf, email, telefone, dataNascimento.toString());
        st.execute(sql);
    }

    @Override
    public List<Pessoa> retrieve() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pessoa p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pessoa p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
