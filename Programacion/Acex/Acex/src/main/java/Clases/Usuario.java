
package Clases;

/**
 *
 * @author DAW122
 */
public class Usuario {
    
    private String correo;
    private String contrasena;
    private Perfil perfil;

    public Usuario(String correo, String contrasena, Perfil perfil) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.perfil = perfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    
}
