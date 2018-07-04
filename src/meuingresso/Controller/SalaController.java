/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.Controller;

import meuingresso.DAO.implementation.SalaDAO;
import meuingresso.model.implementation.Sala;
import meuingresso.view.JFCadastroSala;

/**
 *
 * @author priscillabittencourt
 */
public class SalaController {
    private JFCadastroSala telaCadastroSala;
    private SalaDAO salaDAO = new SalaDAO();

    public SalaController(JFCadastroSala frame) {
        telaCadastroSala = frame;
    }
    public void insert() throws Exception{
        if(validate()){
            Sala sala = createObject();
            salaDAO.insert(sala);
        }
    }
    public Sala createObject(){
        Sala object = new Sala();
        
        object.setNumeroAssentos(telaCadastroSala.getJTNumAssentos().getText());
        object.setNumeroSala(telaCadastroSala.getJTNomeDaSala().getText());
        object.setTipoSala(telaCadastroSala.getJTTipoSala().getText());
        
        return object;
        
    }
    public boolean validate() throws Exception{
        if(telaCadastroSala.getJTNomeDaSala().getText().isEmpty()){
            throw new Exception("Campo Nome da Sala não pode ser vazio.");
        }
        if(telaCadastroSala.getJTNumAssentos().getText().isEmpty()){
            throw new Exception("Campo Numero de assentos não pode ser vazio.");
        }
        if(telaCadastroSala.getJTTipoSala().getText().isEmpty()){
            throw new Exception("Campo Tipo da sala não pode ser vazio.");
        }
        return true;
    }
    
}
