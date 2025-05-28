/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maua.poo.br.pi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 25.00357-5
 */
public class QuestaoDAO {
    private static Connection conexao = null;
    
    // Método para buscar a primeira questão (para teste inicial)
    public static Questao buscarPrimeiraQuestao() throws Exception {
        Questao questao = null;
        
        try {
            conexao = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM questoes LIMIT 1";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questao = new Questao();
                questao.setId(rs.getInt("id"));
                questao.setEnunciado(rs.getString("enunciado"));
                questao.setAlternativaA(rs.getString("alternativaA"));
                questao.setAlternativaB(rs.getString("alternativaB"));
                questao.setAlternativaC(rs.getString("alternativaC"));
                questao.setAlternativaD(rs.getString("alternativaD"));
                questao.setCorreta(rs.getString("correta"));
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar questão: " + e.getMessage(), 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return questao;
    }
    
    // Método para buscar todas as questões
    public static List<Questao> buscarTodasQuestoes() throws Exception {
        List<Questao> questoes = new ArrayList<>();
        
        try {
            conexao = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM questoes";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Questao questao = new Questao();
                questao.setId(rs.getInt("id"));
                questao.setEnunciado(rs.getString("enunciado"));
                questao.setAlternativaA(rs.getString("alternativaA"));
                questao.setAlternativaB(rs.getString("alternativaB"));
                questao.setAlternativaC(rs.getString("alternativaC"));
                questao.setAlternativaD(rs.getString("alternativaD"));
                questao.setCorreta(rs.getString("correta"));
                
                questoes.add(questao);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar questões: " + e.getMessage(), 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return questoes;
    }
    
    // Método para buscar questão por ID
    public static Questao buscarQuestaoPorId(int id) throws Exception {
        Questao questao = null;
        
        try {
            conexao = ConexaoBD.obterConexao();
            String sql = "SELECT * FROM questoes WHERE id = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                questao = new Questao();
                questao.setId(rs.getInt("id"));
                questao.setEnunciado(rs.getString("enunciado"));
                questao.setAlternativaA(rs.getString("alternativaA"));
                questao.setAlternativaB(rs.getString("alternativaB"));
                questao.setAlternativaC(rs.getString("alternativaC"));
                questao.setAlternativaD(rs.getString("alternativaD"));
                questao.setCorreta(rs.getString("correta"));
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar questão: " + e.getMessage(), 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return questao;
    }
    

    public List<Questao> buscarQuestoesPorDificuldadeESerie(String dificuldade, String serie) throws Exception {
        List<Questao> listaQuestoes = new ArrayList<>();
        String sql = "SELECT * FROM questoes WHERE dificuldade = ? AND serie = ?";

        try (Connection conn = ConexaoBD.obterConexao()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dificuldade);
            stmt.setString(2, serie);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Questao q = new Questao();
                q.setId(rs.getInt("id"));
                q.setEnunciado(rs.getString("enunciado"));
                q.setAlternativaA(rs.getString("alternativaA"));
                q.setAlternativaB(rs.getString("alternativaB"));
                q.setAlternativaC(rs.getString("alternativaC"));
                q.setAlternativaD(rs.getString("alternativaD"));
                q.setRespostaCorreta(rs.getString("correta"));
                q.setSerie(rs.getString("serie"));
                q.setDificuldade(rs.getString("dificuldade"));
                listaQuestoes.add(q);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaQuestoes;
    }
}