
package meuingresso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priscillabittencourt
 */
public class MeuIngresso {

    
    public static void main(String[] args) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM sala;");
        List<Sala> listaDeSala = new ArrayList<Sala>();
        while(rs.next()){
            Sala objSala =  new Sala(rs.getInt("id"),
                                    rs.getInt("numero_assentos"),
                                    rs.getString("numero_sala"),
                                    rs.getString("tipoSala")
            );
            listaDeSala.add(objSala);
        }
        System.out.println(listaDeSala.size());
    }
    
}
