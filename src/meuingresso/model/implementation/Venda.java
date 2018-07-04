package meuingresso.model.implementation;

import meuingresso.model.abstractType.Produto;
import java.util.ArrayList;

/**
 *
 * @author priscillabittencourt
 */
public class Venda {
  
    private int id;
    private String formaPagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Produto> carrinhoDeCompras;
    private float valorTotalVenda = 0;

    public Venda(Cliente c1, Funcionario f1, String formaPagamento) {
        this.setCliente(c1);
        this.setFuncionario(f1);
        this.setFormaPagamento(formaPagamento);
        this.carrinhoDeCompras = new ArrayList();
    }

    public void addProdutoCarrinhoDeCompras(Produto p1){
        this.carrinhoDeCompras.add(p1);
    }
    public float getValorTotalVenda(){
        if(valorTotalVenda != 0){
            return valorTotalVenda;
        }
        for(Produto p: carrinhoDeCompras){
            valorTotalVenda += p.getValor();
        }
        return valorTotalVenda;
    }
    public ArrayList<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
