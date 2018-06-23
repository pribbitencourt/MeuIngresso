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
import meuingresso.Funcionario;
import meuingresso.Sala;

/**
 *
 * @author priscillabittencourt
 */
public class FuncionarioDAOPG implements FuncionarioDAO {

    @Override
    public void create(Funcionario f) throws SQLException {
         try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO funcionario(id, cpf, data,tipoSala) VALUES (?,?,?,?)");
            pstm.setInt(1, f.getId());
            pstm.setString(2, f.getCpf());
            pstm.setString(3, f.getDataContratacao());
            pstm.setString(4, f.getDataNascimento());
            pstm.setString(4, f.getEmail());
            pstm.setString(4, f.getFuncao());
            pstm.setString(4, f.getNome());
            pstm.setString(4, f.getTelefone());
            pstm.setString(4, f.getTurno());
            pstm.setFloat(4, f.getSalario());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    @Override
    public List<Funcionario> retrieve() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Funcionario f) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Funcionario f) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
