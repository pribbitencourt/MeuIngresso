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
        PessoaDAOPG pdpg = new PessoaDAOPG();
        pdpg.create(c);
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO cliente("
                    + "id"
                    + ", cpf"
                    + ", dataNascimento"
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
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    @Override
    public List<Cliente> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT id,cpf,\"dataNascimento\",email,nome,telefone FROM cliente");
        ResultSet rsCliente = pstm.executeQuery();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        while(rsCliente.next()){
            int id = rsCliente.getInt("1");
            String cpf = rsCliente.getString("2");
            String dataNascimento = rsCliente.getString("3");
            String email = rsCliente.getString("4");
            String nome = rsCliente.getString("5"); 
            String telefone = rsCliente.getString("5"); 
            Date dataNascimentoFormatada = null;
            try {
                dataNascimentoFormatada = formato.parse(dataNascimento);
            } catch (ParseException ex) {
                Logger.getLogger(ClienteDAOPG.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaClientes.add(new Cliente(id, nome, cpf, email, telefone, dataNascimentoFormatada));
        }
        return listaClientes;
    }

    @Override
    public void update(Cliente c) throws SQLException {
         try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE cliente SET"
                    + "(cpf = ?, dataNascimento = ?,email = ?, nome = ?, telefone = ?) "
                    + "WHERE id = ?");
            pstm.setString(1, c.getCpf());
            pstm.setDate(2, (java.sql.Date) formato.parse(c.getDataNascimento()));
            pstm.setString(3, c.getEmail());
            pstm.setString(4, c.getNome());
            pstm.setString(5, c.getTelefone());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        } catch (ParseException ex) {
            Logger.getLogger(ClienteDAOPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Cliente c) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE * FROM funcionario WHERE id = ?"); 
            pstm.setInt(1, c.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }
    
}
