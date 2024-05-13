
package Clases;

import Enumerados.EstadoActividad;
import Enumerados.TipoActividad;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Borja
 */
public class Actividad_Solicitada {
    private int id_actividad;
    private Profesor solicitante;
    private String titulo;
    private TipoActividad tipo;
    private Departamento departamento;
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
    private Map<Object,Integer> participantes;
    private List<Profesor> profesoresParticipantes;
    private List<Profesor> profesorResponsables;

    public Actividad_Solicitada(Profesor solicitante, String titulo, TipoActividad tipo, Departamento departamento, boolean prevista, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean transporte, String comentarioTransporte, boolean alojamiento, String comentarioAlojamiento, String comentario, EstadoActividad estado, String comentarioEstado) {
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
        this.comentario= comentario;
        this.estado = estado;
        this.comentarioEstado = comentarioEstado;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Profesor getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Profesor solicitante) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
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

    public Map<Object, Integer> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Map<Object, Integer> participantes) {
        this.participantes = participantes;
    }

    public List<Profesor> getProfesoresParticipantes() {
        return profesoresParticipantes;
    }

    public void setProfesoresParticipantes(List<Profesor> profesoresParticipantes) {
        this.profesoresParticipantes = profesoresParticipantes;
    }

    public List<Profesor> getProfesorResponsables() {
        return profesorResponsables;
    }

    public void setProfesorResponsables(List<Profesor> profesorResponsables) {
        this.profesorResponsables = profesorResponsables;
    }
    
    
    @Override
    public String toString() {
        return "Actividad_Solicitada{" + "id_actividad=" + id_actividad + ", solicitante=" + solicitante + ", titulo=" + titulo + ", tipo=" + tipo + ", departamento=" + departamento + ", prevista=" + prevista + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", transporte=" + transporte + ", comentarioTransporte=" + comentarioTransporte + ", alojamiento=" + alojamiento + ", comentarioAlojamiento=" + comentarioAlojamiento + ", comentario=" + comentario + ", estado=" + estado + ", comentarioEstado=" + comentarioEstado + '}';
    }
    
}
