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
public class ServicioVO {
        String nombre;
           Float costo; 
          String descripcion;

    public ServicioVO(String nombre, Float costo, String descripcion) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
    }
 public ServicioVO() {
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
          
}
