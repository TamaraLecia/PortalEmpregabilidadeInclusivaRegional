package com.pei.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConfiguracao {
    public static Connection conectar() {
        try {

            String url = "jdbc:mysql://localhost:3306/pei_database"; 
            String usuario = "root"; 
            String senha = ""; 

            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
