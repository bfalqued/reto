
package Clases;

import java.time.LocalDateTime;

/**
 *
 * @author Borja
 */
public class Actividad_Solicitada {
    private int id_actividad;
    private int solicitante;
    private String titulo;
    private TipoActividad tipo;
    private int departamento;
    private boolean prevista;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean transporte;
    private String comentarioTransporte;
    private boolean alojamiento;
    private String comentarioAlojamiento;
    private String comentario;
    private EstadoActividad estado;
    private String comentarioEstado;

    public Actividad_Solicitada(int solicitante, String titulo, TipoActividad tipo, int departamento, boolean prevista, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean transporte, String comentarioTransporte, boolean alojamiento, String comentarioAlojamiento, String comentario, EstadoActividad estado, String comentarioEstado) {
        this.solicitante = solicitante;
        this.titulo = titulo;
        this.tipo = tipo;
        this.departamento = departamento;
        this.prevista = prevista;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.transporte = transporte;
        this.comentarioTransporte = comentarioTransporte;
        this.alojamiento = alojamiento;
        this.comentarioAlojamiento = comentarioAlojamiento;
        this.comentario = comentario;
        this.estado = estado;
        this.comentarioEstado = comentarioEstado;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(int solicitante) {
        this.solicitante = solicitante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public String getComentarioTransporte() {
        return comentarioTransporte;
    }

    public void setComentarioTransporte(String comentarioTransporte) {
        this.comentarioTransporte = comentarioTransporte;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public String getComentarioAlojamiento() {
        return comentarioAlojamiento;
    }

    public void setComentarioAlojamiento(String comentarioAlojamiento) {
        this.comentarioAlojamiento = comentarioAlojamiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public String getComentarioEstado() {
        return comentarioEstado;
    }

    public void setComentarioEstado(String comentarioEstado) {
        this.comentarioEstado = comentarioEstado;
    }

    @Override
    public String toString() {
        return "Actividad_Solicitada{" + "id_actividad=" + id_actividad + ", solicitante=" + solicitante + ", titulo=" + titulo + ", tipo=" + tipo + ", departamento=" + departamento + ", prevista=" + prevista + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", transporte=" + transporte + ", comentarioTransporte=" + comentarioTransporte + ", alojamiento=" + alojamiento + ", comentarioAlojamiento=" + comentarioAlojamiento + ", comentario=" + comentario + ", estado=" + estado + ", comentarioEstado=" + comentarioEstado + '}';
    }
    
}
