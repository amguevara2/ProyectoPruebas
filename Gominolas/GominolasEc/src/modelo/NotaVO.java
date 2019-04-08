
package modelo;

import java.sql.Date;
import java.util.Calendar;

public class NotaVO {
    private int numero;
    private String ci_cli;
    private String nombre_pro;
    private Date fecha_contrato;
    private Date fecha_evento;

    public NotaVO() {
        numero=0;
        ci_cli="";
        nombre_pro="";
        //Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.YEAR, year);
        //cal.set(Calendar.MONTH, month - 1); // <-- months start
                                            // at 0.
        //cal.set(Calendar.DAY_OF_MONTH, day);
        //fecha_contrato= new Date(cal.getTimeInMillis());
        //fecha_evento= new Date(cal.getTimeInMillis());
        fecha_contrato=null;
        fecha_evento= null;
        
    }

    public NotaVO(int numero, String ci_cli, String nombre_pro, Date fecha_contrato, Date fecha_evento) {
        this.numero = numero;
        this.ci_cli = ci_cli;
        this.nombre_pro = nombre_pro;
        this.fecha_contrato = fecha_contrato;
        this.fecha_evento = fecha_evento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCi_cli() {
        return ci_cli;
    }

    public void setCi_cli(String ci_cli) {
        this.ci_cli = ci_cli;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public Date getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }
    
    public void asignarFechaActual(){
        Calendar cal = Calendar.getInstance();
        fecha_contrato= new Date(cal.getTimeInMillis());
    }
    
}
