/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.UTN.equipoUTN;

import com.UTN.equipoUTN.conexiones.ConexionaDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        var varb = ConexionaDB.getConnection();
        try {
            System.out.println("" + varb.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
