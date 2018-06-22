package meuingresso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author priscillabittencourt
 */
public class Sessao {
    
    private int id;
    private Date dataInicio= null;
    private Date dataFim= null;
    private String horario;
    
    public Sessao(int id, Date dataInicioString, Date dataFimString, String horario) throws ParseException{
        this.id= id;
        this.setDataInicio(dataInicioString);
        this.setDataFim(dataFimString);
        this.horario=horario;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) throws ParseException {
        
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) throws ParseException {
        this.dataFim = dataFim;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    } 
}
