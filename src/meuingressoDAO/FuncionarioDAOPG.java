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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import meuingresso.Funcionario;


/**
 *
 * @author priscillabittencourt
 */
public class FuncionarioDAOPG implements FuncionarioDAO {

    @Override
    public void create(Funcionario f) throws SQLException {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO funcionario("
                    + "id "
                    + ", turno"
                    + ", funcao"
                    + ", salario"
                    + ", data_contratacao) VALUES ("
                    + "?,?,?,?,?)");
            pstm.setInt(1, f.getId());
            pstm.setString(2, f.getTurno());
            pstm.setString(3, f.getFuncao());
            pstm.setFloat(4, f.getSalario());
            pstm.setString(5, f.getDataContratacao());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Funcionario> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT id,"
                + "turno,"
                + "funcao,"
                + "salario,"
                + "data_contratacao "
                + " FROM funcionario");
        ResultSet rsFuncionario = pstm.executeQuery();
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        while(rsFuncionario.next()){
            int id = rsFuncionario.getInt("id");
            String turno = rsFuncionario.getString("turno");
            String funcao = rsFuncionario.getString("funcao");
            Float salario = rsFuncionario.getFloat("salario");
            String dataContratacao = rsFuncionario.getString("data_contratacao"); 
            
            PreparedStatement pstmPessoa = conn.prepareStatement("select nome, "
                    + "cpf, "
                    + "email, "
                    + "telefone, "
                    + "data_nascimento "
                    + "from pessoa WHERE id = ?");
            pstmPessoa.setInt(1, id);
            ResultSet rsPessoa = pstmPessoa.executeQuery();
            rsPessoa.next();
            String nome = rsPessoa.getString("nome");
            String cpf = rsPessoa.getString("cpf");
            String email = rsPessoa.getString("email");
            String telefone = rsPessoa.getString("telefone");
            String datanasc = rsPessoa.getString("data_nascimento");
            listaFuncionarios.add(new Funcionario(turno, funcao, salario, nome, cpf, email, telefone, datanasc, dataContratacao ));
        }
        return listaFuncionarios;
    }

    @Override
    public void update(Funcionario f) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE funcionario SET"
                    + " turno = ?, funcao = ?,salario = ?, data_contratacao = ?  "
                    + "WHERE id = ?");
            pstm.setString(1, f.getTurno());
            pstm.setString(2, f.getFuncao());
            pstm.setFloat(3, f.getSalario());
            pstm.setString(4, f.getDataContratacao());
            pstm.setInt(5, f.getId());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Funcionario f) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM funcionario WHERE id = ?"); 
            pstm.setInt(1, f.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Funcionario retrieveOneByCPF(String cpf) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstmPessoa = conn.prepareStatement("select id,"
                + " nome, "
                    + "cpf, "
                    + "email, "
                    + "telefone, "
                    + "data_nascimento "
                    + "from pessoa WHERE cpf = ?");
        pstmPessoa.setString(1, cpf);
        ResultSet rsPessoa = pstmPessoa.executeQuery();
        if (!rsPessoa.isBeforeFirst() ) {    
          System.out.println("Funcionário não encontrado"); 
          return null;
        } 
        rsPessoa.next();
        int id = rsPessoa.getInt("id");
        String nome = rsPessoa.getString("nome");
        String cpf_funcionario = rsPessoa.getString("cpf");
        String email = rsPessoa.getString("email");
        String telefone = rsPessoa.getString("telefone");
        String datanasc = rsPessoa.getString("data_nascimento");
        
        String sqlSelectFuncionario = "SELECT id,"
                + "turno,"
                + "funcao,"
                + "salario,"
                + "data_contratacao "
                + " FROM funcionario"
                + " WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sqlSelectFuncionario);
        pstm.setInt(1, id);
        ResultSet rsFuncionario = pstm.executeQuery();
        if (!rsFuncionario.isBeforeFirst() ) {    
          System.out.println("Funcionário não encontrado"); 
          return null;
        } 
        rsFuncionario.next();
        String turno = rsFuncionario.getString("turno");
        String funcao = rsFuncionario.getString("funcao");
        Float salario = rsFuncionario.getFloat("salario");   
        String datacontratacao = rsFuncionario.getString("data_contratacao");   
            
        Funcionario funcionario = new Funcionario(
                turno
                , funcao
                , salario
                , nome
                , cpf_funcionario
                , email
                , telefone
                , datanasc
                , datacontratacao);
        funcionario.setId(id);
        
        return funcionario;
    }
    
}
