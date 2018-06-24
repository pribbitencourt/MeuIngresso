/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public void create(Pessoa p) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO pessoa(id, cpf, data_nascimento,email, nome, telefone) VALUES (?,?,?,?,?,?)");
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getCpf());
            pstm.setString(3, p.getDataNascimento());
            pstm.setString(4, p.getEmail());
            pstm.setString(5, p.getNome());
            pstm.setString(6, p.getTelefone());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?"); 
            pstm.setInt(1, p.getId());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
