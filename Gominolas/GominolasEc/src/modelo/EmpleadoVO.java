
package modelo;

public class EmpleadoVO {
    private String ci;
    private String contrasena;
    private String cargo;

    public EmpleadoVO(String ci, String contrasena, String cargo) {
        this.ci = ci;
        this.contrasena = contrasena;
        this.cargo = cargo;
    }

    public EmpleadoVO() {
        ci="";
        contrasena="";
        cargo="";
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
