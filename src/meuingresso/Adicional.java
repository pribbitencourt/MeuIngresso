package meuingresso;

/**
 *
 * @author priscillabittencourt
 */
public class Adicional extends Produto {
    
    private String tipo;
    private String categoria;

    public Adicional(int id, String descricao, float valor) {
        super(id, descricao, valor);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    } 
}
