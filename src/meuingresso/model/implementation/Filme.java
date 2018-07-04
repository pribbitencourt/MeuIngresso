package meuingresso.model.implementation;

/**
 *
 * @author priscillabittencourt
 */
public class Filme {
    
    private Long id;
    private String titulo;
    private String genero;
    private String duracao;
    private String produtora;
    private String classificacao;
    private String diretor;
    private String atoresPrincipais;
    private String sinopse;
    private String legenda;
    private String idioma;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public void setAtoresPrincipais(String atoresPrincipais) {
        this.atoresPrincipais = atoresPrincipais;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    /**O metodo toString retorna um representação em formato de texto
     * do objeto Pessoa istanceado. Vale ressaltar que fizemos uma melhoria no
     * formato do retorno dos dados
     * 
     * @return String - Cadeia de caracteres contendo os atributos do Pessoa instanceado.
     */
    @Override
    public String toString() {
        return  "\n Id: " + this.getId() + "\n"
                +"Titulo: " + this.getTitulo()+ "\n"
                +"Sinopse: " + this.getSinopse()+ "\n"
                + "Produtora: " + this.getProdutora()+ "\n" 
                + "Legenda: " + this.getLegenda()+ "\n"
                + "Idioma: " + this.getIdioma()+ "\n"
                + "Genero: " + this.getGenero()+ "\n"
                + "Duracao: " + this.getDuracao()+ "\n"
                + "Diretor: " + this.getDiretor()+ "\n"
                + "Classificação: " + this.getClassificacao()+ "\n"
                + "Atores Principais: " + this.getAtoresPrincipais()+ "\n";
    }
    
}
