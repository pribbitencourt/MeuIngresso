package meuingresso.model.abstractType;

/**
 *
 * @author priscillabittencourt
 */
public abstract class Produto {
    
    private int id;
    private String descricao;
    private float valor;

    public Produto(int id, String descricao, float valor){
        this.setId(id);
        this.setDescricao(descricao);
        this.setValor(valor);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
