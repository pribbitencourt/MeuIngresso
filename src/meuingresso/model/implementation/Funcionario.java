package meuingresso.model.implementation;

import meuingresso.model.abstractType.Pessoa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author priscillabittencourt
 */

/**A classe funcionario possibilita instancear funcionarios e extende sua funcionalidade
 * a partir da super-classe pessoa. Possui atributos, e métodos diversos para acessar
 * esses atributos sempre utilizando-se dos principios de POO como por exemplo
 * encapsulamento
 * 
 * @see pessoa
 */
public class Funcionario extends Pessoa{
    
    private String turno;
    private String funcao;
    private String salario;
    private Date dataContratacao = null;


    @Override
    public String toString() {
        return  "Turno" + this.getTurno()+ "\n"
                +"Função" + this.getFuncao()+ "\n"
                +"Salario" + this.getSalario()+ "\n"
                + "Data Contratação" + this.getDataContratacao()+ "\n" ;
    }
    
    /**
     * Método responsável por retornar a data de contratação de um objeto funcionario no formato texto.
     * @return String
     */
    public String getDataContratacao() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataContratacao);
    }
    
    /**
     * Método responsável por vincular a data de contrataáão no formato texto a um objeto funcionario.
     * @param data 
     */
    public void setDataContratacao(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            //Parsing the String
            this.dataContratacao = dateFormat.parse(data);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Método responsável por retornar o atributo turno vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Método responsável por vincular um turno a um objeto pessoa, no formato texto.
     * @param turno 
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Método responsável por retornar o atributo funcao vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * Método responsável por vincular um turno a um objeto funcao, no formato texto.
     * @param funcao 
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * Método responsável por retornar o atributo salario vinculado a um objeto pessoa, no formato texto.
     * @return float
     */
    public String getSalario() {
        return salario;
    }

    /**
     * Método responsável por vincular um salario a um objeto funcao, no formato texto.
     * @param salario 
     */
    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
    
}
