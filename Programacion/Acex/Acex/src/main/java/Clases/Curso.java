
package Clases;

/**
 *
 * @author Borja
 */
public class Curso {
    private int idcurso;
    private String codcurso;
    private String descurso;
    private Etapa etapa;
    private boolean ACTIVO;

    public Curso(int idcurso, String codcurso, String descurso, Etapa etapa, boolean ACTIVO) {
        this.idcurso = idcurso;
        this.codcurso = codcurso;
        this.descurso = descurso;
        this.etapa = etapa;
        this.ACTIVO = ACTIVO;
    }

    

    public int getId_curso() {
        return idcurso;
    }

    public void setId_curso(int id_curso) {
        this.idcurso = id_curso;
    }

    public String getCodigo() {
        return codcurso;
    }

    public void setCodigo(String codigo) {
        this.codcurso = codigo;
    }

    public String getDescripcion() {
        return descurso;
    }

    public void setDescripcion(String descripcion) {
        this.descurso = descripcion;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public boolean isActivo() {
        return ACTIVO;
    }

    public void setActivo(boolean activo) {
        this.ACTIVO = activo;
    }
    

    @Override
    public String toString() {
        return "Curso{" + "id_curso=" + idcurso + ", codigo=" + codcurso + ", descripcion=" + descurso + ", etapa=" + etapa + ", activo=" + ACTIVO + '}';
    }
    
}
