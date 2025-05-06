/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maua.poo.br.pi;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author 25.00357-5
 */
public class ConexaoBD {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "projeto_integrador";
    private static String usuario = "root";
    private static String senha = "imtdb";

    public static Connection obterConexao () throws Exception{
        String url = String.format(
            "jdbc:mysql://%s:%s/%s",
            host,
            porta,
            db
 );
 return DriverManager.getConnection(url, usuario, senha);
 }

    
}
