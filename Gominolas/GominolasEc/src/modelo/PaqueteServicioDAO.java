/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JhonnyC
 */
public class PaqueteServicioDAO {
    
    public void eliminarPaquete(String nombre) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM paquete WHERE nombre='" + nombre + "'");
          //  JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
          //  JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
    public void eliminarPaqueteServicio(String nombre,String nombrepac) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM paquete_servicio WHERE nombre='" + nombre + "'");
          //  JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
          //  JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
      public void AgregarNuevoPaquete(String nombre,String nombrepac ) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO paquete_servicio (nombre_ser,nombre_pac) VALUES (?,?)");
            orden.setString(1, nombre);
            orden.setString(2, nombrepac);
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso!");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }
      }
    
}
