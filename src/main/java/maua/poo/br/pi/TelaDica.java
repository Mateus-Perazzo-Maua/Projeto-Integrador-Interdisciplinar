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
    private int dicasEliminarRestantes = 2;
    private boolean dicaTestarUsada = false;

    // CONSTRUTOR MODIFICADO
    public TelaDica() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pularQuestaoButton = new javax.swing.JButton();
        testarRespostaButton = new javax.swing.JButton();
        eliminarErradasButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pularQuestaoButton.setText("Pular Questão");
        pularQuestaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pularQuestaoButtonActionPerformed(evt);
            }
        });

        testarRespostaButton.setText("Testar Resposta");
        testarRespostaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testarRespostaButtonActionPerformed(evt);
            }
        });

        eliminarErradasButton.setText("Eliminar Alternativas (2)");
        eliminarErradasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarErradasButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pularQuestaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(testarRespostaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarErradasButton, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(voltarButton)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(pularQuestaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(testarRespostaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(eliminarErradasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(voltarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pularQuestaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pularQuestaoButtonActionPerformed
        // TODO add your handling code here:
     if (dicaPularUsada) {
            JOptionPane.showMessageDialog(this, "Você já usou a dica de pular questão!");
            return;
        }

        dicaPularUsada = true;

        // Chama método da TelaJogo
        telaJogo.pularQuestao();

        dispose(); // Fecha a tela de dica
    }//GEN-LAST:event_pularQuestaoButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void eliminarErradasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarErradasButtonActionPerformed
        // TODO add your handling code here:
        if (dicasEliminarRestantes <= 0) {
            JOptionPane.showMessageDialog(this, "Você já usou todas as dicas de eliminar alternativas!");
            return;
        }

        dicasEliminarRestantes--;

        // Chama método da TelaJogo
        telaJogo.eliminarAlternativasErradas();

        eliminarErradasButton.setText("Eliminar Alternativas (" + dicasEliminarRestantes + ")");
        if (dicasEliminarRestantes == 0) {
            eliminarErradasButton.setEnabled(false);
        }
    }//GEN-LAST:event_eliminarErradasButtonActionPerformed

    private void testarRespostaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testarRespostaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testarRespostaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarErradasButton;
    private javax.swing.JButton pularQuestaoButton;
    private javax.swing.JButton testarRespostaButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables

}
