/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import AccesoaConexiones.*;
import Entidades.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Mavenproject1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var varb = ConexionaDB.getConnection();
        try {
            System.out.println("" + varb.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Equipo1 boca = new Equipo1("Boca Juniors", 11, 6, "Guardiola", true, 0, 0);
        boolean x = true;

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
            System.out.println("8 - Dar de alta equipo eliminado");
            System.out.println("");
            System.out.println("9 - Listar equipos");
            System.out.println("");
            System.out.println("10- Salir");
            System.out.println("");
            System.out.println("");
            String opc = sc.next();

            switch (opc) {
                case "1":
                    Crear();
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
                    modificar();
                    break;
                case "7":
                    eliminar();
                    break;
                case "8":
                    darDeAltaUnEquipoEliminado();
                    break;
                case "9":
                    listar();
                    break;
                case "10":
                    System.out.println("Adios!!");
                    x = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    throw new AssertionError();
            }
        } while (x == true);
    }

    public static void Crear() {
        Equipo1 equipo1 = new Equipo1();
        System.out.println("Escriba los datos a completar");
        System.out.println("Nombre equipo: ");
        equipo1.setNombre(sc.next());
        System.out.println("Cantidad de titulares: ");
        equipo1.setTitulares(sc.nextInt());
        System.out.println("Cantidad de suplentes: ");
        equipo1.setSuplentes(sc.nextInt());
        System.out.println("Nombre DT: ");
        equipo1.setDirectorTecnico(sc.next());
        equipo1.setEstado(true);
        equipo1.setPuntos(0);
        equipo1.setPartidosJugados(0);
        Equipo1Data.crearEquipo(equipo1);

    }

    private static void modificar() {
        System.out.println("Ingrese el nombre del equipo a modificar: ");
        String nombre = sc.next();
        Equipo1 equipo1 = Equipo1Data.buscarEquipoPorNombre(nombre);
        System.out.println("Ingrese cantidad de puntos: ");
        equipo1.setPuntos(sc.nextInt());
        System.out.println("Ingrese cantidad de partidos: ");
        equipo1.setPartidosJugados(sc.nextInt());
        Equipo1Data.modificarPuntosPartidos(equipo1);

    }

    public static void eliminar() {
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre = sc.next();
        Equipo1 equipo1 = Equipo1Data.buscarEquipoPorNombre(nombre);
        Equipo1Data.desactivarEquipo(equipo1);
    }

    public static void darDeAltaUnEquipoEliminado() {
        System.out.println("Ingrese el nombre del equipo: ");
        String nombre = sc.next();
        Equipo1 equipo1 = Equipo1Data.buscarEquipoPorNombre(nombre);
        Equipo1Data.activarEquipo(equipo1);
    }

    public static void listar() {
        List<Equipo1> equipoList = Equipo1Data.ListarEquipos();
        for (Equipo1 equipo1 : equipoList) {
            System.out.println(equipo1);
        }
    }
}
