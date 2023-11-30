/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Lógica del Negocio
 */
public abstract class EquipoTemplate {

    /**
     * Atributos
     */
    protected int puntos;
    protected int partidosJugados;

    /**
     * Constructores
     */
    public EquipoTemplate() {
    }

    public EquipoTemplate(int puntos, int partidosJugados) {
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    /**
     * Getter and Setter
     */
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * Metodos toString, HashCode y Equals
     */
    @Override
    public String toString() {
        return " ";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.puntos;
        hash = 67 * hash + this.partidosJugados;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EquipoTemplate other = (EquipoTemplate) obj;
        if (this.puntos != other.puntos) {
            return false;
        }
        return this.partidosJugados == other.partidosJugados;
    }

    /**
     * Metodos
     */
    public void jugarPartido() {
    }

    public void puntosTotales() {
    }

    public void cantidadDePartidosJugados() {
    }

    public void estadistica() {
    }
}
