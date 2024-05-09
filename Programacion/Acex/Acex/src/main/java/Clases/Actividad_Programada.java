
package Clases;

import java.time.LocalDateTime;

/**
 *
 * @author Borja
 */
public class Actividad_Programada extends Actividad_Solicitada{    
    private String empresaTransporte;
    private double importeTransporte;
    private String comentarioAdicional;

    public Actividad_Programada( int id_actividad, String titulo, TipoActividad tipo, int departamento, boolean prevista, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean transporte, String comentarioTransporte, boolean alojamiento, String comentarioAlojamiento, String comentario, EstadoActividad estado, String comentarioEstado,String empresaTransporte, double importeTransporte, String comentarioAdicional) {
        super(id_actividad, 0, titulo, tipo, departamento, prevista, fechaInicio, fechaFin, transporte, comentarioTransporte, alojamiento, comentarioAlojamiento, comentario, estado, comentarioEstado);
        this.empresaTransporte = empresaTransporte;
        this.importeTransporte = importeTransporte;
        this.comentarioAdicional = comentarioAdicional;
    }

    public String getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void setEmpresaTransporte(String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }

    public double getImporteTransporte() {
        return importeTransporte;
    }

    public void setImporteTransporte(double importeTransporte) {
        this.importeTransporte = importeTransporte;
    }

    public String getComentarioAdicional() {
        return comentarioAdicional;
    }

    public void setComentarioAdicional(String comentarioAdicional) {
        this.comentarioAdicional = comentarioAdicional;
    }
    @Override
    public int getId_actividad() {
        return super.getId_actividad();
    }

    @Override
    public void setId_actividad(int id_actividad) {
        super.setId_actividad(id_actividad);
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    @Override
    public TipoActividad getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(TipoActividad tipo) {
        super.setTipo(tipo);
    }

    @Override
    public int getDepartamento() {
        return super.getDepartamento();
    }

    @Override
    public void setDepartamento(int departamento) {
        super.getDepartamento();
    }

    @Override
    public boolean isPrevista() {
        return super.isPrevista();
    }

    @Override
    public void setPrevista(boolean prevista) {
        super.setPrevista(prevista);
    }

    @Override
    public LocalDateTime getFechaInicio() {
        return super.getFechaInicio();
    }

    @Override
    public void setFechaInicio(LocalDateTime fechaInicio) {
        super.setFechaInicio(fechaInicio);
    }

    @Override
    public LocalDateTime getFechaFin() {
        return super.getFechaFin();
    }

    @Override
    public void setFechaFin(LocalDateTime fechaFin) {
        super.setFechaFin(fechaFin);
    }

    @Override
    public boolean isTransporte() {
        return super.isTransporte();
    }

    @Override
    public void setTransporte(boolean transporte) {
        super.setTransporte(transporte);
    }

    @Override
    public String getComentarioTransporte() {
        return super.getComentarioTransporte();
    }

    @Override
    public void setComentarioTransporte(String comentarioTransporte) {
        super.setComentarioTransporte(comentarioTransporte);
    }

    @Override
    public boolean isAlojamiento() {
        return super.isAlojamiento();
    }

    @Override
    public void setAlojamiento(boolean alojamiento) {
        super.setAlojamiento(alojamiento);
    }

    @Override
    public String getComentarioAlojamiento() {
        return super.getComentarioAlojamiento();
    }

    @Override
    public void setComentarioAlojamiento(String comentarioAlojamiento) {
        super.setComentarioAlojamiento(comentarioAlojamiento);
    }

    @Override
    public String getComentario() {
        return super.getComentario();
    }

    @Override
    public void setComentario(String comentario) {
        super.setComentario(comentario);
    }

    @Override
    public EstadoActividad getEstado() {
        return super.getEstado();
    }

    @Override
    public void setEstado(EstadoActividad estado) {
        super.setEstado(estado);
    }

    @Override
    public String getComentarioEstado() {
        return super.getComentarioEstado();
    }

    @Override
    public void setComentarioEstado(String comentarioEstado) {
        super.setComentarioEstado(comentarioEstado);
    }

    @Override
    public String toString() {
        return "Actividad_Programada{" + "empresaTransporte=" + empresaTransporte + ", importeTransporte=" + importeTransporte + ", comentarioAdicional=" + comentarioAdicional + '}';
    }
    
}
