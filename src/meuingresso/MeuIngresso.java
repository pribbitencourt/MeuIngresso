
package meuingresso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import meuingressoDAO.ClienteDAOPG;
import meuingressoDAO.FilmeDAOPG;
import meuingressoDAO.FuncionarioDAOPG;
import meuingressoDAO.SessaoDAOPG;

/**
 *
 * @author priscillabittencourt
 */
public class MeuIngresso {

    
    public static void main(String[] args) throws SQLException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
// CREATE
//        Cliente c1 = new Cliente(3, "Arthur Alves Venturin", "071.592.159-23"
//                , "arthur.alves.venturin@gmail.com", "33237502", formato.parse("13/10/1991"));
//        ClienteDAOPG ClienteDAO = new ClienteDAOPG();
//        ClienteDAO.create(c1);
// RETRIEVE
//        ClienteDAOPG ClienteDAO = new ClienteDAOPG();
//        System.out.println(ClienteDAO.retrieve());
// UPDATE
//          ClienteDAOPG ClienteDAO = new ClienteDAOPG();
//          Cliente c1 = new Cliente(1, "Priscilla", "082.627.869-80"
//                , "Pribb@gmail.com", "999721918", formato.parse("12/11/1991"));
//          ClienteDAO.update(c1);
// DELETE
//          ClienteDAOPG ClienteDAO = new ClienteDAOPG();
//          Cliente c1 = new Cliente(3, "Priscilla", "082.627.869-80"
//                , "Pribb@gmail.com", "999721918", formato.parse("12/11/1991"));
//          ClienteDAO.delete(c1);
// FILME
// CREATE
//        Filme f1 = new Filme(1, "HP PF", "Aventura", "120min", "Warner", "12+", "JK Rowling", "Daniel,Emma,Ruppert", "Bla bla bla", "ingles, portugues, arabe", "ingles,portugues, arabe");
//        FilmeDAOPG FilmeDAO = new FilmeDAOPG();
//        FilmeDAO.create(f1);
// RETRIEVE
//        FilmeDAOPG FilmeDAO = new FilmeDAOPG();
//        System.out.println(FilmeDAO.retrieve());
// UPDATE
//          FilmeDAOPG FilmeDAO = new FilmeDAOPG();
//          Filme f1 = new Filme(1, "HP CS", 
//                  "Aventura", "120min", "Warner", 
//                  "12+", "JK Rowling", "Daniel,Emma,Ruppert", 
//                  "Bla bla bla", "ingles, portugues, arabe", 
//                  "ingles,portugues, arabe");
//          FilmeDAO.update(f1);
// DELETE
//          FilmeDAOPG FilmeDAO = new FilmeDAOPG();
//          Filme f1 = new Filme(1, "HP CS", 
//                  "Aventura", "120min", "Warner", 
//                  "12+", "JK Rowling", "Daniel,Emma,Ruppert", 
//                  "Bla bla bla", "ingles, portugues, arabe", 
//                  "ingles,portugues, arabe");
//          FilmeDAO.delete(f1);
//FUNCIONARIO
// CREATE
//        Funcionario func1 = new Funcionario("matutino/vespertino", "caixa", 500, 1, "Arthur", "000.000.000-00", "a@a.com.br", "33230931", formato.parse("10/10/1991"), formato.parse("10/10/1991"));
//        FuncionarioDAOPG FuncionarioDAO = new FuncionarioDAOPG();
//        FuncionarioDAO.create(func1);
// RETRIEVE
//        FuncionarioDAOPG FuncionarioDAO = new FuncionarioDAOPG();
//        System.out.println(FuncionarioDAO.retrieve());
// UPDATE
//        Funcionario func1 = new Funcionario("matutino", "caixa2", 500, 1, "Priscilla", "000.000.000-00", "a@a.com.br", "33230931", "10/10/1991", "10/10/1991");
//        FuncionarioDAOPG FuncionarioDAO = new FuncionarioDAOPG();
//        FuncionarioDAO.update(func1);
// DELETE
//        Funcionario func1 = new Funcionario("matutino", "caixa2", 500, 1, "Priscilla", "000.000.000-00", "a@a.com.br", "33230931", "10/10/1991", "10/10/1991");
//        FuncionarioDAOPG FuncionarioDAO = new FuncionarioDAOPG();
//        FuncionarioDAO.delete(func1);
//SESSAO
// CREATE
//        Sessao sessao1 = new Sessao(1, "10/12/1991", "12/12/1991", "20:00");
//        SessaoDAOPG SessaoDAO = new SessaoDAOPG();
//        SessaoDAO.create(sessao1);
// RETRIEVE
//        SessaoDAOPG SessaoDAO = new SessaoDAOPG();
//        System.out.println(SessaoDAO.retrieve());
// UPDATE
//        Sessao sessao1 = new Sessao(1, "10/10/1991", "12/10/1991", "19:00");
//        SessaoDAOPG SessaoDAO = new SessaoDAOPG();
//        SessaoDAO.update(sessao1);
// DELETE
//        Sessao sessao1 = new Sessao(1, "10/10/1991", "12/10/1991", "19:00");
//        SessaoDAOPG SessaoDAO = new SessaoDAOPG();
//        SessaoDAO.delete(sessao1);
    }
    
}
