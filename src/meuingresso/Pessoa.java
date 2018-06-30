package meuingresso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Pessoa {
 
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNascimento = null;

    public Pessoa(String nome, String cpf, String email, String telefone, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setDataNascimento(dataNascimento);
    }

    
    
    /**O metodo toString retorna um representação em formato de texto
     * do objeto Pessoa istanceado. Vale ressaltar que fizemos uma melhoria no
     * formato do retorno dos dados
     * 
     * @return String - Cadeia de caracteres contendo os atributos do Pessoa instanceado.
     */
    @Override
    public String toString() {
        return  "Id" + this.getId() + "\n"
                +"Nome" + this.getNome()+ "\n"
                +"CPF" + this.getCpf()+ "\n"
                + "Email" + this.getEmail()+ "\n" 
                + "Telefone" + this.getTelefone() + "\n"
                + "Data Nascimento" + this.getDataNascimento()+ "\n";
    }

    /**
     * Método responsável por retornar a data de nascimento de um objeto pessoa no formato texto.
     * @return String
     */
    public String getDataNascimento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dataNascimento);
    }
    
    /**
     * Método responsável por vincular a data de nascimento no formato texto a um objeto pessoa.
     * @param data 
     */
    public void setDataNascimento(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataNascimento = dateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Método responsável por retornar o identificador único vinculado a um objeto pessoa 
    * no formato inteiro
    * @return int
    */
    public int getId() {
        return id;
    }

    /**
     * Método responsável por vincular um identificador único no formato inteiro a um objeto pessoa.
     * @param id 
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Método responsável por retornar o atributo nome vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método responsável por vincular um nome a um objeto pessoa, no formato texto.
     * @param nome 
     */
    public void setNome(String aNome) {
        nome = aNome;
    }

    /**
     * Método responsável por retornar o atributo cpf vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método responsável por vincular um cpf a um objeto pessoa, no formato texto.
     * @param cpf 
     */
    public void setCpf(String aCpf) {
        cpf = aCpf;
    }

    /**
     * Método responsável por retornar o atributo email vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método responsável por vincular um email a um objeto pessoa, no formato texto.
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método responsável por retornar o atributo telefone vinculado a um objeto pessoa, no formato texto.
     * @return String
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método responsável por vincular um telefone a um objeto pessoa, no formato texto.
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
