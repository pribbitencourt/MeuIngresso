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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import meuingresso.Cliente;
import meuingresso.Funcionario;

/**
 *
 * @author priscillabittencourt
 */
public class ClienteDAOPG implements ClienteDAO {

    @Override
    public void create(Cliente c) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO cliente("
                    + "id "
                    + ", cpf"
                    + ", data_nascimento"
                    + ", email"
                    + ", nome"
                    + ", telefone) VALUES ("
                    + "?,?,?,?,?,?)");
            pstm.setInt(1, c.getId());
            pstm.setString(2, c.getCpf());
            pstm.setString(3, c.getDataNascimento());
            pstm.setString(4, c.getEmail());
            pstm.setString(5, c.getNome());
            pstm.setString(6, c.getTelefone());
            pstm.execute();
            System.out.println("Cliente cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cliente> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT id,cpf,data_nascimento,email,nome,telefone FROM cliente");
        ResultSet rsCliente = pstm.executeQuery();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        while(rsCliente.next()){
            int id = rsCliente.getInt("id");
            String cpf = rsCliente.getString("cpf");
            String dataNascimento = rsCliente.getString("data_nascimento");
            String email = rsCliente.getString("email");
            String nome = rsCliente.getString("nome"); 
            String telefone = rsCliente.getString("telefone"); 
            listaClientes.add(new Cliente(nome, cpf, email, telefone, dataNascimento));
        }
        return listaClientes;
    }

    @Override
    public void update(Cliente c) throws SQLException {
         try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE cliente SET "
                    + "cpf = ?, data_nascimento = ?, email = ?, nome = ?, telefone = ? "
                    + " WHERE id = ?;");
            pstm.setString(1, c.getCpf());
            pstm.setString(2, c.getDataNascimento());
            pstm.setString(3, c.getEmail());
            pstm.setString(4, c.getNome());
            pstm.setString(5, c.getTelefone());
            pstm.setInt(6, c.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Cliente c) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM cliente WHERE id = ?"); 
            pstm.setInt(1, c.getId());
            pstm.execute();
            PessoaDAOPG pdaopg = new PessoaDAOPG();
            pdaopg.delete(c);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente retrieveOneByCPF(String cpf) throws SQLException {
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
          System.out.println("Cliente não encontrado"); 
          return null;
        } 
        rsPessoa.next();
        int id = rsPessoa.getInt("id");
        
        String sqlSelectCliente = "SELECT id,"
                + "nome,"
                + "cpf,"
                + "email,"
                + "telefone, "
                + "data_nascimento"
                + " FROM cliente"
                + " WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sqlSelectCliente);
        pstm.setInt(1, id);
        ResultSet rsCliente = pstm.executeQuery();
        if (!rsCliente.isBeforeFirst() ) {    
          System.out.println("Cliente não encontrado"); 
          return null;
        } 
        rsCliente.next();
        String nome_cliente = rsCliente.getString("nome");
        String cpf_cliente = rsCliente.getString("cpf");
        String email_cliente = rsCliente.getString("email");   
        String telefone_cliente = rsCliente.getString("telefone");   
        String datanasc_cliente = rsCliente.getString("data_nascimento");   
            
        Cliente cliente = new Cliente(nome_cliente
                , cpf_cliente
                , email_cliente
                , telefone_cliente
                , datanasc_cliente);
        cliente.setId(id);
        
        return cliente;
    }
    
}
