
package Clases;

/**
 *
 * @author Borja
 */
public class Profesor {
    private int id_profesor;
    private String nombre;
    private String apellido;
    private int departamento;
    private String correo;
    private String contrasena;
    private Perfil perfil;
    private String dni;
    private boolean activo;

    public Profesor(int id_profesor, String nombre, String apellido, int departamento, String correo, String contrasena, Perfil perfil, String dni, boolean activo) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.perfil = perfil;
        this.dni = dni;
        this.activo = activo;
    }

 

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public String Perfil(){
        return String.valueOf(this.getPerfil());
    }

    @Override
    public String toString() {
        return "Profesor{" + "id_profesor=" + id_profesor + ", nombre=" + nombre + ", apellido=" + apellido + ", departamento=" + departamento + ", correo=" + correo + ", contrasena=" + contrasena + ", perfil=" + perfil + ", dni=" + dni + ", activo=" + activo + '}';
    }
    
}
