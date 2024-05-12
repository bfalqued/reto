
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
public class Actividad_ProgramadaDAOImp implements Repositorio <Actividad_Programada>{
     private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    @Override
    public List<Actividad_Programada> listar() {
        List<Actividad_Programada> actividades_programadas = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_actividad,titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado,empresa_transporte,importe_transporte,comentario_adicional FROM actividades_programadas");) {
            while (rs.next()) {
                Actividad_Programada actividad_programada = crearActividad_Programada(rs);
                if (!actividades_programadas.add(actividad_programada)) {
                    throw new Exception("Error: No se ha podido insertar el grupo en la colección");
                }
            }
        } catch (SQLException ex) {
            //errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return actividades_programadas;
    }

    @Override
    public void guardar(Actividad_Programada actividad_programada) {
        String sql = null;
        if (actividad_programada.getId_actividad() > 0) {
            sql = "UPDATE actividad_programada SET titulo=?,tipo=?,departamento=?,prevista=?,fini=?,ffin=?,hini=?,hfin=?,transporte=?,comentario_transporte=?,alojamiento=?,comentario_alojamiento=?,comentario=?,estado=?,comentario_estado=?,empresa_transporte=?,importe_transporte=?,comentario_adicional=? WHERE id_actividad=?";
        } else {
            sql = "INSERT INTO actividad_programada(titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado,empresa_transporte,importe_transporte,comentario_adicional) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            Date fechaInicioSql = Date.valueOf(actividad_programada.getFechaInicio().toLocalDate());
            Time horaInicioSql = Time.valueOf(actividad_programada.getFechaInicio().toLocalTime());
            Date fechaFinSql = Date.valueOf(actividad_programada.getFechaFin().toLocalDate());
            Time horaFinSql = Time.valueOf(actividad_programada.getFechaFin().toLocalTime());
            if (actividad_programada.getId_actividad() > 0) {
                stmt.setInt(19, actividad_programada.getId_actividad());         
            }            
            stmt.setString(1, actividad_programada.getTitulo());
            stmt.setString(2,actividad_programada.getTipo().name());
            stmt.setInt(3, actividad_programada.getDepartamento());
            stmt.setBoolean(4, actividad_programada.isPrevista());
            stmt.setDate(5,fechaInicioSql);
            stmt.setDate(6, fechaFinSql);
            stmt.setTime(7, horaInicioSql);
            stmt.setTime(8, horaFinSql);
            stmt.setBoolean(9, actividad_programada.isTransporte());
            stmt.setString(10, actividad_programada.getComentarioTransporte());
            stmt.setBoolean(11,actividad_programada.isAlojamiento());
            stmt.setString(12, actividad_programada.getComentarioAlojamiento());
            stmt.setString(13, actividad_programada.getComentario());
            stmt.setString(14, actividad_programada.getEstado().name());
            stmt.setString(15, actividad_programada.getComentarioEstado());
            stmt.setString(16,actividad_programada.getEmpresaTransporte());
            stmt.setDouble(17, actividad_programada.getImporteTransporte());
            stmt.setString(18, actividad_programada.getComentarioAdicional());
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
        String sql = "DELETE FROM actividad_programada WHERE id_actividad=?";
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
    public Actividad_Programada porId(int id_actividad) {
        Actividad_Programada actividad_programada = null;
        String sql = "\"SELECT id_actividad,"
                + "titulo,"
                + "tipo,"
                + "departamento,"
                + "prevista,"
                + "fini,"
                + "ffin,"
                + "hini,"
                + "hfin,"
                + "transporte,"
                + "comentario_transporte,"
                + "alojamiento,"
                + "comentario_alojamiento,"
                + "comentario,"
                + "estado,"
                + "comentario_estado,"
                + "empresa_transporte,"
                + "importe_transporte,"
                + "comentario_adicional FROM actividad_programada WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id_actividad);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    actividad_programada = crearActividad_Programada(rs);
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return actividad_programada;
    }
    private Actividad_Programada crearActividad_Programada (final ResultSet rs)throws SQLException{
        return new Actividad_Programada(               
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
                rs.getString("comentario_estado"),
                rs.getString("empresa_transporte"),
                rs.getDouble("importe_transporte"),
                rs.getString("comentario_adicional"));
    }
}
