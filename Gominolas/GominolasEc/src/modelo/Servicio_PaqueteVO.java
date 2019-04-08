/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DELL
 */
public class Servicio_PaqueteVO {
    String nombre;
    float costo;

    public Servicio_PaqueteVO(String nombre, float costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public Servicio_PaqueteVO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
}
