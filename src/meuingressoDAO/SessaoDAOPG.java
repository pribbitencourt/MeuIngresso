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
    public void create(String nome) throws SQLException {
        try {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd-MM-yyyy");
        Sessao s1 = new Sessao(1, formatter.parse("12-05-2018"), formatter.parse("12-06-2018"), "18:00");
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO sala(id, dataInicio,dataFim ,horario) VALUES (?,?,?,?)");
        pstm.setInt(1, s1.getId());
        pstm.setDate(2, (Date) s1.getDataInicio());
        pstm.setDate(3, (Date) s1.getDataFim());
        pstm.setString(4, s1.getHorario());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        } catch (ParseException ex) {
            Logger.getLogger(SessaoDAOPG.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<Sessao> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM SESSAO");
        ResultSet rs1 = pstm.executeQuery();
        ArrayList<Sessao> listaSessoes = new ArrayList<Sessao>();
        while(rs1.next()){
            int id = rs1.getInt("1");
            Date data_inicio = rs1.getDate("2");
            Date data_fim = rs1.getDate("3");
            String horario = rs1.getString("4");            
            try {
                listaSessoes.add(new Sessao(id, data_inicio, data_fim, horario));
            } catch (ParseException ex) {
                Logger.getLogger(SessaoDAOPG.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSessoes;
    }

    @Override
    public void update(Sessao s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd-MM-yyyy");
            Sessao s1 = new Sessao(1, formatter.parse("12-05-2018"), formatter.parse("12-06-2018"), "18:00");
            PreparedStatement pstm = conn.prepareStatement("UPDATE sessao SET(id = ?, datainicio = ?, datafim = ?,horario = ?");
            pstm.setInt(1, s1.getId());
            pstm.setDate(2, (Date) s1.getDataInicio());
            pstm.setDate(3, (Date) s1.getDataFim());
            pstm.setString(4, s1.getHorario());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        } catch (ParseException ex) {
            Logger.getLogger(SessaoDAOPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Sessao s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd-MM-yyyy");
            Sessao s1 = new Sessao(1, formatter.parse("12-05-2018"), formatter.parse("12-06-2018"), "18:00");
            PreparedStatement pstm = conn.prepareStatement("DELETE * FROM sessao WHERE id = ?"); 
            pstm.setInt(1, s1.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        } catch (ParseException ex) {
            Logger.getLogger(SessaoDAOPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
