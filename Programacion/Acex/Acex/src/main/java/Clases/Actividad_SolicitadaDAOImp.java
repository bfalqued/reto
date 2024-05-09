
package Clases;

import java.sql.Date;
import java.sql.Time;
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
public class Actividad_SolicitadaDAOImp implements Repositorio <Actividad_Solicitada>{
        private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Actividad_Solicitada> listar() {
        List<Actividad_Solicitada> actividades_solicitadas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_actividad,solicitante,titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado FROM actividades_solicitadas");) {
            while (rs.next()) {
                Actividad_Solicitada actividad_solicitada = crearActividad_Solicitada(rs);
                if (!actividades_solicitadas.add(actividad_solicitada)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return actividades_solicitadas;
    }

    @Override
    public void guardar(Actividad_Solicitada actividad_solicitada) {
        String sql = null;
        if (actividad_solicitada.getId_actividad() > 0) {
            sql = "UPDATE actividad_solicitada SET solicitante=?,titulo=?,tipo=?,departamento=?,prevista=?,fini=?,ffin=?,hini=?,hfin=?,transporte=?,comentario_transporte=?,alojamiento=?,comentario_alojamiento=?,comentario=?,estado=?,comentario_estado=? WHERE id_actividad=?";
        } else {
            sql = "INSERT INTO actividad_solicitada(solicitante,titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Date fechaInicioSql = Date.valueOf(actividad_solicitada.getFechaInicio().toLocalDate());
            Time horaInicioSql = Time.valueOf(actividad_solicitada.getFechaInicio().toLocalTime());
            Date fechaFinSql = Date.valueOf(actividad_solicitada.getFechaFin().toLocalDate());
            Time horaFinSql = Time.valueOf(actividad_solicitada.getFechaFin().toLocalTime());
            if (actividad_solicitada.getId_actividad() > 0) {
                stmt.setInt(17, actividad_solicitada.getId_actividad());         
            }
            stmt.setInt(1, actividad_solicitada.getSolicitante());
            stmt.setString(2, actividad_solicitada.getTitulo());
            stmt.setString(3,actividad_solicitada.getTipo().name());
            stmt.setInt(4, actividad_solicitada.getDepartamento());
            stmt.setBoolean(5, actividad_solicitada.isPrevista());
            stmt.setDate(6,fechaInicioSql);
            stmt.setDate(7, fechaFinSql);
            stmt.setTime(8, horaInicioSql);
            stmt.setTime(9, horaFinSql);
            stmt.setBoolean(10, actividad_solicitada.isTransporte());
            stmt.setString(11, actividad_solicitada.getComentarioTransporte());
            stmt.setBoolean(12,actividad_solicitada.isAlojamiento());
            stmt.setString(13, actividad_solicitada.getComentarioAlojamiento());
            stmt.setString(14, actividad_solicitada.getComentario());
            stmt.setString(15, actividad_solicitada.getEstado().name());
            stmt.setString(16, actividad_solicitada.getComentarioEstado());
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
    public void eliminar(int id_actividad) {
        String sql = "DELETE FROM actividad_solicitada WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_actividad);
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

    // método privado crea el objeto actividad_solicitada en este caso utiliza constructor por parámetros.
    @Override
    public Actividad_Solicitada porId(int id_actividad) {
        Actividad_Solicitada actividad_solicitada = null;
        String sql = "\"SELECT id_actividad,solicitante,titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado FROM actividad_solicitada WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_actividad);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    actividad_solicitada = crearActividad_Solicitada(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return actividad_solicitada;
    }
    private Actividad_Solicitada crearActividad_Solicitada (final ResultSet rs)throws SQLException{
        return new Actividad_Solicitada(
        rs.getInt("id_actividad"),
                rs.getInt("solicitante"),
                rs.getString("titulo"),
                TipoActividad.valueOf(rs.getString("tipo")),
                rs.getInt("departamento"),
                rs.getBoolean("prevista"),
                rs.getDate("fini").toLocalDate().atTime(rs.getTime("hini").toLocalTime()),
                rs.getDate("ffin").toLocalDate().atTime(rs.getTime("hfin").toLocalTime()),
                rs.getBoolean("transporte"),
                rs.getString("comentario_transporte"),
                rs.getBoolean("alojamiento"),
                rs.getString("comentario_alojamiento"),
                rs.getString("comentario"),
                EstadoActividad.valueOf(rs.getString("estado")),
                rs.getString("comentario_estado"));
    }
}
