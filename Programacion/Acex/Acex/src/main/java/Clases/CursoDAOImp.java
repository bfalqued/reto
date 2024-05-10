
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
public class CursoDAOImp implements Repositorio<Curso> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_curso,codigo,descripcion,etapa,activo FROM curso");) {
            while (rs.next()) {
                Curso curso = crearCurso(rs);
                if (!cursos.add(curso)) {
                    throw new Exception("Error: No se ha podido insertar el curso en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cursos;
    }

    @Override
    public void guardar(Curso curso) {
        String sql = null;
        if (curso.getId_curso() > 0) {
            sql = "UPDATE curso SET codigo=?,descripcion=?,etapa=?,activo=? WHERE id_curso=?";
        } else {
            sql = "INSERT INTO curso(codigo,descripcion,etapa,activo) VALUES (?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (curso.getId_curso() > 0) {
                stmt.setInt(5, curso.getId_curso());
            }
            stmt.setString(1, curso.getCodigo());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getEtapa().name());
            stmt.setBoolean(4, curso.isActivo());
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
    public void eliminar(int id_curso) {
        String sql = "DELETE FROM curso WHERE id_curso=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_curso);
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

    // método privado crea el objeto curso en este caso utiliza constructor por parámetros.
    @Override
    public Curso porId(int id_curso) {
        Curso curso = null;
        String sql = "SELECT id_curso,codigo,descripcion,etapa,activo FROM curso WHERE id_curso=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_curso);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return curso;
    }
    
    public List<String> cursos(ArrayList<Curso> cursos) {
        List<String> nombres = new ArrayList<>();
        for (Curso curso : cursos) {
            String cadena = "";
            cadena += curso.getCodigo();
            nombres.add(cadena);
        }
        return nombres;
    }
    private Curso crearCurso (final ResultSet rs)throws SQLException{
        return new Curso(
        rs.getInt("id_curso"),rs.getString("codigo"),rs.getString("descripcion"),Etapa.valueOf(rs.getString("etapa")),rs.getBoolean("activo"));
    }
}
