/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Susana Rosa susana.rosa@murciaeduca.es
 */
public class Poblacion {
    private int idPoblacion;
    private String nombrePoblacion;

    public Poblacion() {
    }

    public Poblacion(int idPoblacion, String nombrePoblacion) {
        this.idPoblacion = idPoblacion;
        this.nombrePoblacion = nombrePoblacion;
    }

    public int getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(int idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public String getNombrePoblacion() {
        return nombrePoblacion;
    }

    public void setNombrePoblacion(String nombrePoblacion) {
        this.nombrePoblacion = nombrePoblacion;
    }

    @Override
    public String toString() {
        return "Poblacion{" + "idPoblacion=" + idPoblacion + ", nombrePoblacion=" + nombrePoblacion + '}';
    }
    
    
}
