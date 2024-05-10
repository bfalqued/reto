
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
public class DepartamentoDAOImp implements Repositorio <Departamento>{
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_depart,nombre,jefe,codigo_departamento FROM departamento");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!departamentos.add(departamento)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return departamentos;
    }

    @Override
    public void guardar(Departamento departamento) {
        String sql = null;
        if (departamento.getId_departamento() > 0) {
            sql = "UPDATE departamento SET nombre=?,jefe=?,codigo_departamento=? WHERE id_depart=?";
        } else {
            sql = "INSERT INTO departamento(nombre,jefe,codigo_departamento) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (departamento.getId_departamento() > 0) {
                stmt.setInt(4, departamento.getId_departamento());
            }
            stmt.setString(1, departamento.getNombre());
            stmt.setInt(2, departamento.getJefe());
            stmt.setString(3,departamento.getCodigo_departamento());
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
    public void eliminar(int id_departamento) {
        String sql = "DELETE FROM departamento WHERE id_depart=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_departamento);
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
    public Departamento porId(int id_departamento) {
        Departamento departamento = null;
        String sql = "SELECT id_depart,nombre,jefe,codigo_departamento FROM departamento WHERE id_depart=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_departamento);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return departamento;
    }
    public List<String> nombres(List<Departamento> departamentos) {
        List<String> nombres = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            String cadena = "";
            cadena += departamento.getNombre();          
            nombres.add(cadena);
        }
        return nombres;
    }
    private Departamento crearDepartamento (final ResultSet rs)throws SQLException{
        return new Departamento(
        rs.getInt("id_depart"),rs.getString("nombre"),rs.getInt("jefe"),rs.getString("codigo_departamento"));
    }
    
}
