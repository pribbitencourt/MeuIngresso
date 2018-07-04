package meuingresso.model.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author priscillabittencourt
 */
public class CartaoFidelidade {
   
    private String numeroCartao;
    private Date dataAdesao = null;
    private String cpf;
    private Cliente clienteFidelizado;
    
    public Date getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(Date dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    public Cliente getClienteFidelizado() {
        return clienteFidelizado;
    }

    public void setClienteFidelizado(Cliente clienteFidelizado) {
        this.clienteFidelizado = clienteFidelizado;
    }
    
    /**
     * Método responsável por retornar a data de contratação de um objeto funcionario no formato texto.
     * @return String
     */
    public String getDataContratacao() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataAdesao);
    }
    
    /**
     * Método responsável por vincular a data de contrataáão no formato texto a um objeto funcionario.
     * @param data 
     */
    public void setDataContratacao(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //Parsing the String
            this.dataAdesao = dateFormat.parse(data);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
