/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        PessoaDAOPG pdpg = new PessoaDAOPG();
        pdpg.create(f);
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO funcionario("
                    + "id"
                    + ", turno"
                    + ", funcao"
                    + ", salario"
                    + ", dataContratacao) VALUES ("
                    + "?,?,?,?,?)");
            pstm.setInt(1, f.getId());
            pstm.setString(2, f.getTurno());
            pstm.setString(3, f.getFuncao());
            pstm.setFloat(4, f.getSalario());
            pstm.setDate(5, (java.sql.Date) f.getDataContratacao());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    @Override
    public List<Funcionario> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM funcionario");
        ResultSet rsFuncionario = pstm.executeQuery();
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        while(rsFuncionario.next()){
            int id = rsFuncionario.getInt("1");
            String turno = rsFuncionario.getString("2");
            String funcao = rsFuncionario.getString("3");
            Float salario = rsFuncionario.getFloat("4");
            Date dataContratacao = rsFuncionario.getDate("5"); 
            
            PreparedStatement pstmPessoa = conn.prepareStatement("select nome, cpf, email, telefone, \"dataNascimento\" from pessoa WHERE id = ?");
            ResultSet rsPessoa = pstmPessoa.executeQuery();
            String nome = rsPessoa.getString("1");
            String cpf = rsPessoa.getString("2");
            String email = rsPessoa.getString("3");
            String telefone = rsPessoa.getString("4");
            Date datanasc = rsPessoa.getDate("5");
            listaFuncionarios.add(new Funcionario(turno, funcao, salario, id, nome, cpf, email, telefone, datanasc, dataContratacao));
        }
        return listaFuncionarios;
    }

    @Override
    public void update(Funcionario f) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE funcionario SET"
                    + "(turno = ?, funcao = ?,salario = ?, dataContratacao = ?) "
                    + "WHERE id = ?");
            pstm.setString(1, f.getTurno());
            pstm.setString(2, f.getFuncao());
            pstm.setFloat(3, f.getSalario());
            pstm.setDate(4, (java.sql.Date) f.getDataContratacao());
            pstm.setInt(5, f.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    @Override
    public void delete(Funcionario f) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE * FROM funcionario WHERE id = ?"); 
            pstm.setInt(1, f.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }
    
}
