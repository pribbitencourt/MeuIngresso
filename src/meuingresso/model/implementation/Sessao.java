package meuingresso.model.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author priscillabittencourt
 */
public class Sessao {
    
    private Long id;
    private String nomeSessao;
    private Date dataInicio= null;
    private Date dataFim= null;
    private String horario;
    

    public String getNome_sessao() {
        return nomeSessao;
    }

    public void setNomeSessao(String nome_sessao) {
        this.nomeSessao = nome_sessao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataInicio() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataInicio);
    }

    public void setDataInicio(String dataInicio) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataInicio = dateFormat.parse(dataInicio);
        } catch (ParseException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDataFim() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataFim);
    }

    public void setDataFim(String dataFim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataFim = dateFormat.parse(dataFim);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    } 
}
