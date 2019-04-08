/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.ServicioVO;
import vista.vistaServicios;
/**
 *
 * @author DELL
 */
public class ServiciosDAO {
    
    public void AgregarServicio(String nombre, float costo,String descripcion) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO Servicio(nombre,costo,descripcion) VALUES (?,?,?)");
            orden.setString(1, nombre);
            orden.setFloat(2, costo);
            orden.setString(3, descripcion);
            
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso!");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }

    }
    
     public void buscarServicio(String nombre) {
      
        Conexion conex = new Conexion();
        ServicioVO BusServi = new ServicioVO();
        boolean existe = false;
        try {
            PreparedStatement consulta = conex.getConexion().prepareStatement("SELECT *FROM Servicio where nombre=?");
            consulta.setString(1, nombre);//
            ResultSet res = consulta.executeQuery();//permite que se ejecuta la busqueda en consulta, result set es un arraylist de los objetos de busqueda.
            while (res.next()) {
                existe = true;
                BusServi.setNombre((res.getString("nombre")));
                BusServi.setCosto((Float.parseFloat(res.getString("costo"))));
                BusServi.setDescripcion(res.getString("descripcion"));
             
                existe = true;
             
            }
            res.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
           
        }
        if (existe) {
         JOptionPane.showMessageDialog(null,"Servicio -->"+BusServi.getNombre()+"  "+"Costo -->"+ BusServi.getCosto()+"  "+"Descripcion -->"+BusServi.getDescripcion());
              
        } else {
             JOptionPane.showMessageDialog(null,"No se encontro el servicio");
        }
    }

        public void modificarServicio(String nombre,float costo, String descripcion) {
        Conexion conex = new Conexion();
        try {
            String sentencia = "UPDATE Servicio SET costo=?, descripcion=? "
                    + "WHERE nombre=?";
            PreparedStatement estatuto = conex.getConexion().prepareStatement(sentencia);
            estatuto.setString(3, nombre);
            estatuto.setFloat(1, costo);
            estatuto.setString(2, descripcion);
           
            estatuto.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
    }
    
      
      public void eliminarServicio(String nombre) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM Servicio WHERE nombre='" + nombre + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
       public void AgregarServicioDeTablaALaBase(String nombre, float costo) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO Servicio(nombre,costo) VALUES (?,?)");
            orden.setString(1, nombre);
            orden.setFloat(2, costo);
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso!");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }

    }
      public void eliminarServicioDeTablaAlaBase(String nombre) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM Servicio WHERE nombre='" + nombre + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
}
