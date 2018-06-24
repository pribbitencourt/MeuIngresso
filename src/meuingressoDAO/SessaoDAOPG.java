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
        Sessao s1 = new Sessao(1, "12/05/2018", "12/06/2018", "18:00");
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO sessao("
                + "id, "
                + "data_inicio,"
                + "data_fim,"
                + "horario) VALUES (?,?,?,?)");
        pstm.setInt(1, s1.getId());
        pstm.setString(2, s1.getDataInicio());
        pstm.setString(3, s1.getDataFim());
        pstm.setString(4, s1.getHorario());
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
                + "data_inicio, "
                + "data_fim, "
                + "horario FROM SESSAO");
        ResultSet rs1 = pstm.executeQuery();
        ArrayList<Sessao> listaSessoes = new ArrayList<Sessao>();
        while(rs1.next()){
            int id = rs1.getInt("id");
            String data_inicio = rs1.getString("data_inicio");
            String data_fim = rs1.getString("data_fim");
            String horario = rs1.getString("horario");            
            listaSessoes.add(new Sessao(id, data_inicio, data_fim, horario));
        }
        return listaSessoes;
    }

    @Override
    public void update(Sessao s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE sessao SET "
                    + "id = ?, data_inicio = ?, data_fim = ?,horario = ?");
            pstm.setInt(1, s.getId());
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
    
    
    
}
