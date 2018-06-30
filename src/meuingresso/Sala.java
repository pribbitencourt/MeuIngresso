package meuingresso;

/**
 *
 * @author priscillabittencourt
 */
public class Sala {
    
    private Integer id;
    private Integer numeroAssentos;
    private String numeroSala;
    private String tipoSala;
    
    public Sala(int numeroAssentos, String numeroSala, String tipoSala){
        this.numeroAssentos = numeroAssentos;
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }   

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", numeroAssentos=" + numeroAssentos + ", numeroSala=" + numeroSala + ", tipoSala=" + tipoSala + '}';
    }
    
}
