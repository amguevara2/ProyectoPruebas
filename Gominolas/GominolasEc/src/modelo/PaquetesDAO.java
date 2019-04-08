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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.vistaPaquetes;

/**
 *
 * @author DELL
 */
public class PaquetesDAO {
    
    
      public void AgregarNuevoPaquete(String nombre, float costo) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO paquete(nombre,costo) VALUES (?,?)");
            orden.setString(1, nombre);
            orden.setFloat(2, costo);
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso!");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }
      }
       public void eliminarPaquete(String nombre) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM paquete WHERE nombre='" + nombre + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
    public ResultSet consulta(String sql){
        ResultSet res=null;
         Conexion conex = new Conexion();
        try {
            PreparedStatement prepare=conex.getConexion().prepareStatement(sql);
            res=prepare.executeQuery();
        } catch (SQLException ex) {
          
        }
      
        return res;
    
    }
    public void modificarPaqueteConServicios(String nombre,float costo) {
        Conexion conex = new Conexion();
        try {
            String sentencia = "UPDATE paquete SET costo=?"
                    + "WHERE nombre=?";
            PreparedStatement estatuto = conex.getConexion().prepareStatement(sentencia);
            estatuto.setString(2, nombre);
            estatuto.setFloat(1, costo);
         
           
            estatuto.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
    }
    
     public void eliminarServicio(String nombre) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM servicio_paquete WHERE nombre_ser='" + nombre + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
  
      public void AgregarServicioEnPquete(String nombre, String nombrePaquete) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO servicio_paquete(nombre_ser, nombre_pac) VALUES (?,?)");
            orden.setString(1, nombre);
            orden.setString(2, nombrePaquete);
          
            
            orden.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede registrar");
        }

    }
    
    public DefaultComboBoxModel ObtenerNombres()
    {
        DefaultComboBoxModel listanom=new DefaultComboBoxModel();
        listanom.addElement("Seleccione el Paquete");
        ResultSet res=this.consulta("Select *From Paquete");
        try {
           while(res.next())
       {
         listanom.addElement(res.getString("nombre"));
       
       }
        } catch (SQLException ex) {
           
        }
      
        return listanom;
    
    }
     public DefaultComboBoxModel ObtenerServicios()
    {
        DefaultComboBoxModel listanom=new DefaultComboBoxModel();
        listanom.addElement("Seleccione el Servicio");
        ResultSet res=this.consulta("Select *From Servicio");
        try {
           while(res.next())
       {
         listanom.addElement(res.getString("nombre"));
       
       }
        } catch (SQLException ex) {
           
        }
      
        return listanom;
    
    }
     
      public void buscarNombreCombo(String nombre) {
      
        Conexion conex = new Conexion();
        PaqueteVO BusPaque = new PaqueteVO();
        boolean existe = false;
        try {
            PreparedStatement consulta = conex.getConexion().prepareStatement("SELECT *FROM Paquete where nombre=?");
            consulta.setString(1, nombre);//
            ResultSet res = consulta.executeQuery();//permite que se ejecuta la busqueda en consulta, result set es un arraylist de los objetos de busqueda.
            while (res.next()) {
                existe = true;
                BusPaque.setNombre((res.getString("nombre")));
                BusPaque.setCosto((Float.parseFloat(res.getString("costo"))));
               
             existe = true;
             
            }
            res.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
           
        }
        if (existe) {
         JOptionPane.showMessageDialog(null,"Paquete -->"+BusPaque.getNombre()+"  "+"Costo -->"+ BusPaque.getCosto());
        }
      }
      
      public float datos(String nombre, float costo)
      {
      
          return costo;
      }
        public void buscarServicioCombo(String nombre) {
      
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
                // persona.setId(res.getInt(1));
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
        
        
         public void modificarPaquete_serviciosYprecio(String nombre,float costo) {
        Conexion conex = new Conexion();
        try {
            String sentencia = "UPDATE paquete SET costo=?"
                    + "WHERE nombre=?";
            PreparedStatement estatuto = conex.getConexion().prepareStatement(sentencia);
            estatuto.setString(2, nombre);
            estatuto.setFloat(1, costo); 
            estatuto.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
    }
}

      

