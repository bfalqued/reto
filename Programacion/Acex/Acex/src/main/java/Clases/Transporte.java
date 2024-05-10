
package Clases;

/**
 *
 * @author Borja
 */
public class Transporte {
    private int id_transporte;
    private String tipo;
    private String comentario;

    public Transporte(int id_transporte, String tipo, String comentario) {
        this.id_transporte = id_transporte;
        this.tipo = tipo;
        this.comentario = comentario;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Transporte{" + "id_transporte=" + id_transporte + ", tipo=" + tipo + ", comentario=" + comentario + '}';
    }
    
}
