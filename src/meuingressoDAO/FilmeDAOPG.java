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
import java.util.List;
import meuingresso.Filme;
import meuingresso.Sala;

/**
 *
 * @author priscillabittencourt
 */
public class FilmeDAOPG implements FilmeDAO {

    @Override
    public void create(Filme filme) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            String sqlFilme = "INSERT INTO filme("
                    + "id"
                    + ", titulo"
                    + ", sinopse"
                    + ", produtora"
                    + ", legenda"
                    + ", idioma"
                    + ", genero"
                    + ", duracao"
                    + ", diretor"
                    + ", classificacao"
                    + ", atores_principais) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sqlFilme);
            pstm.setInt(1, filme.getId());
            pstm.setString(2, filme.getTitulo());
            pstm.setString(3, filme.getSinopse());
            pstm.setString(4, filme.getProdutora());
            pstm.setString(5, filme.getLegenda());
            pstm.setString(6, filme.getIdioma());
            pstm.setString(7, filme.getGenero());
            pstm.setString(8, filme.getDuracao());
            pstm.setString(9, filme.getDiretor());
            pstm.setString(10, filme.getClassificacao());
            pstm.setString(11, filme.getAtoresPrincipais());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Filme> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        String sqlSelectFilme = "SELECT "
                + "id,"
                + "titulo,"
                + "genero,"
                + "duracao,"
                + "produtora,"
                + "classificacao,"
                + "diretor,"
                + "atores_principais,"
                + "sinopse,"
                + "legenda,"
                + "idioma"
                + " FROM filme";
        PreparedStatement pstm = conn.prepareStatement(sqlSelectFilme);
        ResultSet rsFilme = pstm.executeQuery();
        ArrayList<Filme> listaFilmes = new ArrayList<Filme>();
        while(rsFilme.next()){
            int id = rsFilme.getInt("id");
            String titulo = rsFilme.getString("titulo");
            String genero = rsFilme.getString("genero");
            String duracao = rsFilme.getString("duracao");
            String produtora = rsFilme.getString("produtora"); 
            String classificacao = rsFilme.getString("classificacao");
            String diretor = rsFilme.getString("diretor");
            String atoresPrincipais = rsFilme.getString("atores_principais");
            String sinopse = rsFilme.getString("sinopse");
            String legenda = rsFilme.getString("legenda");
            String idioma = rsFilme.getString("idioma");
            listaFilmes.add(new Filme(id, titulo,genero,duracao, produtora,classificacao, diretor, atoresPrincipais,sinopse,legenda,idioma));
        }
        return listaFilmes;
    }

    @Override
    public void update(Filme filme) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE filme SET "
                    + "titulo = ?, "
                    + "genero = ?, "
                    + "duracao = ?, "
                    + "produtora = ?, "
                    + "classificacao = ?, "
                    + "diretor = ?,"
                    + "atores_principais = ?,"
                    + "sinopse = ?,"
                    + "legenda = ?,"
                    + "idioma = ? "
                    + " WHERE id = ?;");
            pstm.setString(1, filme.getTitulo());
            pstm.setString(2, filme.getGenero());
            pstm.setString(3, filme.getDuracao());
            pstm.setString(4, filme.getProdutora());
            pstm.setString(5, filme.getClassificacao());
            pstm.setString(6, filme.getDiretor());
            pstm.setString(7, filme.getAtoresPrincipais());
            pstm.setString(8, filme.getSinopse());
            pstm.setString(9, filme.getLegenda());
            pstm.setString(10, filme.getIdioma());
            pstm.setInt(11, filme.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Filme filme) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM filme WHERE id = ?"); 
            pstm.setInt(1, filme.getId());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
