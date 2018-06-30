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
    public void create(Sala s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO sala("
                    + "numero_assentos"
                    + ", numero_sala"
                    + ",tipo_sala) VALUES (?,?,?)");
            pstm.setInt(1, s.getNumeroAssentos());
            pstm.setString(2, s.getNumeroSala());
            pstm.setString(3, s.getTipoSala());
            pstm.execute();
        } catch (SQLException e) {
            System.out.println("");
        }   
    }

    @Override
    public List<Sala> retrieve() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT id,"
                + "numero_assentos,"
                + "numero_sala,"
                + "tipo_sala FROM sala");
        ResultSet rs1 = pstm.executeQuery();
        ArrayList<Sala> listaSalas = new ArrayList<Sala>();
        while(rs1.next()){
            int id = rs1.getInt("id");
            int numero_assentos = rs1.getInt("numero_assentos");
            String numero_sala = rs1.getString("numero_sala");
            String tipoSala = rs1.getString("tipo_sala");            
            Sala sala = new Sala(numero_assentos, numero_sala, tipoSala);
            sala.setId(id);
            listaSalas.add(sala);
        }
        return listaSalas;
    }

    @Override
    public void update(Sala s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("UPDATE sala SET numero_assentos = ?, numero_sala = ?,tipo_sala = ? WHERE id= ?");
            pstm.setInt(1, s.getNumeroAssentos());
            pstm.setString(2, s.getNumeroSala());
            pstm.setString(3, s.getTipoSala());
            pstm.setInt(4, s.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Sala s) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM sala WHERE id = ?"); 
            pstm.setInt(1, s.getId());
            if(!pstm.execute()){
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public Sala retrieveOneByNome(String nome_sala) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        PreparedStatement pstm = conn.prepareStatement("SELECT id,"
                + "numero_assentos,"
                + "numero_sala,"
                + "tipo_sala FROM sala WHERE numero_sala = ?");
        pstm.setString(1, nome_sala);
        ResultSet rs1 = pstm.executeQuery();
        if (!rs1.isBeforeFirst() ) {    
          System.out.println("Sala não encontrada"); 
          return null;
        } 
        rs1.next();
        int id = rs1.getInt("id");
        int numero_assentos = rs1.getInt("numero_assentos");
        String numero_sala = rs1.getString("numero_sala");
        String tipoSala = rs1.getString("tipo_sala");            
        Sala sala = new Sala(numero_assentos, numero_sala, tipoSala);
        sala.setId(id);
        return sala;
    }
    
    
}
