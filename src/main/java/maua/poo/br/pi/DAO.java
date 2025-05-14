/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maua.poo.br.pi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 25.00357-5
 */
public class DAO {
    public String autenticar(Usuario usuario) throws Exception {
    String sql = "SELECT tipo FROM tb_usuario WHERE nome = ? AND senha = ?";
    try (Connection conn = ConexaoBD.obterConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("tipo"); // retorna "aluno" ou "professor"
            }
        }
    }
    return null; // não autenticado
    }
   public boolean adicionarUsuario(Usuario usuario) throws Exception {
    String sql = "INSERT INTO tb_usuario (nome, senha, tipo) VALUES (?, ?, ?)";

    try (Connection conn = ConexaoBD.obterConexao()) {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.setString(3, usuario.getTipo());

        int linhasAfetadas = ps.executeUpdate();
        return linhasAfetadas > 0;
    }
    }
   public boolean removerUsuario(String nome) throws Exception {
    String sql = "DELETE FROM tb_usuario WHERE nome = ?";

    try (Connection conn = ConexaoBD.obterConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nome);
        int linhasAfetadas = ps.executeUpdate();
        return linhasAfetadas > 0;
    }
    }

   public boolean adicionarQuestao(String materia, String serie, String dificuldade, String enunciado, String a, String b, String c, String d, String correta) throws Exception {
    String sql = "INSERT INTO questoes (materia, serie, dificuldade, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoBD.obterConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, materia);
        stmt.setString(2, serie);
        stmt.setString(3, dificuldade);
        stmt.setString(4, enunciado);
        stmt.setString(5, a);
        stmt.setString(6, b);
        stmt.setString(7, c);
        stmt.setString(8, d);
        stmt.setString(9, correta);

        return stmt.executeUpdate() > 0;
        

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
   }
}
   


