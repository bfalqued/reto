
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Borja
 */
public class TransporteDAOImp implements Repositorio <Transporte>{
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Transporte> listar() {
        List<Transporte> transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_transporte,tipo,comentario FROM transporte");) {
            while (rs.next()) {
                Transporte transporte = crearTransporte(rs);
                if (!transportes.add(transporte)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return transportes;
    }

    @Override
    public void guardar(Transporte transporte) {
        String sql = null;
        if (transporte.getId_transporte() > 0) {
            sql = "UPDATE transporte SET tipo=?,comentario=? WHERE id_transporte=?";
        } else {
            sql = "INSERT INTO transporte(tipo,comentario) VALUES (?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (transporte.getId_transporte() > 0) {
                stmt.setInt(3, transporte.getId_transporte());
            }
            stmt.setString(1, transporte.getTipo());
            stmt.setString(2, transporte.getComentario());            
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id_transporte) {
        String sql = "DELETE FROM transporte WHERE id_transporte=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_transporte);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // método privado crea el objeto grupo en este caso utiliza constructor por parámetros.
    @Override
    public Transporte porId(int id_transporte) {
        Transporte transporte = null;
        String sql = "SELECT id_transporte,tipo,comentario FROM transporte WHERE id_transporte=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_transporte);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    transporte = crearTransporte(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return transporte;
    }
    private Transporte crearTransporte (final ResultSet rs)throws SQLException{
        return new Transporte(
        rs.getInt("id_transporte"),rs.getString("tipo"),rs.getString("comentario"));
    }
}
