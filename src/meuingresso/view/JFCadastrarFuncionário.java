package meuingresso.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import meuingresso.Funcionario;
import meuingresso.Sala;
import meuingressoDAO.FuncionarioDAOPG;
import meuingressoDAO.PessoaDAOPG;
import meuingressoDAO.SalaDAOPG;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author priscillabittencourt
 */
public class JFCadastrarFuncionário extends javax.swing.JFrame {

    /**
     * Creates new form JFCadastrarFuncionário
     */
    public JFCadastrarFuncionário() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTNomeFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTEmailFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTCPFFuncionario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTTelefoneFuncionario = new javax.swing.JTextField();
        JTDataNascimentoFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JBPesquisarFuncionario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTTurnoFuncionario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTSalarioFuncionario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTDataContratacaoFuncionario = new javax.swing.JTextField();
        JTFuncaoFuncionario = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jLabelNotificacao = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();

        jLabel11.setText("Salário");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(205, 208, 232));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro Funcionario");

        jLabel2.setText("Nome Completo");

        jLabel3.setText("E-mail");

        jLabel4.setText("CPF");

        jLabel6.setText("Telefone");

        jLabel7.setText("Data Nascimento");

        JBPesquisarFuncionario.setText("Pesquisar");
        JBPesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPesquisarFuncionarioActionPerformed(evt);
            }
        });

        jLabel8.setText("Turno");

        jLabel9.setText("Função");

        JTTurnoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTTurnoFuncionarioActionPerformed(evt);
            }
        });

        jLabel10.setText("Salário");

        JTSalarioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTSalarioFuncionarioActionPerformed(evt);
            }
        });

        jLabel12.setText("Data Contratação");

        JTDataContratacaoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTDataContratacaoFuncionarioActionPerformed(evt);
            }
        });

        JTFuncaoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFuncaoFuncionarioActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setToolTipText("");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(167, 167, 167))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(JTDataContratacaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel12)
                                                                .addComponent(JTTurnoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10))
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(JTFuncaoFuncionario)
                                                .addComponent(JTDataNascimentoFuncionario)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(52, 52, 52)
                                            .addComponent(jButtonCadastrar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonEditar)
                                            .addGap(12, 12, 12)
                                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JTTelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JTSalarioFuncionario)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotificacao)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(JTCPFFuncionario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JBPesquisarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(JTNomeFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNotificacao)
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTCPFFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBPesquisarFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTDataNascimentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTurnoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFuncaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTDataContratacaoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTSalarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonEditar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void JTDataContratacaoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTDataContratacaoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTDataContratacaoFuncionarioActionPerformed

    private void JTSalarioFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTSalarioFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTSalarioFuncionarioActionPerformed

    private void JTTurnoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTTurnoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTTurnoFuncionarioActionPerformed

    private void JTFuncaoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFuncaoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFuncaoFuncionarioActionPerformed

    private void JBPesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPesquisarFuncionarioActionPerformed
        FuncionarioDAOPG funcionarioDAO = new FuncionarioDAOPG();
        try {
            if(funcionarioDAO.retrieveOneByCPF(JTCPFFuncionario.getText()) == null){
                JTDataContratacaoFuncionario.setText("");
                JTDataNascimentoFuncionario.setText("");
                JTEmailFuncionario.setText("");
                JTFuncaoFuncionario.setText("");
                JTNomeFuncionario.setText("");
                JTSalarioFuncionario.setText("");
                JTTelefoneFuncionario.setText("");
                JTTurnoFuncionario.setText("");
                
                jLabelNotificacao.setText("! - Funcionário não localizado.");
                jButtonEditar.setVisible(false);
                jButtonExcluir.setVisible(false);
                jButtonCadastrar.setVisible(true);
            }else{
                Funcionario funcionario = funcionarioDAO.retrieveOneByCPF(JTCPFFuncionario.getText());
                JTCPFFuncionario.setText(funcionario.getCpf());
                JTDataContratacaoFuncionario.setText(funcionario.getDataContratacao());
                JTDataNascimentoFuncionario.setText(funcionario.getDataNascimento());
                JTEmailFuncionario.setText(funcionario.getEmail());
                JTFuncaoFuncionario.setText(funcionario.getFuncao());
                JTNomeFuncionario.setText(funcionario.getNome());
                JTSalarioFuncionario.setText(String.valueOf(funcionario.getSalario()));
                JTTelefoneFuncionario.setText(funcionario.getTelefone());
                JTTurnoFuncionario.setText(funcionario.getTurno());
                jLabelNotificacao.setText("OK - Funcionário localizado.");
                jButtonEditar.setVisible(true);
                jButtonExcluir.setVisible(true);
                jButtonCadastrar.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBPesquisarFuncionarioActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       FuncionarioDAOPG funcionarioDAO = new FuncionarioDAOPG();
       PessoaDAOPG pessoaDAO = new PessoaDAOPG();
        try {
            Funcionario funcionario = funcionarioDAO.retrieveOneByCPF(JTCPFFuncionario.getText());
            funcionario.setCpf(JTCPFFuncionario.getText());
            funcionario.setDataContratacao(JTDataContratacaoFuncionario.getText());
            funcionario.setDataNascimento(JTDataNascimentoFuncionario.getText());
            funcionario.setEmail(JTEmailFuncionario.getText());
            funcionario.setFuncao(JTFuncaoFuncionario.getText());
            funcionario.setNome(JTNomeFuncionario.getText());
            funcionario.setSalario(Float.valueOf(JTSalarioFuncionario.getText()));
            funcionario.setTelefone(JTTelefoneFuncionario.getText());
            funcionario.setTurno(JTTurnoFuncionario.getText());
            pessoaDAO.update(funcionario);
            funcionarioDAO.update(funcionario);
            jLabelNotificacao.setText("OK - Dados do funcionario atualizados com sucesso!");
            JTCPFFuncionario.setText("");
            JTDataContratacaoFuncionario.setText("");
            JTDataNascimentoFuncionario.setText("");
            JTEmailFuncionario.setText("");
            JTFuncaoFuncionario.setText("");
            JTNomeFuncionario.setText("");
            JTSalarioFuncionario.setText("");
            JTTelefoneFuncionario.setText("");
            JTTurnoFuncionario.setText("");
            jButtonCadastrar.setVisible(false);
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        PessoaDAOPG pessoaDAO = new PessoaDAOPG();
        FuncionarioDAOPG funcionarioDAO = new FuncionarioDAOPG();
        try {
            Funcionario funcionario = new Funcionario(JTTurnoFuncionario.getText()
                    , JTFuncaoFuncionario.getText()
                    , Float.valueOf(JTSalarioFuncionario.getText())
                    , JTNomeFuncionario.getText()
                    , JTCPFFuncionario.getText()
                    , JTEmailFuncionario.getText()
                    , JTTelefoneFuncionario.getText()
                    , JTDataNascimentoFuncionario.getText()
                    , JTDataContratacaoFuncionario.getText());
            System.out.println(funcionario);
            pessoaDAO.create(funcionario);
            int id = pessoaDAO.retrieveIdPessoaByCPF(JTCPFFuncionario.getText());
            funcionario.setId(id);
            funcionarioDAO.create(funcionario);
            jLabelNotificacao.setText("OK - Funcionário cadastrado com sucesso!");
            JTCPFFuncionario.setText("");
            JTDataContratacaoFuncionario.setText("");
            JTDataNascimentoFuncionario.setText("");
            JTEmailFuncionario.setText("");
            JTFuncaoFuncionario.setText("");
            JTNomeFuncionario.setText("");
            JTSalarioFuncionario.setText("");
            JTTelefoneFuncionario.setText("");
            JTTurnoFuncionario.setText("");
            jButtonCadastrar.setVisible(false);
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        FuncionarioDAOPG funcionarioDAO = new FuncionarioDAOPG();
        PessoaDAOPG pessoaDAO = new PessoaDAOPG();
        try {
            Funcionario funcionario = funcionarioDAO.retrieveOneByCPF(JTCPFFuncionario.getText());
            funcionarioDAO.delete(funcionario);
            pessoaDAO.delete(funcionario);
            jLabelNotificacao.setText("OK - Funcionário deletado com sucesso!");
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
            jButtonCadastrar.setVisible(false);
            JTCPFFuncionario.setText("");
            JTCPFFuncionario.setText("");
            JTDataContratacaoFuncionario.setText("");
            JTDataNascimentoFuncionario.setText("");
            JTEmailFuncionario.setText("");
            JTFuncaoFuncionario.setText("");
            JTNomeFuncionario.setText("");
            JTSalarioFuncionario.setText("");
            JTTelefoneFuncionario.setText("");
            JTTurnoFuncionario.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JFCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JFCadastrarFuncionário.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFuncionário.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFuncionário.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCadastrarFuncionário.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCadastrarFuncionário().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBPesquisarFuncionario;
    private javax.swing.JTextField JTCPFFuncionario;
    private javax.swing.JTextField JTDataContratacaoFuncionario;
    private javax.swing.JTextField JTDataNascimentoFuncionario;
    private javax.swing.JTextField JTEmailFuncionario;
    private javax.swing.JTextField JTFuncaoFuncionario;
    private javax.swing.JTextField JTNomeFuncionario;
    private javax.swing.JTextField JTSalarioFuncionario;
    private javax.swing.JTextField JTTelefoneFuncionario;
    private javax.swing.JTextField JTTurnoFuncionario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNotificacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
