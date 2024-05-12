
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
import java.util.Map;

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
            actividad_solicitada.setId_actividad(rs.getInt("id_actividad")); // Establecer el ID después de crear la instancia
            actividades_solicitadas.add(actividad_solicitada);
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
        // Código para la actualización
    } else {
        sql = "INSERT INTO actividades_solicitadas(solicitante, titulo, tipo, departamento, prevista, fini, ffin, hini, hfin, transporte, comentario_transporte, alojamiento, comentario_alojamiento, comentario, estado, comentario_estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            Date fechaInicioSql = Date.valueOf(actividad_solicitada.getFechaInicio().toLocalDate());
            Time horaInicioSql = Time.valueOf(actividad_solicitada.getFechaInicio().toLocalTime());
            Date fechaFinSql = Date.valueOf(actividad_solicitada.getFechaFin().toLocalDate());
            Time horaFinSql = Time.valueOf(actividad_solicitada.getFechaFin().toLocalTime());
            
            stmt.setInt(1, actividad_solicitada.getSolicitante());
            stmt.setString(2, actividad_solicitada.getTitulo());
            stmt.setString(3, actividad_solicitada.getTipo().name());
            stmt.setInt(4, actividad_solicitada.getDepartamento());
            stmt.setBoolean(5, actividad_solicitada.isPrevista());
            stmt.setDate(6, fechaInicioSql);
            stmt.setDate(7, fechaFinSql);
            stmt.setTime(8, horaInicioSql);
            stmt.setTime(9, horaFinSql);
            stmt.setBoolean(10, actividad_solicitada.isTransporte());
            stmt.setString(11, actividad_solicitada.getComentarioTransporte());
            stmt.setBoolean(12, actividad_solicitada.isAlojamiento());
            stmt.setString(13, actividad_solicitada.getComentarioAlojamiento());
            stmt.setString(14, actividad_solicitada.getComentario());
            stmt.setString(15, actividad_solicitada.getEstado().name());
            stmt.setString(16, actividad_solicitada.getComentarioEstado());
            
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception("No se ha insertado/modificado un solo registro");
            }
            
            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    actividad_solicitada.setId_actividad(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se generó el ID para la actividad solicitada");
                }
            }
        } catch (SQLException ex) {
            // manejo de errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            // manejo de errores
            System.out.println(ex.getMessage());
        }
    }
}

    @Override
    public void eliminar(int id_actividad) {
        String sql = "DELETE FROM actividades_solicitadas WHERE id_actividad=?";
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
        String sql = "\"SELECT id_actividad,solicitante,titulo,tipo,departamento,prevista,fini,ffin,hini,hfin,transporte,comentario_transporte,alojamiento,comentario_alojamiento,comentario,estado,comentario_estado FROM actividades_solicitadas WHERE id_actividad=?";
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
    
    public void insertarCursoParticipa(Map<Curso, Integer> cursos, int idActividadSolicitada) {
        String sql = "INSERT INTO curso_participa (id_curso, id_actividad, num_alumnos) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Map.Entry<Curso, Integer> entry : cursos.entrySet()) {
                Curso curso = entry.getKey();
                Integer numAlumnos = entry.getValue();

                stmt.setInt(1, curso.getId_curso());
                stmt.setInt(2, idActividadSolicitada);
                stmt.setInt(3, numAlumnos);

                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
    
    public void insertarGrupoParticipa(Map<Grupo, Integer> grupos, int idActividadSolicitada) {
        String sql = "INSERT INTO grupo_participa (id_grupo, id_actividad, num_alumnos) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Map.Entry<Grupo, Integer> entry : grupos.entrySet()) {
                Grupo grupo = entry.getKey();
                Integer numAlumnos = entry.getValue();

                stmt.setInt(1, grupo.getIdgrupo());
                stmt.setInt(2, idActividadSolicitada);
                stmt.setInt(3, numAlumnos);

                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
    public void insertarProfesorParticipa(List<Profesor> profesores, int id_actividad) {
        String sql = "INSERT INTO profesor_participa (id_profesor, id_actividad) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Profesor profesor : profesores) {
                stmt.setInt(1, profesor.getId_profesor());
                stmt.setInt(2, id_actividad);
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar profesores en profesor_participa: " + ex.getMessage());
        }
    }
   public void insertarProfesorResponsable(List<Profesor> profesores, int id_actividad) {
        String sql = "INSERT INTO profesor_responsable (id_profesor, id_actividad) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Profesor profesor : profesores) {
                stmt.setInt(1, profesor.getId_profesor());
                stmt.setInt(2, id_actividad);
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar profesores en profesor_responsable: " + ex.getMessage());
        }
    }
}
