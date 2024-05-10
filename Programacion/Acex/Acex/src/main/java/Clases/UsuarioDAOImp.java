
package Clases;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author DAW122
 */
public class UsuarioDAOImp implements Repositorio<Usuario>{
    
    private Connection getConnection(){
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public void guardar(Usuario t) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

    @Override
    public Usuario porId(int id) {
        return null;
    }
    
    
}
