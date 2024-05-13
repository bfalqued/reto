
package Clases;

/**
 *
 * @author Borja
 */
public class Grupo {
    private int idgrupo;
    private String codgrupo;
    private Curso curso;
    private int alumnos;
    private boolean activo;

    public Grupo(int idgrupo, String codgrupo, Curso curso, int alumnos, boolean activo) {
        this.idgrupo = idgrupo;
        this.codgrupo = codgrupo;
        this.curso = curso;
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

    public Curso getcurso() {
        return curso;
    }

    public void setcurso(Curso curso) {
        this.curso = curso;
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
        return "Grupo{" + "idgrupo=" + idgrupo + ", codgrupo=" + codgrupo + ", curso=" + curso + ", alumnos=" + alumnos + ", activo=" + activo + '}';
    }

    
    
}
