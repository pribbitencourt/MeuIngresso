/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.Controller;

import meuingresso.DAO.implementation.SalaDAO;
import meuingresso.DAO.implementation.SessaoDAO;
import meuingresso.model.implementation.Sala;
import meuingresso.model.implementation.Sessao;
import meuingresso.view.JFCadastroSala;
import meuingresso.view.JFCadastroSessao;

/**
 *
 * @author priscillabittencourt
 */
public class SessaoController {
     private JFCadastroSessao telaCadastroSala;
    private SessaoDAO sessaoDAO = new SessaoDAO();

    public SessaoController(JFCadastroSessao frame) {
        telaCadastroSala = frame;
    }
    public void insert() throws Exception{
        if(validate()){
            Sessao sessao = createObject();
            sessaoDAO.insert(sessao);
        }
    }
    public Sessao createObject(){
        Sessao object = new Sessao();
        
        object.setNomeSessao(telaCadastroSala.getJTNomeSessao().getText());
        object.setDataInicio(telaCadastroSala.getJTDataInicio().getText());
        object.setDataFim(telaCadastroSala.getJTDataFim().getText());
        object.setHorario(telaCadastroSala.getJTHorario().getText());
        
        
        return object;
        
    }
    public boolean validate() throws Exception{
        if(telaCadastroSala.getJTNomeSessao().getText().isEmpty()){
            throw new Exception("Campo Nome da sessao não pode ser vazio.");
        }
        if(telaCadastroSala.getJTDataInicio().getText().isEmpty()){
            throw new Exception("Campo data de inicio não pode ser vazio.");
        }
        if(telaCadastroSala.getJTDataFim().getText().isEmpty()){
            throw new Exception("Campo data de fim não pode ser vazio.");
        }
        if(telaCadastroSala.getJTHorario().getText().isEmpty()){
            throw new Exception("Campo horario não pode ser vazio.");
        }
        return true;
    }
}
