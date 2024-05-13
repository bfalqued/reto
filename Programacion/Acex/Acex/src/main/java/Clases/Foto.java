
package Clases;

/**
 *
 * @author Borja
 */
public class Foto {
    private int id_foto;
    private String url;
    private String descripcion;
    private Actividad_Programada actividadProgramada;
    public Foto(int id_foto, String url, String descripcion) {
        this.id_foto = id_foto;
        this.url = url;
        this.descripcion = descripcion;
    }

    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad_Programada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(Actividad_Programada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }
    
    

    @Override
    public String toString() {
        return "Foto{" + "id_foto=" + id_foto + ", url=" + url + ", descripcion=" + descripcion + '}';
    }
    
}
