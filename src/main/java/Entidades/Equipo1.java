/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Equipo1 extends EquipoTemplate {

    Scanner sc = new Scanner(System.in);

    private String nombre;
    private int titulares;
    private int suplentes;
    private String directorTecnico;
    private boolean estado;

    public Equipo1() {
    }

    public Equipo1(String nombre, int titulares, int suplentes, String directorTecnico, boolean estado, int puntos, int partidosJugados) {
        super(puntos, partidosJugados);
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.estado = estado;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }

    @Override
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public int getPartidosJugados() {
        return partidosJugados;
    }

    @Override
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    @Override
    public String toString() {
        return "El Club Atlético " + nombre + ", " + "cuenta con: " + titulares + " titulares, " + suplentes + " suplentes"
                + ", " + "dirigidos por: " + directorTecnico + " jugó un total de: " + partidosJugados + " partidos, "
                + "y obtuvo un total de: " + puntos + " puntos.";
    }

    @Override
    public void jugarPartido() {
        boolean a = true;
        do {
            System.out.println(" --  --  --   --  --  --   --  --  --   --  --  --  ");
            System.out.println("¿Se jugó el partido? SI/NO");
            String respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            if (null == respuesta) {
                System.out.println("Seleccionó una opción inválida. Intente nuevamente");
                a = false;
            } else {
                switch (respuesta) {
                    case "SI":
                        System.out.println("Seleccione el numero de opción correspondiente al resultado");
                        System.out.print(" 1 - Ganó  ");
                        System.out.print(" 2 - Empató  ");
                        System.out.print(" 3 - Perdió  ");
                        System.out.println(" ");
                        int opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                puntos += 3;
                                partidosJugados++;
                                System.out.println("Grandioso! Suma 3");
                                break;
                            case 2:
                                puntos += 1;
                                partidosJugados++;
                                System.out.println("Maso menos che... Suma 1");
                                break;
                            case 3:
                                puntos += 0;
                                partidosJugados++;
                                System.out.println("Mal ahi!! No suma nada");
                                break;
                            default:
                                throw new AssertionError();
                        }
                        break;
                    case "NO":
                        System.out.println("No se jugó esta fecha, por lo que no se suma ningún partido");
                        break;
                    default:
                        System.out.println("Seleccionó una opción inválida. Intente nuevamente");
                        a = false;
                        break;
                }
            }
        } while (a == false);
    }

    @Override
    public void puntosTotales() {
        System.out.println(" --  --  --   --  --  --   --  --  --   --  --  --  ");
        System.out.println(nombre + " tiene un total de " + puntos + " puntos.");
    }

    @Override
    public void cantidadDePartidosJugados() {
        System.out.println(" --  --  --   --  --  --   --  --  --   --  --  --  ");
        System.out.println(nombre + "  tiene un total de " + partidosJugados + " partidos jugados.");
    }

    @Override
    public void estadistica() {
        System.out.println(" --  --  --   --  --  --   --  --  --   --  --  --  ");
        System.out.println("El Club Atlético " + nombre + ", " + "cuenta con: " + titulares + " titulares, " + suplentes + " suplentes"
                + ", " + "dirigidos por: " + directorTecnico + " jugó un total de: " + partidosJugados + " partidos, "
                + "y obtuvo un total de: " + puntos + " puntos.");
    }

}
