/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private String URL = "jdbc:mysql://127.0.0.1:3306/cursojakartaee?useSSL=false&serverTimezone=UTC";
    private String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    private String DRIVERMYSQL5 = "com.mysql.jdbc.Driver";
    private String USER = "root";
    private String PASSWORD = "root";
    private Connection conn;

    public Connection ligarBB() {

        try {
            Class.forName(DRIVERMYSQL8);
            return conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro de conexao com a base de dados"+ex.getLocalizedMessage());
            return null;
        }

    }

}
