/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package maua.poo.br.pi;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import maua.poo.br.pi.DAO.QuestaoDAO;

/**
 *
 * @author 25.00404-5
 */
public class TelaJogo extends javax.swing.JFrame {

    private List<Questao> listaQuestoes;
    private int questaoAtual = 0;
    private int pontuacao = 0;
    private int totalQuestoes = 0;
    /**
     * Creates new form TelaJogo
     */
    public TelaJogo() {
        initComponents();
        iniciarJogo();
 }

     private void iniciarJogo() {
    try {
        // Carregar todas as questões do banco
        listaQuestoes = QuestaoDAO.buscarTodasQuestoes();
        totalQuestoes = listaQuestoes.size();

        if (totalQuestoes > 0) {
            // Exibir a primeira questão
            carregarQuestao(0);
        } else {
            JOptionPane.showMessageDialog(this, "Não há questões cadastradas no banco de dados!",
                                          "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao iniciar o jogo: " + e.getMessage(),
                                      "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    // Método para carregar uma questão específica
    private void carregarQuestao(int indice) {
        if (indice < listaQuestoes.size()) {
            Questao q = listaQuestoes.get(indice);
            
            // Exibir enunciado e alternativas
            txtPergunta.setText(q.getEnunciado());
            alternativaAButton.setText(q.getAlternativaA());
            alternativaBButton.setText(q.getAlternativaB());
            alternativaCButton.setText(q.getAlternativaC());
            alternativaDButton.setText(q.getAlternativaD());
            
            // Resetar cores dos botões
            resetarCoresBotoes();
            
            // Atualizar questão atual
            questaoAtual = indice;
        }
    }
    
    // Método para verificar resposta selecionada
    private void verificarResposta(String alternativa) {
        Questao questaoAtiva = listaQuestoes.get(questaoAtual);
        
        // Verificar se a resposta está correta
        if (alternativa.equals(questaoAtiva.getRespostaCorreta())) {
            // Resposta correta
            pontuacao += 100;
            JOptionPane.showMessageDialog(this, "Resposta Correta! Você ganhou 100 pontos.\nPontuação atual: " + pontuacao,
                    "Acertou!", JOptionPane.INFORMATION_MESSAGE);
            
            // Destacar resposta correta em verde
            marcarBotaoCorreto(alternativa);
        } else {
            // Resposta incorreta
            JOptionPane.showMessageDialog(this, "Resposta Incorreta! A resposta correta era: " + questaoAtiva.getRespostaCorreta(),
                    "Errou!", JOptionPane.ERROR_MESSAGE);
            
            // Destacar resposta correta e incorreta
            marcarBotaoIncorreto(alternativa);
            marcarBotaoCorreto((String) questaoAtiva.getRespostaCorreta());
        }
        
        // Verificar se é a última questão
        if (questaoAtual == totalQuestoes - 1) {
            // Fim do jogo
            JOptionPane.showMessageDialog(this, "Fim do jogo! Sua pontuação final: " + pontuacao,
                    "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);
            
            // Perguntar se deseja jogar novamente
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja jogar novamente?", 
                    "Jogar Novamente", JOptionPane.YES_NO_OPTION);
            
            if (resposta == JOptionPane.YES_OPTION) {
                // Reiniciar jogo
                pontuacao = 0;
                questaoAtual = 0;
                carregarQuestao(0);
            } else {
                TelaAluno tela = new TelaAluno();
                tela.setVisible(true);
                this.dispose();
            }
        } else {
            // Passar para próxima questão após um tempo
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000); // Aguardar 2 segundos
                    carregarQuestao(questaoAtual + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
    
     // Métodos para marcar os botões com cores
    private void resetarCoresBotoes() {
        alternativaAButton.setBackground(null);
        alternativaBButton.setBackground(null);
        alternativaCButton.setBackground(null);
        alternativaDButton.setBackground(null);
        
        alternativaAButton.setEnabled(true);
        alternativaBButton.setEnabled(true);
        alternativaCButton.setEnabled(true);
        alternativaDButton.setEnabled(true);
    }
    
    private void marcarBotaoCorreto(String alternativa) {
        switch (alternativa) {
            case "A":
                alternativaAButton.setBackground(new Color(0, 200, 0)); // Verde
                break;
            case "B":
                alternativaBButton.setBackground(new Color(0, 200, 0));
                break;
            case "C":
                alternativaCButton.setBackground(new Color(0, 200, 0));
                break;
            case "D":
                alternativaDButton.setBackground(new Color(0, 200, 0));
                break;
        }
        
        // Desabilitar botões após resposta
        alternativaAButton.setEnabled(false);
        alternativaBButton.setEnabled(false);
        alternativaCButton.setEnabled(false);
        alternativaDButton.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        enunciadoTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtpergunta = new javax.swing.JTextArea();
        alternativaAButton = new javax.swing.JButton();
        alternativaBButton = new javax.swing.JButton();
        alternativaCButton = new javax.swing.JButton();
        alternativaDButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        dicasButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPergunta = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("A");

        enunciadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enunciadoTextFieldActionPerformed(evt);
            }
        });

        txtpergunta.setColumns(20);
        txtpergunta.setLineWrap(true);
        txtpergunta.setRows(5);
        txtpergunta.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtpergunta);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alternativaAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaAButtonActionPerformed(evt);
            }
        });

        alternativaBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaBButtonActionPerformed(evt);
            }
        });

        alternativaCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaCButtonActionPerformed(evt);
            }
        });

        alternativaDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaDButtonActionPerformed(evt);
            }
        });

        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        dicasButton.setText("Dicas");
        dicasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dicasButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("B:");

        jLabel4.setText("D:");

        jLabel5.setText("A:");

        jLabel6.setText("C:");

        txtPergunta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPergunta.setEnabled(false);
        txtPergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerguntaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sairButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(dicasButton))
                    .addComponent(alternativaCButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alternativaDButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alternativaBButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alternativaAButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternativaDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dicasButton)
                    .addComponent(sairButton))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enunciadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enunciadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enunciadoTextFieldActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        // TODO add your handling code here:
        TelaAluno tela = new TelaAluno();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void dicasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dicasButtonActionPerformed
        // TODO add your handling code here:
        TelaDica tela = new TelaDica();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dicasButtonActionPerformed

    private void alternativaDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaDButtonActionPerformed
        // TODO add your handling code here:
        verificarResposta("D");
    }//GEN-LAST:event_alternativaDButtonActionPerformed

    private void alternativaCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaCButtonActionPerformed
        // TODO add your handling code here:
         verificarResposta("C");
    }//GEN-LAST:event_alternativaCButtonActionPerformed

    private void alternativaBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaBButtonActionPerformed
        // TODO add your handling code here:
        verificarResposta("B");
    }//GEN-LAST:event_alternativaBButtonActionPerformed

    private void alternativaAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaAButtonActionPerformed
        // TODO add your handling code here:
        verificarResposta("A");
    }//GEN-LAST:event_alternativaAButtonActionPerformed

    private void txtPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerguntaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPerguntaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alternativaAButton;
    private javax.swing.JButton alternativaBButton;
    private javax.swing.JButton alternativaCButton;
    private javax.swing.JButton alternativaDButton;
    private javax.swing.JButton dicasButton;
    private javax.swing.JTextField enunciadoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton sairButton;
    private javax.swing.JTextField txtPergunta;
    private javax.swing.JTextArea txtpergunta;
    // End of variables declaration//GEN-END:variables

    private void marcarBotaoIncorreto(String alternativa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}