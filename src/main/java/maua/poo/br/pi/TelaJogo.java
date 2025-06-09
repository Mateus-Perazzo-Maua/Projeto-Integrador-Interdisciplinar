/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package maua.poo.br.pi;

import java.util.Collections;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Set;
import java.util.HashSet;
import maua.poo.br.pi.QuestaoDAO;

/**
 *
 * @author 25.00404-5
 */
public class TelaJogo extends javax.swing.JFrame {
    
    private Map<String, JButton> botoesResposta;
    private boolean respostaProcessada = false;
    private List<Questao> listaQuestoes;
    private int questaoAtual = 0;
    private int pontuacao = 0;
    private int totalQuestoes = 0;
    private int indiceQuestaoExibida = 0;
    private int indiceAtual = 0;
    private javax.swing.JButton botaoCorreto;
    private Set<Integer> questoesRespondidas = new HashSet<>();
    private List<Questao> questoes;
    private String serieSelecionada;
    private final int acertosParaVencer = 12;
    private int ultimoCheckpoint = 0;
    private boolean[] questoesPontuadas;
    private boolean dicaPularUsada = false;
    private boolean dicaTestarUsada = false;
    private int dicasEliminarUsadas = 0;
    private final int maxDicasEliminar = 1;
    /**
     * Creates new form TelaJogo
     */
    
    public TelaJogo(String serieSelecionada) {
        initComponents();
        this.serieSelecionada = serieSelecionada;
        botoesResposta = new HashMap<>();
        botoesResposta.put("A", alternativaAButton);
        botoesResposta.put("B", alternativaBButton);
        botoesResposta.put("C", alternativaCButton);
        botoesResposta.put("D", alternativaDButton);
        iniciarJogo();
    }

    
    public boolean isDicaPularUsada() {
        return dicaPularUsada;
    }

    public boolean isDicaTestarUsada() {
        return dicaTestarUsada;
    }

    public boolean isDicasEliminarEsgotadas() {
        return dicasEliminarUsadas >= maxDicasEliminar;
    }

    // Métodos para marcar as dicas como usadas
    public void marcarDicaPularComoUsada() {
        dicaPularUsada = true;
    }

    public void marcarDicaTestarComoUsada() {
        dicaTestarUsada = true;
    }

    public void marcarDicaEliminarComoUsada() {
        dicasEliminarUsadas++;
    }

    
    private void iniciarJogo() {
        try {
        // Resetar dicas
        dicaPularUsada = false;
        dicaTestarUsada = false;
        dicasEliminarUsadas = 0;
        
        if (questaoAtual == 0) {
            ultimoCheckpoint = 0;
        }
        
        questaoAtual = 0;
        
        
        QuestaoDAO dao = new QuestaoDAO();
        listaQuestoes = new ArrayList<>();

        // Carrega questões fáceis
        List<Questao> faceis = dao.buscarQuestoesPorDificuldadeESerie("Fácil", serieSelecionada);
        Collections.shuffle(faceis);
        if (faceis.size() >= 4) {
            listaQuestoes.addAll(faceis.subList(0, 4));
        } else {
            JOptionPane.showMessageDialog(this, "Não há questões fáceis suficientes.");
            return;
        }

        // Carrega questões médias
        List<Questao> medias = dao.buscarQuestoesPorDificuldadeESerie("Média", serieSelecionada);
        Collections.shuffle(medias);
        if (medias.size() >= 4) {
            listaQuestoes.addAll(medias.subList(0, 4));
        } else {
            JOptionPane.showMessageDialog(this, "Não há questões médias suficientes.");
            return;
        }

        // Carrega questões difíceis
        List<Questao> dificeis = dao.buscarQuestoesPorDificuldadeESerie("Difícil", serieSelecionada);
        Collections.shuffle(dificeis);
        if (dificeis.size() >= 4) {
            listaQuestoes.addAll(dificeis.subList(0, 4));
        } else {
            JOptionPane.showMessageDialog(this, "Não há questões difíceis suficientes.");
            return;
        }

        totalQuestoes = listaQuestoes.size();
        questaoAtual = ultimoCheckpoint;
        questoesPontuadas = new boolean[totalQuestoes];
        mostrarProximaQuestao();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao iniciar o jogo: " + e.getMessage());
    }
}

    



    
    
    // Método para carregar uma questão específica
    private void carregarQuestao(int indice) {
    if (indice >= listaQuestoes.size()) {
            JOptionPane.showMessageDialog(null, "Você respondeu todas as questões!");
            return;
        }

        Questao q = listaQuestoes.get(indice);

        txtPergunta.setText(q.getEnunciado());

        alternativaAButton.setText(q.getAlternativaA());
        alternativaBButton.setText(q.getAlternativaB());
        alternativaCButton.setText(q.getAlternativaC());
        alternativaDButton.setText(q.getAlternativaD());
        
        resetarCoresBotoes();
        
        respostaProcessada = false;
        
        System.out.println("Questão carregada: " + (indice + 1));
    }
    



    // Método para verificar resposta selecionada
private void verificarResposta(String respostaSelecionada) {
    if (!respostaProcessada) {
            respostaProcessada = true;

            // Use o índice da questão atualmente exibida
            Questao questao = listaQuestoes.get(indiceQuestaoExibida);
            String respostaCorreta = questao.getRespostaCorreta();

            JButton botaoCorreto = botoesResposta.get(respostaCorreta);
            if (botaoCorreto != null) {
                botaoCorreto.setBackground(Color.GREEN);
            }

            if (respostaSelecionada.equals(respostaCorreta)) {
                if (!questoesPontuadas[indiceQuestaoExibida]) {
                    pontuacao++;
                    questoesPontuadas[indiceQuestaoExibida] = true;
                    System.out.println("Ponto adicionado! Pontuação atual: " + pontuacao);
                } else {
                    System.out.println("Questão já foi pontuada antes. Pontuação mantida: " + pontuacao);
                }     
                questaoAtual++; // Avança para a próxima questão
                
                if (questaoAtual == 4) {
                    ultimoCheckpoint = 4;
                    System.out.println("CHECKPOINT SALVO: Questão 5 alcançada!");
                } else if (questaoAtual == 8) {
                    ultimoCheckpoint = 8;
                    System.out.println("CHECKPOINT SALVO: Questão 9 alcançada!");
                }

                if (pontuacao >= acertosParaVencer) {
                    // Jogador chegou até o fim com todas certas!
                    JOptionPane.showMessageDialog(this, "Parabéns! Você terminou o jogo!\nSua pontuação: " + pontuacao,
                            "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);

                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja jogar novamente?",
                            "Jogar Novamente", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {
                        respostaProcessada = false;
                        ultimoCheckpoint = 0;
                        pontuacao = 0;
                        questaoAtual = 0;
                        indiceQuestaoExibida = 0;
                        iniciarJogo(); // Recomeça tudo
                    } else {
                        TelaAluno tela = new TelaAluno();
                        tela.setVisible(true);
                        this.dispose();
                    }
                } else {
                    // Espera 1 segundo antes de mostrar a próxima questão
                    javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
                        respostaProcessada = false;
                        mostrarProximaQuestao();
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            } else {
                // Errou a questão → volta ao início
                marcarBotaoIncorreto(respostaSelecionada);
                
                String mensagemCheckpoint;
                switch (ultimoCheckpoint) {
                    case 8:
                        mensagemCheckpoint = "Você voltará para a questão 9";
                        break;
                    case 4:
                        mensagemCheckpoint = "Você voltará para a questão 5";
                        break;
                    default:
                        mensagemCheckpoint = "Você deve começar novamente";
                        break;
                }
                
                JOptionPane.showMessageDialog(this, "Resposta incorreta!\n" + mensagemCheckpoint,
                        "Erro", JOptionPane.ERROR_MESSAGE);
                
                voltarParaCheckpoint();
            }
        }
}

private void voltarParaCheckpoint() {
    questaoAtual = ultimoCheckpoint;
    indiceQuestaoExibida = ultimoCheckpoint;
    
    dicaPularUsada = false;
    dicaTestarUsada = false;
    dicasEliminarUsadas = 0;
    
    respostaProcessada = true;
    
    System.out.println("Voltando para checkpoint: questão " + (ultimoCheckpoint + 1));
    System.out.println("Pontuação mantida: " + pontuacao);
    
    carregarQuestao(ultimoCheckpoint);
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
      
// Método para pular questão
public void pularQuestao() {
    if (questaoAtual < totalQuestoes - 1) {
        questaoAtual++;
        mostrarProximaQuestao();
        JOptionPane.showMessageDialog(this, "Questão pulada! Avançando para a próxima.");
    } else {
        JOptionPane.showMessageDialog(this, "Esta é a última questão, não é possível pular!");
    }
}

// Método para eliminar alternativas erradas
public void eliminarAlternativasErradas() {
    if (indiceQuestaoExibida < listaQuestoes.size()) {
        Questao questaoAtual = listaQuestoes.get(indiceQuestaoExibida);
        String respostaCorreta = questaoAtual.getRespostaCorreta();
        
        // Lista de alternativas possíveis
        String[] alternativas = {"A", "B", "C", "D"};
        int eliminadas = 0;
        
        // Elimina 2 alternativas incorretas
        for (String alt : alternativas) {
            if (!alt.equals(respostaCorreta) && eliminadas < 2) {
                JButton botao = botoesResposta.get(alt);
                if (botao != null && botao.isEnabled()) {
                    botao.setEnabled(false);
                    botao.setBackground(Color.LIGHT_GRAY);
                    eliminadas++;
                }
            }
        }
    }
}

// Método para testar resposta
public void testarResposta() {
    String[] opcoes = {"A", "B", "C", "D"};
    String escolha = (String) JOptionPane.showInputDialog(
        this,
        "Qual alternativa você quer testar?",
        "Testar Resposta",
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0]
    );
    
    if (escolha != null && indiceQuestaoExibida < listaQuestoes.size()) {
        Questao questaoAtual = listaQuestoes.get(indiceQuestaoExibida);
        String respostaCorreta = questaoAtual.getRespostaCorreta();
        
        if (escolha.equals(respostaCorreta)) {
            JOptionPane.showMessageDialog(this, "A alternativa " + escolha + " está CORRETA!", 
                "Resultado do Teste", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "A alternativa " + escolha + " está INCORRETA!", 
                "Resultado do Teste", JOptionPane.WARNING_MESSAGE);
        }
    }
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
        TelaDica tela = new TelaDica(this);
        tela.setVisible(true);

        
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
    switch (alternativa) {
        case "A":
            alternativaAButton.setBackground(Color.RED); // Vermelho
            break;
        case "B":
            alternativaBButton.setBackground(Color.RED);
            break;
        case "C":
            alternativaCButton.setBackground(Color.RED);
            break;
        case "D":
            alternativaDButton.setBackground(Color.RED);
            break;
    }
}
    
        private void mostrarProximaQuestao() {
            if (questaoAtual < totalQuestoes) {
            indiceQuestaoExibida = questaoAtual;
            carregarQuestao(questaoAtual);
        } else {
        // Fim do jogo – respondeu todas as questões
            JOptionPane.showMessageDialog(this, "Fim do jogo!\nSua pontuação: " + pontuacao,
                "Jogo Finalizado", JOptionPane.INFORMATION_MESSAGE);

            int resposta = JOptionPane.showConfirmDialog(this, "Deseja jogar novamente?",
                "Jogar Novamente", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            iniciarJogo();
        } else {
            TelaAluno tela = new TelaAluno();
            tela.setVisible(true);
            this.dispose();
        }
    }
}

}