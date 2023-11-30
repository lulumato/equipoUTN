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
import Entidades.Equipo1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Equipo1Data {

    private static final Connection CONN = ConexionaDB.getConnection();

    private Equipo1Data() {
    }

    public static void crearEquipo(Equipo1 equipo1) {
        String sql = "INSERT INTO `equipo1`( nombre, titulares, suplentes, directorTecnico,  estado, puntos, partidosJugados)"
                + "VALUES (?, ?, ?, ?, true, 0, 0)";
        PreparedStatement ps;
        try {
            ps = CONN.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, equipo1.getNombre());
            ps.setInt(2, equipo1.getTitulares());
            ps.setInt(3, equipo1.getSuplentes());
            ps.setString(4, equipo1.getDirectorTecnico());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            System.out.println("Equipo creado con éxito");
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la tabla equipo, error: " + e);
        }
    }

    public static void modificarPuntosPartidos(Equipo1 equipo1) {
        String sql = "UPDATE equipo1 SET puntos = ?, partidosJugados = ? WHERE nombre = ?";
        PreparedStatement ps;
        try {
            ps = CONN.prepareStatement(sql);

            ps.setInt(1, equipo1.getPartidosJugados());
            ps.setInt(2, equipo1.getPuntos());
            ps.setString(3, equipo1.getNombre());

            int resultado = ps.executeUpdate();
            System.out.println("Se modificó los datos exitosamente");
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la tabla equipo: " + e);
        }
    }

    public void activarEquipo(Equipo1 equipo1) {

        String sql = "UPDATE equipo1 SET estado = 1 WHERE nombre = ?";
        PreparedStatement ps;
        try {
            ps = CONN.prepareStatement(sql);
            ps.setString(1, equipo1.getNombre());

            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Se dió de alta el equipo correctamente");
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("No se pudo acceder a la tabla equipo: " + e);
        }
    }

    public static void desactivarEquipo(Equipo1 equipo1) {
        String sql = "UPDATE equipo1 SET estado= 0 WHERE nombre = ?";
        PreparedStatement ps;
        try {
            ps = CONN.prepareStatement(sql);
            ps.setString(1, equipo1.getNombre());

            int res = ps.executeUpdate();
            if (res == 1) {

                System.out.println("El equipo se eliminó correctamente");
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("No se puede acceder a la tabla equipo: " + e);
        }
    }

    public static List<Equipo1> ListarEquipoPorNombre(String nombre) {
        String sql = "SELECT * FROM equipo1 WHERE nombre = ? ORDER BY nombre ASC;";
        List<Equipo1> equipo1lista = new ArrayList<>();

        PreparedStatement ps;

        try {
            ps = CONN.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipo1 equipo1 = new Equipo1();
                equipo1.setNombre(rs.getString("nombre"));
                equipo1.setTitulares(rs.getInt("titulares"));
                equipo1.setSuplentes(rs.getInt("suplentes"));
                equipo1.setDirectorTecnico(rs.getString("directorTecnico"));
                equipo1.setEstado(rs.getBoolean("estado"));
                equipo1.setPuntos(rs.getInt("puntos"));
                equipo1.setPartidosJugados(rs.getInt("partidosJugados"));
                equipo1lista.add(equipo1);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar la conexion a la tabla equipo: " + e);
        }
        return equipo1lista;
    }
}
