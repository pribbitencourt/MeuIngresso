
package meuingressoDAO;

import java.sql.SQLException;
import java.util.List;
import meuingresso.Sala;

/**
 *
 * @author priscillabittencourt
 */
public interface SalaDAO {
    public void create(String numeroSala)throws SQLException;
    public List<Sala> retrieve() throws SQLException;
    public void update(Sala s) throws SQLException;
    public void delete(Sala s) throws SQLException;
}
