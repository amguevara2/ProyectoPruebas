/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class ValidacionesTest {
    
    public ValidacionesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  @Test
    public void testvalidaCedulaAZUAY() {
        System.out.println("Validador cedula AZUAY 01 ");
        String cedula = "0100967652";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaBOLIVAR() {
        System.out.println("Validador cedula BOLIVAR 02 ");
        String cedula = "0200562791";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaCAÑAR() {
        System.out.println("Validador cedula CAñAR 03 ");
        String cedula = "0301506044";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaCARCHI() {
        System.out.println("Validador cedula CARCHI 04 ");
        String cedula = "0400698817";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaCOTOPAXI() {
        System.out.println("Validador cedula COTOPAXI 05 ");
        String cedula = "0503023517";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaCHIMBORAZO() {
        System.out.println("Validador cedula CHIMBORAZO 06");
        String cedula = "0601915127";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaEL_ORO() {
        System.out.println("Validador cedula EL ORO 07 ");
        String cedula = "0700772130";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaESMERALDAS() {
        System.out.println("Validador cedula ESMERALDAS 08");
        String cedula = "0802081364";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaGUAYAS() {
        System.out.println("Validador cedula GUAYAS 09 ");
        String cedula = "0917385288";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateIMBABURA() {
        System.out.println("Validador cedula IMBABURA 10 ");
        String cedula = "1001472651";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testValidateLOJA() {
        System.out.println("Validador cedula LOJA 11 ");
        String cedula = "1103216089";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaLOS_RIOS() {
        System.out.println("Validador cedula LOS RIOS 12 ");
        String cedula = "1202936223";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaMANABI() {
        System.out.println("Validador cedula MANABI 13 ");
        String cedula = "1303753618";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaMORONA_SANTIAGO() {
        System.out.println("Validador cedula MORONA SANTIAGO 14 ");
        String cedula = "1400313365";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaNAPO() {
        System.out.println("Validador cedula NAPO 15 ");
        String cedula = "1500762339";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaPASTAZA() {
        System.out.println("Validador cedula PASTAZA 16 ");
        String cedula = "1600226722";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaPICHINCHA() {
        System.out.println("Validador cedula PICHINCHA 17 ");
        String cedula = "1709784613";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaTUNGURAHUA() {
        System.out.println("Validador cedula TUNHURAHUA 18 ");
        String cedula = "1801877729";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaZAMORA_CHINCHIPE() {
        System.out.println("Validador cedula ZAMORA CHINCHIPE 19 ");
        String cedula = "1900205566";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaGALAPAGOS() {
        System.out.println("Validador cedula GALAPAGOS 20 ");
        String cedula = "2000065066";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaSUCUMBIOS() {
        System.out.println("Validador cedula SUCUMBIOS 21 ");
        String cedula = "2100611868";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaORELLANA() {
        System.out.println("Validador cedula ORELLANA 22 ");
        String cedula = "2200011589";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaSANTO_DOMINGO() {
        System.out.println("Validador cedula SANTO DOMINGO 23 ");
        String cedula = "2300191679";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }

    @Test
    public void testvalidaCedulaSANTA_ELENA() {
        System.out.println("Validador cedula SANTA ELENA 24");
        String cedula = "2400002503";
        Validaciones val = new Validaciones();
        boolean expResult = true;
        boolean result = val.validaCedula(cedula);
        assertEquals(expResult, result);

    }
    
    
    
     @Test
    public void testValidaCampoDeNombre()
  {
      System.out.println("Validador de Nombre");
      String nombre="Sandra";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.validarCampodeNombre(nombre);
      assertEquals(expResult, result);
      if(nombre=="")
      {
      fail("campo vacio");
      }
     
  }
     @Test
    public void testValidaCampoDeApellido()
  {
      System.out.println("Validador de apellido");
      String apellido="Perez";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.validarCampodeNombre(apellido);
      assertEquals(expResult, result);
      if(apellido=="")
      {
      fail("campo vacio");
      }
     
  }
    
        @Test
    public void validarNumeroTelefonico()
  {
        System.out.println("Valida Numero celular igual a 10 digitos");
       String numero="0995863028";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.ValidarCampoDeTelefono(numero);
      assertEquals(expResult, result);
      if(numero=="")
      {
      fail("campo vacio");
      }
    
    
  }
     @Test
    public void testValidaSiesUnNumero()
  {
      System.out.println("Valida si es un numero");
      String numero="233";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.validarSiNumero(numero);
      assertEquals(expResult, result);
      if(numero=="")
      {
      fail("campo vacio");
      }
  }
    
     @Test
    public void validarCampoDeDescripcion()
  {
        System.out.println("Valida campo de descripcion se mayor a 5 caracteres");
       String descrip="doss por uno";
      Validaciones val=new Validaciones();
      boolean expResult=false;
      boolean result=val.ValidarCampoDeDescrip(descrip);
      assertEquals(expResult, result);
      if(descrip=="")
      {
      fail("campo vacio");
      }
    
    
  }
    
      @Test
    public void validaUnaFecha()
  {
        System.out.println("Valida formato dia-mes-año ");
       String numero="20/11/2017";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.validarFecha(numero);
      assertEquals(expResult, result);
      if(numero=="")
      {
      fail("campo vacio");
      }
    
    
  }
    
      @Test
    public void validaCorreo()
  {
        System.out.println("Valida un correo valido ");
       String correo="sandra_castro@gmail.com";
      Validaciones val=new Validaciones();
      boolean expResult=true;
      boolean result=val.isEmail(correo);
      assertEquals(expResult, result);
      if(correo=="")
      {
      fail("campo vacio");
      }
    
    
  } 
    
    
 public static void rellenarArray (int lista[]){
        for(int i=0;i<lista.length;i++){
            lista[i]=numeroAleatorio();
        }
    }
   private static int numeroAleatorio (){
        return ((int)Math.floor(Math.random()*1000));
    }
   
   @Test
    public void tesOrdenarLista()
  {
        System.out.println("Validador lista ordenada");
        Validaciones val=new Validaciones();
       final int TAMANIO=10;
        int lista[]=new int [TAMANIO];
        rellenarArray(lista);
        String lista_String[]={"Alegria", "Mimo", "Globos", "Pastel", "Mago"};
          val.OrdenarLista(lista);   
   }
  
   
 @Test
    public void tesLimitarMaximo10Caracteres()
  {
        System.out.println("Validador maximo de 10 caracteres");
       Validaciones val=new Validaciones();
       JTextField text = new JTextField("123456789");
       val.limitarCaracteres(text, 10);   
  }
     
    
    
}
