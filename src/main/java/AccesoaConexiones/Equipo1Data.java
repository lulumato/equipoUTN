/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoaConexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Entidades.Equipo1;

/**
 *
 * @author Lenovo
 */
public class Equipo1Data {

    private static final Connection CONN = ConexionaDB.getConnection();

    private Equipo1Data() {
    }

    public static void crearEquipo(Equipo1 equipo1) {
        String sql = "INSERT INTO `equipo1`( nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados) "
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = CONN.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, equipo1.getNombre());
            ps.setInt(2, titulares.getCantCalorias());
            ps.executeUpdate();
            ResultSet resultado = ps.getGeneratedKeys();
            if (resultado.next()) {

                comida.setIdComida(resultado.getInt(1));
                JOptionPane.showMessageDialog(null, "La comida fué creada con éxito");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla comida " + ex.getMessage());
        }

    }
}
