/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UTN.equipoUTN.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionaDB {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String BD = "equipoutn";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    private ConexionaDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL + BD, USUARIO, PASSWORD);
            } catch (ClassNotFoundException ex) {
                System.out.println("No se puedo encontrar el Driver " + ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
            }
        }
        return connection;
    }
}
