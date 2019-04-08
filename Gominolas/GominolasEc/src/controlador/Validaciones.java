/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class Validaciones {
    public boolean validaCedula (String cedula) {
        boolean CorrectCedula;
        try {
            if (cedula.length() == 10) {
                int ThirdDigit = Integer.parseInt(cedula.substring(2, 3));
                if (ThirdDigit < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int Checker = Integer.parseInt(cedula.substring(9, 10));
                    int sum = 0;
                    int Digit = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        Digit = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        sum += ((Digit % 10) + (Digit / 10));
                    }
                    if ((sum % 10 == 0) && (sum % 10 == Checker)) {
                        CorrectCedula = true;
                    } else if ((10 - (sum % 10)) == Checker) {
                        CorrectCedula = true;
                    } else {
                        CorrectCedula = false;
                    }
                } else {
                    CorrectCedula = false;
                }
            } else {
                CorrectCedula = false;
            }
        } catch (NumberFormatException nfe) {
            CorrectCedula = false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
            CorrectCedula = false;
        }
        if (!CorrectCedula) {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
            CorrectCedula = false;
        }
        return CorrectCedula;
    }
        public  boolean validarCampodeNombre(String str) { 
        boolean respuesta = false; 
        if ((str).matches("([a-z]|[A-Z]|\\s)+")) { 
        respuesta = true; 
        } 
        return respuesta; 
    } 
    
    public  boolean validarCampodeApellido(String str) { 
        boolean respuesta = false; 
        if ((str).matches("([a-z]|[A-Z]|\\s)+")) { 
        respuesta = true; 
        } 
        return respuesta; 
    } 

   public boolean validarSiNumero(String str){ 
        boolean respuesta = false; 
    if ((str).matches("([0-9]|\\-)+")) { 
    respuesta = true; 
    }    
        return respuesta; 
} 

public void OrdenarLista (int lista[]){
        int cuentaintercambios=0;
        //Usamos un bucle anidado, saldra cuando este ordenado el array
        for (boolean ordenado=false;!ordenado;){
            for (int i=0;i<lista.length-1;i++){
                if (lista[i]>lista[i+1]){
                    //Intercambiamos valores
                    int variableauxiliar=lista[i];
                    lista[i]=lista[i+1];
                    lista[i+1]=variableauxiliar;
                    //indicamos que hay un cambio
                    cuentaintercambios++;
                }
            }
            //Si no hay intercambios, es que esta ordenado.
            if (cuentaintercambios==0){
                ordenado=true;
            }
            //Inicializamos la variable de nuevo para que empiece a contar de nuevo
            cuentaintercambios=0;
        }
    }

public boolean ValidarCampoDeTelefono(String exp)
{
    boolean a=true;
        if(exp.length() == 10)
        {
            a=true;
        }  else {
                  a=false;
           }
        return a;

}
public boolean ValidarCampoenBlanco(String exp)
{
    boolean a=true;
        if(exp.length() < 1 || exp.isEmpty()){
           a=true;  
        }  else {
               a=false;    
           }
        return a;

}

 public void limitarCaracteres( JTextField campo, int cantidad)
    {
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                int tam=campo.getText().length();
                if(tam>=cantidad){
                    e.consume();
                }
            }
        });
    }
  
public boolean ValidarCampoDeDireccion(String exp)
{
    boolean a=true;
        if(exp.length() > 10 ){
                a=true;
        }  else {
                  a=false;
           }
        return a;

}

public  boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean ValidarCampoDeTelefo(String exp)
{
    boolean a=true;
        if(exp.length() == 10)
        {
            a=true;
        }  else {
                  a=false;
           }
        return a;

}
public boolean ValidarCampoenBla(String exp)
{
    boolean a=true;
        if(exp.length() < 1 || exp.isEmpty()){
           a=true;  
        }  else {
               a=false;    
           }
        return a;

}
public boolean ValidarCampoDeDescrip(String exp)
{
    boolean a=true;
        if(exp.length() <5 ){
                a=true;
        }  else {
                  a=false;
           }
        return a;

}

    private boolean esNombreValido(String nombre) {
    	if(nombre.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))
    		return false;
    	else
    		return true;
    }
    
    public boolean isEmail(String correo) {
                Pattern pat = null;
                Matcher mat = null; 
                pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
                mat = pat.matcher(correo);
                if (mat.find()) {
                System.out.println("[" + mat.group() + "]");
                return true;
                }else{
                return false;
                } 
                }
 
}
