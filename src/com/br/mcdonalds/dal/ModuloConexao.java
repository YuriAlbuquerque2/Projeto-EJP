
package com.br.mcdonalds.dal;

import java.sql.*;

public class ModuloConexao {
    
    public static Connection conector(){ // Criando método com nome de: conector
java.sql.Connection conexao = null; //variável com nome de: conexao
String driver = "com.mysql.jdbc.Driver"; //chamando o driver
String url="jdbc:mysql://localhost:3306/dbmcdonalds"; //Armazenando informações referente ao banco
String user="root";
String password ="Yuri2004#";
       try {
Class.forName(driver); //tratamento de conexão ao banco de dados
conexao = DriverManager.getConnection(url, user, password);
return conexao;
} catch (Exception e) {
return null;
}
}
    }

