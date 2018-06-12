package meuingressoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import meuingresso.Sala;

/**
 *
 * @author priscillabittencourt
 */
public class SalaDAOPG implements SalaDAO {

    @Override
    public void create(String numeroSala) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            Sala s1 = new Sala(1, 50, "Sala 3", "Legendada");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO sala(id, numero_assentos, numero_sala,tipoSala) VALUES (?,?,?,?)");
            pstm.setInt(1, s1.getId());
            pstm.setInt(2, s1.getNumeroAssentos());
            pstm.setString(3, s1.getNumeroSala());
            pstm.setString(4, s1.getTipoSala());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        
        
    }

    @Override
    public List<Sala> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM CINEMA");
        ResultSet rs1 = pstm.executeQuery();
        ArrayList<Sala> listaSalas = new ArrayList<Sala>();
        while(rs1.next()){
            int id = rs1.getInt("1");
            int numero_assentos = rs1.getInt("2");
            String numero_sala = rs1.getString("3");
            String tipoSala = rs1.getString("4");            
            listaSalas.add(new Sala(id, numero_assentos, numero_sala, tipoSala));
        }
        return listaSalas;
    }

    @Override
    public void update(Sala s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            Sala s1 = new Sala(1, 50, "Sala 3", "Legendada");
            PreparedStatement pstm = conn.prepareStatement("UPDATE sala SET(id = ?, numero_assentos = ?, numero_sala = ?,tipoSala = ?");
            pstm.setInt(1, s1.getId());
            pstm.setInt(2, s1.getNumeroAssentos());
            pstm.setString(3, s1.getNumeroSala());
            pstm.setString(4, s1.getTipoSala());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    @Override
    public void delete(Sala s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            Sala s1 = new Sala(1, 50, "Sala 3", "Legendada");
            PreparedStatement pstm = conn.prepareStatement("DELETE * FROM sala WHERE id = ?"); 
            pstm.setInt(1, s1.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        
    }
    
    
}
