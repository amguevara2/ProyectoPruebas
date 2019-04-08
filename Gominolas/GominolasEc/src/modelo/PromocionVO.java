
package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class PromocionVO {
    private String nombre;
    private float descuento;
    private Date fecha_inicio;
    private Date fecha_fin;

    public PromocionVO() {
        this.nombre = "";
        this.descuento = 0;
        this.fecha_inicio = null;
        this.fecha_fin = null;
    }

    public PromocionVO(String nombre, float descuento, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
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
    public DefaultComboBoxModel ObtenerPromociones()
    {
        DefaultComboBoxModel listanom=new DefaultComboBoxModel();
        listanom.addElement("Ninguno");
        ResultSet res=this.consulta("Select *From promocion");
        try {
           while(res.next())
       {
         listanom.addElement(res.getString("nombre"));
       
       }
        } catch (SQLException ex) {
           
        }
      
        return listanom;
    
    }
    public void ObtenerPromocion(String nombre)
    {
        ResultSet res=this.consulta("Select *From promocion where nombre='"+nombre+"'");
        try {
           while(res.next())
       {
           this.nombre = res.getString("nombre");
            this.descuento = res.getFloat("descuento");
            this.fecha_inicio = res.getDate("fecha_inicio");
            this.fecha_fin = res.getDate("fecha_fin");
       }
        } catch (SQLException ex) {
           
        }
    }
    
}
