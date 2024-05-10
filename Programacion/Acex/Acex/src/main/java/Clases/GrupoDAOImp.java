
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
public class GrupoDAOImp implements Repositorio <Grupo>{
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Grupo> listar() {
        List<Grupo> grupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_grupo,codigo,curso,num_alumnos,activo FROM grupo");) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                if (!grupos.add(grupo)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grupos;
    }

    @Override
    public void guardar(Grupo grupo) {
        String sql = null;
        if (grupo.getIdgrupo() > 0) {
            sql = "UPDATE curso SET codigo=?,curso=?,num_alumnos=?,activo=? WHERE id_grupo=?";
        } else {
            sql = "INSERT INTO grupo(codigo,curso,num_alumnos,activo) VALUES (?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (grupo.getIdgrupo() > 0) {
                stmt.setInt(5, grupo.getIdgrupo());
            }
            stmt.setString(1, grupo.getCodgrupo());
            stmt.setInt(2, grupo.getIdcurso());
            stmt.setInt(3, grupo.getAlumnos());
            stmt.setBoolean(4, grupo.isActivo());
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
    public void eliminar(int id_grupo) {
        String sql = "DELETE FROM grupo WHERE id_grupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_grupo);
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
    public Grupo porId(int id_grupo) {
        Grupo grupo = null;
        String sql = "SELECT id_grupo,codigo,curso,num_alumnos,activo FROM grupo WHERE id_grupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_grupo);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return grupo;
    }
    
    public List<String> grupos(ArrayList<Grupo> grupos) {
        List<String> nombres = new ArrayList<>();
        for (Grupo grupo : grupos) {
            String cadena = "";
            cadena += grupo.getCodgrupo();
            nombres.add(cadena);
        }
        return nombres;
    }
    
    private Grupo crearGrupo (final ResultSet rs)throws SQLException{
        return new Grupo(
        rs.getInt("id_grupo"),rs.getString("codigo"),rs.getInt("curso"),rs.getInt("num_alumnos"),rs.getBoolean("activo"));
    }
    
}
