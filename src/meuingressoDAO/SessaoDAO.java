package meuingressoDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import meuingresso.Sessao;

/**
 *
 * @author priscillabittencourt
 */
public interface SessaoDAO {
    public void create(Sessao s)throws SQLException;
    public List<Sessao> retrieve() throws SQLException;
    public void update(Sessao s) throws SQLException;
    public void delete(Sessao s) throws SQLException;   
}
