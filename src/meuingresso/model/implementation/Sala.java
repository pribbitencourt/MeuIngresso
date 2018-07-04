package meuingresso.model.implementation;

/**
 *
 * @author priscillabittencourt
 */
public class Sala {
    
    private Long id;
    private String numeroAssentos;
    private String numeroSala;
    private String tipoSala;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(String numeroAssentos) {
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
