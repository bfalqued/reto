
package Clases;

/**
 *
 * @author Borja
 */
public class Departamento {
    private int id_departamento;   
    private String nombre;
    private int jefe;
    private String codigo_departamento;
    

    public Departamento(int id_departamento, String nombre, int jefe, String codigo_departamento) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.jefe = jefe;
        this.codigo_departamento = codigo_departamento;
        
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJefe() {
        return jefe;
    }

    public void setJefe(int jefe) {
        this.jefe = jefe;
    }

    public String getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(String codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id_departamento=" + id_departamento + ", nombre=" + nombre + ", jefe=" + jefe + ", codigo_departamento=" + codigo_departamento + '}';
    }

   
    
}
