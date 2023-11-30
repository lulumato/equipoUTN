/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import AccesoaConexiones.*;
import Entidades.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        var varb = ConexionaDB.getConnection();
        try {
            System.out.println("" + varb.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Equipo1 boca = new Equipo1("Boca Juniors", 11, 6, "Guardiola", true, 0, 0);
        boolean x = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("MENU DEL GRAN TORNEO LUCIA DE PRIMERA DIVISION UTN");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("1- Crear equipo");
            System.out.println("");
            System.out.println("2 - Jugar Partido");
            System.out.println("");
            System.out.println("3 - Puntos Totales");
            System.out.println("");
            System.out.println("4 - Cantidad de partidos jugados");
            System.out.println("");
            System.out.println("5 - Estadistica del equipo");
            System.out.println("");
            System.out.println("6 - Modificar puntos y/o partidos jugados");
            System.out.println("");
            System.out.println("7 - Eliminar equipo");
            System.out.println("");
            System.out.println("8- Salir");
            System.out.println("");
            System.out.println("");
            String opc = sc.next();

            switch (opc) {
                case "1":
                    Equipo1Data.crearEquipo(boca);
                    break;
                case "2":
                    boca.jugarPartido();
                    break;
                case "3":
                    boca.puntosTotales();
                    break;
                case "4":
                    boca.cantidadDePartidosJugados();
                    break;
                case "5":
                    boca.estadistica();
                    break;
                case "6":
                    Equipo1Data.modificarPuntosPartidos(boca);
                    break;
                case "7":
                    Equipo1Data.desactivarEquipo(boca);
                    break;
                case "8":
                    System.out.println("Adios!!");
                    x = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    throw new AssertionError();
            }
        } while (x == true);

    }

}
