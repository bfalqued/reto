
package Clases;

import java.util.List;

/**
 *
 * @author Borja
 */
public interface Repositorio <T>{
    public List <T> listar();
    public void guardar(T t);
    public void eliminar(int id);
    public T porId (int id);
}
