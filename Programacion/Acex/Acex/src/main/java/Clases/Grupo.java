
package Clases;

/**
 *
 * @author Borja
 */
public class Grupo {
    private int idgrupo;
    private String codgrupo;
    private int idcurso;
    private int alumnos;
    private boolean activo;

    public Grupo(int idgrupo, String codgrupo, int idcurso, int alumnos, boolean activo) {
        this.idgrupo = idgrupo;
        this.codgrupo = codgrupo;
        this.idcurso = idcurso;
        this.alumnos = alumnos;
        this.activo = activo;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(String codgrupo) {
        this.codgrupo = codgrupo;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(int alumnos) {
        this.alumnos = alumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "idgrupo=" + idgrupo + ", codgrupo=" + codgrupo + ", idcurso=" + idcurso + ", alumnos=" + alumnos + ", activo=" + activo + '}';
    }

    
    
}
