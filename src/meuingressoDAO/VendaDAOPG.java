/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingressoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import meuingresso.Produto;
import meuingresso.Venda;

/**
 *
 * @author priscillabittencourt
 */
public class VendaDAOPG implements VendaDAO {

    @Override
    public void create(Venda venda) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema","postgres","Rosabusin12");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO venda("
                    + ", cliente_id"
                    + ", funcionario_id"
                    + ", valor_total_venda) VALUES (?,?,?,?)");
            pstm.setInt(1, venda.getId());
            pstm.setInt(2, venda.getCliente().getId());
            pstm.setInt(3, venda.getFuncionario().getId());
            pstm.setFloat(4, venda.getValorTotalVenda());
            pstm.execute();
            
            for(Produto p: venda.getCarrinhoDeCompras()){
                    PreparedStatement pstmProdutosVendidos = conn.prepareStatement("INSERT INTO carrinho_compras("
                        + ", venda_id"
                        + ", produto_id"
                        + ") VALUES (?,?)");
                pstmProdutosVendidos.setInt(1, venda.getId());
                pstmProdutosVendidos.setInt(2, p.getId());
                pstmProdutosVendidos.execute();
            }
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Venda> retrieve() throws SQLException {
        return null;
    }

    @Override
    public void update(Venda venda) throws SQLException {
        
    }

    @Override
    public void delete(Venda venda) throws SQLException {
        
    }
    
}
