/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhond
 */
public class Conexion {
    String bd="gominolas";
    String login="root";
    String password="1234";
    String url="jdbc:mysql://localhost/"+bd;
    
    Connection con=null;
    public Conexion()
    {
        try{
        //Obtener el drive
        Class.forName("org.gjt.mm.mysql.Driver");
        //Obtener conexion
        con=DriverManager.getConnection(url, login, password);
        if(con !=null)
        {
            System.out.println("Conexion a base de datos ok");
        }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    public Connection getConexion()
    {
        return con;
    }
    public void desconectar()
    {
        con=null;
    }
}
