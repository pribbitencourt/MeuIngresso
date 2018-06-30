package meuingressoDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import meuingresso.Sala;
import meuingresso.Sessao;

/**
 *
 * @author priscillabittencourt
 */
public class SessaoDAOPG implements SessaoDAO{    
    
    @Override
    public void create(Sessao s) throws SQLException {
        try {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO sessao("
                + "nome_sessao,"
                + "data_inicio,"
                + "data_fim,"
                + "horario) VALUES (?,?,?,?)");
        pstm.setString(1, s.getNome_sessao());
        pstm.setString(2, s.getDataInicio());
        pstm.setString(3, s.getDataFim());
        pstm.setString(4, s.getHorario());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    @Override
    public List<Sessao> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT "
                + "id, "
                + "nome_sessao, "
                + "data_inicio, "
                + "data_fim, "
                + "horario FROM SESSAO");
        ResultSet rs1 = pstm.executeQuery();
        ArrayList<Sessao> listaSessoes = new ArrayList<Sessao>();
        while(rs1.next()){
            int id = rs1.getInt("id");
            String nome_sessao = rs1.getString("nome_sessao");
            String data_inicio = rs1.getString("data_inicio");
            String data_fim = rs1.getString("data_fim");
            String horario = rs1.getString("horario");            
            Sessao sessao = new Sessao(nome_sessao, data_inicio, data_fim, horario);
            sessao.setId(id);
            listaSessoes.add(sessao);
        }
        return listaSessoes;
    }

    @Override
    public void update(Sessao s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE sessao SET "
                    + "nome_sessao = ?, data_inicio = ?, data_fim = ?,horario = ? WHERE id = ?");
            pstm.setString(1, s.getNome_sessao());
            pstm.setString(2, s.getDataInicio());
            pstm.setString(3, s.getDataFim());
            pstm.setString(4, s.getHorario());
            pstm.setInt(5, s.getId());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Sessao s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM sessao WHERE id = ?"); 
            pstm.setInt(1, s.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Sessao retrieveOneByNome(String nome) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT "
                + "id, "
                + "data_inicio, "
                + "data_fim, "
                + "horario,"
                + "nome_sessao FROM SESSAO WHERE nome_sessao = ?");
        pstm.setString(1, nome);
        ResultSet rs1 = pstm.executeQuery();
        if (!rs1.isBeforeFirst() ) {    
          System.out.println("Sessao não encontrada"); 
          return null;
        } 
        rs1.next();
        int id = rs1.getInt("id");
        String data_inicio = rs1.getString("data_inicio");
        String data_fim = rs1.getString("data_fim");
        String horario = rs1.getString("horario");            
        String nome_sessao = rs1.getString("nome_sessao");            
        Sessao sessao = new Sessao(nome_sessao, data_inicio, data_fim, horario);
        sessao.setId(id);
        
        return sessao;
    }
    
    
    
}
