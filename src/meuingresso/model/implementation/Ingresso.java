package meuingresso.model.implementation;

import meuingresso.model.abstractType.Produto;

/**
 *
 * @author priscillabittencourt
 */
public final class Ingresso extends Produto{
    private Filme filmeEscolhido;
    private Sala salaEscolhida;
    private Sessao sessaoEscolhida;
    
    public Ingresso(int id, String descricao, float valor, Filme filme, Sala sala, Sessao sessao) {
        super(id, descricao, valor);
        this.setFilmeEscolhido(filme);
        this.setSalaEscolhida(sala);
        this.setSessaoEscolhida(sessao);
    }
    
    public Sala getSalaEscolhida() {
        return salaEscolhida;
    }

    public void setSalaEscolhida(Sala salaEscolhida) {
        this.salaEscolhida = salaEscolhida;
    }

    public Sessao getSessaoEscolhida() {
        return sessaoEscolhida;
    }

    public void setSessaoEscolhida(Sessao sessaoEscolhida) {
        this.sessaoEscolhida = sessaoEscolhida;
    }
    
    public Filme getfilmeEscolhido() {
        return filmeEscolhido;
    }

    public void setFilmeEscolhido(Filme filme) {
        this.filmeEscolhido = filme;
    }
    
    
}
