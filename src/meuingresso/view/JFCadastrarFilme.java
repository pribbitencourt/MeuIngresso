/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import meuingresso.Filme;
import meuingresso.Sala;
import meuingresso.Sessao;
import meuingressoDAO.FilmeDAOPG;
import meuingressoDAO.SalaDAOPG;
import meuingressoDAO.SessaoDAOPG;

/**
 *
 * @author priscillabittencourt
 */
public class JFCadastrarFilme extends javax.swing.JFrame {

    /**
     * Creates new form JFCadastrarCliente
     */
    public JFCadastrarFilme() {
        initComponents();
        jButtonCadastrar.setVisible(false);
        jButtonEditar.setVisible(false);
        jButtonExcluir.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        JBExcluirFuncionario = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDuracao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jTextFieldTitulo = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldProdutora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldClassificacao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAtores = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaIdioma = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaSinopse = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaLegendas = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaDiretores = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabelNotificacao = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();

        jLabel8.setText("CPF");

        JBExcluirFuncionario.setText("Excluir");

        jLabel11.setText("Produtora");

        jLabel12.setText("Classificação");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro Filme");

        jLabel2.setText("Genero");

        jLabel4.setText("Título");

        jLabel5.setText("Duração");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel9.setText("Produtora");

        jLabel10.setText("Classificação");

        jLabel14.setText("Idioma");

        jTextAreaAtores.setColumns(20);
        jTextAreaAtores.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAtores);

        jTextAreaIdioma.setColumns(20);
        jTextAreaIdioma.setRows(5);
        jScrollPane2.setViewportView(jTextAreaIdioma);

        jLabel15.setText("Atores");

        jLabel16.setText("Sinopse");

        jTextAreaSinopse.setColumns(20);
        jTextAreaSinopse.setRows(5);
        jScrollPane3.setViewportView(jTextAreaSinopse);

        jLabel17.setText("Legendas");

        jTextAreaLegendas.setColumns(20);
        jTextAreaLegendas.setRows(5);
        jScrollPane4.setViewportView(jTextAreaLegendas);

        jTextAreaDiretores.setColumns(20);
        jTextAreaDiretores.setRows(5);
        jScrollPane5.setViewportView(jTextAreaDiretores);

        jLabel19.setText("Diretores");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNotificacao)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jTextFieldTitulo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPesquisar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jLabel16)
                                .addComponent(jTextFieldProdutora, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel15)
                                .addComponent(jTextFieldClassificacao)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))
                            .addGap(262, 262, 262))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextFieldDuracao))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabelNotificacao)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProdutora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonEditar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        FilmeDAOPG filmeDAO = new FilmeDAOPG();
        try {
            Filme filme = new Filme(jTextFieldTitulo.getText()
                    , jTextFieldGenero.getText()
                    , jTextFieldDuracao.getText()
                    , jTextFieldProdutora.getText()
                    , jTextFieldClassificacao.getText()
                    , jTextAreaDiretores.getText()
                    , jTextAreaAtores.getText()
                    , jTextAreaSinopse.getText()
                    , jTextAreaLegendas.getText()
                    , jTextAreaIdioma.getText());
           
            filmeDAO.create(filme);
            jLabelNotificacao.setText("OK - Filme cadastrado com sucesso!");
            jTextFieldTitulo.setText("");
            jTextFieldGenero.setText("");
            jTextFieldDuracao.setText("");
            jTextFieldProdutora.setText("");
            jTextFieldClassificacao.setText("");
            jTextAreaDiretores.setText("");
            jTextAreaAtores.setText("");
            jTextAreaSinopse.setText("");
            jTextAreaLegendas.setText("");
            jTextAreaIdioma.setText("");
            jButtonCadastrar.setVisible(false);
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        FilmeDAOPG filmeDAO = new FilmeDAOPG();
        try {
            Filme filme = filmeDAO.retrieveOneByNome(jTextFieldTitulo.getText());
            filmeDAO.delete(filme);
            jLabelNotificacao.setText("OK - Filme deletado com sucesso!");
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
            jButtonCadastrar.setVisible(false);
            jTextAreaAtores.setText("");
            jTextAreaDiretores.setText("");
            jTextAreaIdioma.setText("");
            jTextAreaLegendas.setText("");
            jTextAreaSinopse.setText("");
            jTextFieldClassificacao.setText("");
            jTextFieldDuracao.setText("");
            jTextFieldGenero.setText("");
            jTextFieldProdutora.setText("");
            jTextFieldTitulo.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        FilmeDAOPG filmeDAO = new FilmeDAOPG();
        try {
            if(filmeDAO.retrieveOneByNome(jTextFieldTitulo.getText()) == null){
                jTextAreaAtores.setText("");
                jTextAreaDiretores.setText("");
                jTextAreaIdioma.setText("");
                jTextAreaLegendas.setText("");
                jTextAreaSinopse.setText("");
                jTextFieldClassificacao.setText("");
                jTextFieldDuracao.setText("");
                jTextFieldGenero.setText("");
                jTextFieldProdutora.setText("");
                jTextFieldTitulo.setText("");
                jLabelNotificacao.setText("! - Filme não localizado.");
                jButtonCadastrar.setVisible(true);
                jButtonEditar.setVisible(false);
                jButtonExcluir.setVisible(false);
            }else{
                Filme filme = filmeDAO.retrieveOneByNome(jTextFieldTitulo.getText());
                jTextAreaAtores.setText(filme.getAtoresPrincipais());
                jTextAreaDiretores.setText(filme.getDiretor());
                jTextAreaIdioma.setText(filme.getIdioma());
                jTextAreaLegendas.setText(filme.getLegenda());
                jTextAreaSinopse.setText(filme.getSinopse());
                jTextFieldClassificacao.setText(filme.getClassificacao());
                jTextFieldDuracao.setText(filme.getDuracao());
                jTextFieldGenero.setText(filme.getGenero());
                jTextFieldProdutora.setText(filme.getProdutora());
                jTextFieldTitulo.setText(filme.getTitulo());
                jLabelNotificacao.setText("OK - Filme localizado.");
                jButtonCadastrar.setVisible(false);
                jButtonEditar.setVisible(true);
                jButtonExcluir.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        FilmeDAOPG filmeDAO = new FilmeDAOPG();
        try {
            Filme filme = filmeDAO.retrieveOneByNome(jTextFieldTitulo.getText());
            filme.setAtoresPrincipais(jTextAreaAtores.getText());
            filme.setClassificacao(jTextFieldClassificacao.getText());
            filme.setDiretor(jTextAreaDiretores.getText());
            filme.setDuracao(jTextFieldDuracao.getText());
            filme.setGenero(jTextFieldGenero.getText());
            filme.setIdioma(jTextAreaIdioma.getText());
            filme.setLegenda(jTextAreaLegendas.getText());
            filme.setProdutora(jTextFieldProdutora.getText());
            filme.setSinopse(jTextAreaSinopse.getText());
            filme.setTitulo(jTextFieldTitulo.getText());
            filmeDAO.update(filme);
            jLabelNotificacao.setText("OK - Dados da sala atualizados com sucesso!");
            jTextAreaAtores.setText("");
            jTextAreaDiretores.setText("");
            jTextAreaIdioma.setText("");
            jTextAreaLegendas.setText("");
            jTextAreaSinopse.setText("");
            jTextFieldClassificacao.setText("");
            jTextFieldDuracao.setText("");
            jTextFieldGenero.setText("");
            jTextFieldProdutora.setText("");
            jTextFieldTitulo.setText("");
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
            jButtonCadastrar.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCadastrarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBExcluirFuncionario;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNotificacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaAtores;
    private javax.swing.JTextArea jTextAreaDiretores;
    private javax.swing.JTextArea jTextAreaIdioma;
    private javax.swing.JTextArea jTextAreaLegendas;
    private javax.swing.JTextArea jTextAreaSinopse;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldClassificacao;
    private javax.swing.JTextField jTextFieldDuracao;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldProdutora;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}