package com.senac.cadastroEvento.Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cadastro_evento";
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    public static Connection abrir() throws Exception {
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);

        return conn;


    }

}