/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package maua.poo.br.pi;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaDica extends JFrame {

    private TelaJogo telaJogo;
    private int questaoAtual = 0;
    private List<Questao> listaQuestoes;
    private boolean dicaPularUsada = false;
    private boolean dicasEliminarRestantes = false;
    private boolean dicaTestarUsada = false;

    public TelaDica(TelaJogo telaJogo) {    
        initComponents();
        setLocationRelativeTo(null);
        this.telaJogo = telaJogo;
        atualizarEstadoBotoes();
    }
    
    
     private void atualizarEstadoBotoes() {
        if (telaJogo != null) {
            // verifica dica de pular
            if (telaJogo.isDicaPularUsada()) {
                pularQuestaoButton.setEnabled(false);
                pularQuestaoButton.setText("Pular Questão (USADO)");
            }
            
            // verifica dica de testar
            if (telaJogo.isDicaTestarUsada()) {
                testarRespostaButton.setEnabled(false);
                testarRespostaButton.setText("Testar Resposta (USADO)");
            }
            
            // verifica dica de eliminar
            if (telaJogo.isDicasEliminarEsgotadas()) {
                eliminarErradasButton.setEnabled(false);
                eliminarErradasButton.setText("Eliminar Alternativas (USADO)");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pularQuestaoButton = new javax.swing.JButton();
        testarRespostaButton = new javax.swing.JButton();
        eliminarErradasButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 231, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colégio Poliedro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(255, 149, 0))); // NOI18N

        pularQuestaoButton.setBackground(new java.awt.Color(69, 172, 236));
        pularQuestaoButton.setText("Pular Questão");
        pularQuestaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pularQuestaoButtonActionPerformed(evt);
            }
        });

        testarRespostaButton.setBackground(new java.awt.Color(69, 172, 236));
        testarRespostaButton.setText("Testar Resposta");
        testarRespostaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testarRespostaButtonActionPerformed(evt);
            }
        });

        eliminarErradasButton.setBackground(new java.awt.Color(69, 172, 236));
        eliminarErradasButton.setText("Eliminar Alternativas");
        eliminarErradasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarErradasButtonActionPerformed(evt);
            }
        });

        voltarButton.setBackground(new java.awt.Color(69, 172, 236));
        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 149, 0));
        jLabel1.setText("Dicas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pularQuestaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarErradasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(testarRespostaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel1)))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addComponent(pularQuestaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(testarRespostaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(eliminarErradasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pularQuestaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pularQuestaoButtonActionPerformed
        // TODO add your handling code here:
    if (telaJogo == null) {
            JOptionPane.showMessageDialog(this, "Esta funcionalidade só está disponível durante o jogo!");
            return;
        }
        
       
        if (telaJogo.isDicaPularUsada()) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica de pular questão!", 
                "Dica já utilizada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        telaJogo.marcarDicaPularComoUsada();
        
        // atualiza botão
        pularQuestaoButton.setEnabled(false);
        pularQuestaoButton.setText("Pular Questão (USADO)");

        telaJogo.pularQuestao();

        dispose();
    }//GEN-LAST:event_pularQuestaoButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void eliminarErradasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarErradasButtonActionPerformed
        // TODO add your handling code here:
       if (telaJogo == null) {
            JOptionPane.showMessageDialog(this, "Esta funcionalidade só está disponível durante o jogo!");
            return;
        }
        
        if (telaJogo.isDicasEliminarEsgotadas()) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica de eliminar alternativas!", 
                "Dica já utilizada", JOptionPane.WARNING_MESSAGE);
            return;
        }
      
        telaJogo.marcarDicaEliminarComoUsada();
        
        // atualiza botao
        eliminarErradasButton.setEnabled(false);
        eliminarErradasButton.setText("Eliminar Alternativas (USADO)");

        telaJogo.eliminarAlternativasErradas();

        JOptionPane.showMessageDialog(this, "Duas alternativas incorretas foram eliminadas!");
        
        dispose();

    }//GEN-LAST:event_eliminarErradasButtonActionPerformed

    private void testarRespostaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testarRespostaButtonActionPerformed
        // TODO add your handling code here:                                                    
        if (telaJogo == null) {
            JOptionPane.showMessageDialog(this, "Esta funcionalidade só está disponível durante o jogo!");
            return;
        }
        
        if (telaJogo.isDicaTestarUsada()) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica de testar resposta!", 
                "Dica já utilizada", JOptionPane.WARNING_MESSAGE);
            return;
        }
         
        telaJogo.marcarDicaTestarComoUsada();
        
        // atualiza botão
        testarRespostaButton.setEnabled(false);
        testarRespostaButton.setText("Testar Resposta (USADO)");
        
        telaJogo.testarResposta();
        
        dispose();
    }//GEN-LAST:event_testarRespostaButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarErradasButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pularQuestaoButton;
    private javax.swing.JButton testarRespostaButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables

}
