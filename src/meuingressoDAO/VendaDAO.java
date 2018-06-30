/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.SQLException;
import java.util.List;
import meuingresso.Venda;

/**
 *
 * @author priscillabittencourt
 */
public interface VendaDAO {
    public void create(Venda s)throws SQLException;
    public List<Venda> retrieve() throws SQLException;
    public void update(Venda s) throws SQLException;
    public void delete(Venda s) throws SQLException; 
}
