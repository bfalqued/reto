package Clases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Spliterators.iterator;
import javax.swing.JFileChooser;

/**
 *
 * @author Borja
 */
public class ProfesorDAOImp implements Repositorio<Profesor> {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Profesor> listar() {
        List<Profesor> profesores = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_profesor,nombre,apellidos,departamento,correo,contrasena,perfil,dni,activo FROM profesor");) {
            while (rs.next()) {
                Profesor profesor = crearProfesor(rs);
                if (!profesores.add(profesor)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }

    @Override
    public void guardar(Profesor profesor) {
        String sql = null;
        if (profesor.getId_profesor() > 0) {
            sql = "UPDATE profesor SET nombre=?,apellido=?,departamento=?,correo=?,contrasena=?,perfil=?,dni=?,activo=? WHERE id_profesor=?";
        } else {
            sql = "INSERT INTO profesor(nombre,apellido,departamento,correo,contrasena,perfil,dni,activo) VALUES (?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (profesor.getId_profesor() > 0) {
                stmt.setInt(9, profesor.getId_profesor());
            }
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setInt(3, profesor.getDepartamento());
            stmt.setString(4, profesor.getCorreo());
            stmt.setString(5, profesor.getContrasena());
            stmt.setString(6, profesor.Perfil());
            stmt.setString(7, profesor.getDni());
            stmt.setBoolean(8, profesor.isActivo());
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
    public void eliminar(int id_profesor) {
        String sql = "DELETE FROM profesor WHERE id_profesor=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_profesor);
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
    public Profesor porId(int id_profesor) {
        Profesor profesor = null;
        String sql = "SELECT id_profesor,nombre,apellido,departamento,correo,contrasena,perfil,dni,activo FROM profesor WHERE id_profesor=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_profesor);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    public Profesor verificarCredenciales(String correo, String contraseña) {
        Profesor profesor = null;
        String sql = "SELECT id_profesor, nombre, apellidos, departamento, correo, contrasena, perfil, dni, activo FROM profesor WHERE correo = ? AND contrasena = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, correo);
            stmt.setString(2, contraseña);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    public List<String> nombres(ArrayList<Profesor> profesores) {
        List<String> nombres = new ArrayList<>();
        for (Profesor profesor : profesores) {
            String cadena = "";
            cadena += profesor.getNombre();
            cadena += " ";
            cadena += profesor.getApellido();
            nombres.add(cadena);
        }
        return nombres;
    }
    

    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        return new Profesor(
                rs.getInt("id_profesor"), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("departamento"), rs.getString("correo"), rs.getString("contrasena"), Perfil.valueOf(rs.getString("perfil")), rs.getString("dni"), rs.getBoolean("activo"));
    }

}
