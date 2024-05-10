
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
public class FotoDAOImp implements Repositorio <Foto>{
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Foto> listar() {
        List<Foto> fotos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_foto,url,descripcion FROM foto");) {
            while (rs.next()) {
                Foto foto = crearFoto(rs);
                if (!fotos.add(foto)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fotos;
    }

    @Override
    public void guardar(Foto foto) {
        String sql = null;
        if (foto.getId_foto() > 0) {
            sql = "UPDATE foto SET url=?,descripcion=? WHERE id_foto=?";
        } else {
            sql = "INSERT INTO foto(url,descripcion) VALUES (?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (foto.getId_foto() > 0) {
                stmt.setInt(3, foto.getId_foto());
            }
            stmt.setString(1, foto.getUrl());
            stmt.setString(2, foto.getDescripcion());            
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
    public void eliminar(int id_foto) {
        String sql = "DELETE FROM foto WHERE id_foto=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_foto);
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

    // método privado crea el objeto foto en este caso utiliza constructor por parámetros.
    @Override
    public Foto porId(int id_foto) {
        Foto foto = null;
        String sql = "SELECT id_foto,url,descripcion FROM foto WHERE id_foto=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_foto);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    foto = crearFoto(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return foto;
    }
    private Foto crearFoto (final ResultSet rs)throws SQLException{
        return new Foto(
        rs.getInt("id_foto"),rs.getString("url"),rs.getString("descripcion"));
    }
}
