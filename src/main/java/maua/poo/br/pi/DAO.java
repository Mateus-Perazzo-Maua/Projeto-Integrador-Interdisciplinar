/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maua.poo.br.pi;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
   
    /**
     *
     * @param materia
     * @param serie
     * @param dificuldade
     * @return
     * @throws java.lang.Exception
     */
    public List<Questao> buscarQuestoesPorFiltro(String materia, String serie, String dificuldade) throws Exception {
    List<Questao> lista = new ArrayList<>();

    String sql = "SELECT * FROM questoes WHERE LOWER(materia)=? AND LOWER(serie)=? AND LOWER(dificuldade)=?";
    
    try (Connection conn = ConexaoBD.obterConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, materia.toLowerCase().trim());
        stmt.setString(2, serie.toLowerCase().trim());
        stmt.setString(3, dificuldade.toLowerCase().trim());
        System.out.println(sql);
        System.out.println(materia.toLowerCase().trim());
        System.out.println(serie.toLowerCase().trim());
        System.out.println(dificuldade.toLowerCase().trim());
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Questao q = new Questao();
            q.setId(rs.getInt("id"));
            q.setEnunciado(rs.getString("enunciado"));
            q.setCorreta(rs.getString("correta")); // não "materia"!
            lista.add(q);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return lista;
}


    public boolean removerQuestaoPorId(int id) throws Exception {
    String sql = "DELETE FROM questoes WHERE id=?";
    try (Connection conn = ConexaoBD.obterConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }    

}
   


