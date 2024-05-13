package BaseDatos;

import BaseDatos.AccesoBaseDatos;
import Clases.Actividad_Programada;
import Clases.Actividad_Solicitada;
import Clases.Curso;
import Clases.Departamento;
import Enumerados.EstadoActividad;
import Enumerados.Etapa;
import Clases.Foto;
import Clases.Grupo;
import Enumerados.Perfil;
import Clases.Profesor;
import Enumerados.TipoActividad;
import Clases.Transporte;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class MetodosBD {
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    //Métodos actividad_solicitada
     public List<Actividad_Solicitada> listarActividadesSolicitadas() {
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

    public void guardarActividadSolicitada(Actividad_Solicitada actividad_solicitada) {
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
            
            stmt.setInt(1, actividad_solicitada.getSolicitante().getId_profesor());
            stmt.setString(2, actividad_solicitada.getTitulo());
            stmt.setString(3, actividad_solicitada.getTipo().name());
            stmt.setInt(4, actividad_solicitada.getDepartamento().getId_departamento());
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

    public void eliminarActividadSolicitada(int id_actividad) {
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
    
    public Actividad_Solicitada ActividadSolicitadaporId(int id_actividad) {
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
                this.ProfesorporId(rs.getInt("solicitante")),
                rs.getString("titulo"),
                TipoActividad.valueOf(rs.getString("tipo")),
                this.DepartamentoporId(rs.getInt("departamento")),
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
   
   //Metodos actividad_programada
   public List<Actividad_Programada> listarActividadesProgramadas() {
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
    public void guardarActividadProgramada(Actividad_Programada actividad_programada) {
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
            stmt.setInt(3, actividad_programada.getDepartamento().getId_departamento());
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

    public void eliminarActividadProgramada(int id_actividad) {
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
    
    public Actividad_Programada ActividadProgramadaporId(int id_actividad) {
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
                this.DepartamentoporId(rs.getInt("departamento")),
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
    
    
// Métodos para Curso
    
    public List<Curso> listarCursos() {
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

    public void guardarCurso(Curso curso) {
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

    public void eliminarCurso(int id_curso) {
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
    public Curso CursoporId(int id_curso) {
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
    public Map<Curso, Integer> CursosYnumAlumnos(Map<String, Integer> nombresynumAlumnos) {
        Map<Curso, Integer> resultado = new HashMap<>();
        for (Map.Entry<String, Integer> entry : nombresynumAlumnos.entrySet()) {
            String nombre = entry.getKey();
            Integer numAlumnos = entry.getValue();
            Curso curso = CursoporCodigo(nombre);
            if (curso != null) {
                resultado.put(curso, numAlumnos);
            }
        }
        return resultado;
    }

    public Curso CursoporCodigo(String codigo) {
        Curso curso = null;
        String sql = "SELECT id_curso,codigo,descripcion,etapa,activo FROM curso WHERE codigo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, codigo);
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
    
    public List<String> Codigoscursos(ArrayList<Curso> cursos) {
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
    
    //Métodos para Grupo
    
    public List<Grupo> listarGrupos() {
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

    public void guardarGrupo(Grupo grupo) {
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
            stmt.setInt(2, grupo.getcurso().getId_curso());
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

    public void eliminarGrupo(int id_grupo) {
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
    public Grupo GrupoporId(int id_grupo) {
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
    
    public List<String> CodigosGrupos(ArrayList<Grupo> grupos) {
        List<String> nombres = new ArrayList<>();
        for (Grupo grupo : grupos) {
            String cadena = "";
            cadena += grupo.getCodgrupo();
            nombres.add(cadena);
        }
        return nombres;
    }
    public Map<Grupo,Integer> gruposYnumAlumnos(Map<String,Integer> nombresynumAlumnos){
        Map<Grupo,Integer> resultado = new HashMap<>();
        for(Map.Entry<String, Integer> entry : nombresynumAlumnos.entrySet()) {
            String nombre = entry.getKey();
            Integer numAlumnos = entry.getValue();
            Grupo grupo = Grupoporcodigo(nombre);
            if(grupo != null) {
                resultado.put(grupo, numAlumnos);
            }
        }
            return resultado;}

    public Grupo Grupoporcodigo(String codigo) {
        Grupo grupo = null;
        String sql = "SELECT id_grupo,codigo,curso,num_alumnos,activo FROM grupo WHERE codigo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, codigo);
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
    
    private Grupo crearGrupo (final ResultSet rs)throws SQLException{
        return new Grupo(
        rs.getInt("id_grupo"),rs.getString("codigo"),this.CursoporId(rs.getInt("curso")),rs.getInt("num_alumnos"),rs.getBoolean("activo"));
    }
    
    //Métodos para Departamento
    
    public List<Departamento> listarDepartamentos() {
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

    public void guardarDepartamento(Departamento departamento) {
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

    public void eliminarDepartamento(int id_departamento) {
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
    public Departamento DepartamentoporId(int id_departamento) {
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
    public List<String> nombresDepartamento(List<Departamento> departamentos) {
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
    public Departamento DepartamentoporNombre(String nombre) {
        Departamento departamento = null;
        String sql = "SELECT id_depart,nombre,jefe,codigo_departamento FROM departamento WHERE nombre=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, nombre);
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
    
    // Métodos para Profesor
    
     public List<Profesor> listarProfesores() {
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
    public List<Profesor> obtenerProfesoresDesdeListadeNombres(List<String> nombresYApellidos) {
        List<Profesor> profesores = new ArrayList<>();

        // Obtener todos los profesores de la base de datos
        List<Profesor> todosLosProfesores = this.listarProfesores();

        // Iterar sobre la lista de nombres y apellidos
        for (String nombreApellido : nombresYApellidos) {
            // Separar nombre y apellido
            String[] partes = nombreApellido.split("-");
            if (partes.length == 2) {
                String nombre = partes[0];
                String apellido = partes[1];

                // Buscar el profesor correspondiente en la lista de todos los profesores
                for (Profesor profesor : todosLosProfesores) {
                    if (profesor.getNombre().equalsIgnoreCase(nombre) && profesor.getApellido().equalsIgnoreCase(apellido)) {
                        profesores.add(profesor); // Agregar el profesor encontrado a la lista resultante
                        break; // Terminar la búsqueda una vez que se haya encontrado el profesor
                    }
                }
            }
        }

        return profesores;
    }

    public void guardarProfesor(Profesor profesor) {
        String sql = null;
        if (profesor.getId_profesor() > 0) {
            sql = "UPDATE profesor SET nombre=?,apellido=?,departamento=?,correo=?,contraseña=?,perfil=?,dni=?,activo=? WHERE id_profesor=?";
        } else {
            sql = "INSERT INTO profesor(nombre,apellido,departamento,correo,contraseña,perfil,dni,activo) VALUES (?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (profesor.getId_profesor() > 0) {
                stmt.setInt(9, profesor.getId_profesor());
            }
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setInt(3, profesor.getDepartamento().getId_departamento());
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

    public void eliminarProfesor(int id_profesor) {
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
    public Profesor ProfesorporId(int id_profesor) {
        Profesor profesor = null;
        String sql = "SELECT id_profesor,nombre,apellido,departamento,correo,contraseña,perfil,dni,activo FROM profesor WHERE id_profesor=?";
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

    public Profesor verificarCredencialesProfesor(String correo, String contraseña) {
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

    public List<String> nombresProfesores(ArrayList<Profesor> profesores) {
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
                rs.getInt("id_profesor"), rs.getString("nombre"), rs.getString("apellidos"), this.DepartamentoporId(rs.getInt("departamento")), rs.getString("correo"), rs.getString("contrasena"), Perfil.valueOf(rs.getString("perfil")), rs.getString("dni"), rs.getBoolean("activo"));
    }
    
    //Métodos para Foto
    public List<Foto> listarFotos() {
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

    public void guardarFoto(Foto foto) {
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

    public void eliminarFoto(int id_foto) {
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
    public Foto FotoporId(int id_foto) {
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
    
 //Métodos para Transporte
    public List<Transporte> listarTransportes() {
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

    public void guardarTransporte(Transporte transporte) {
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

    public void eliminarTransporte(int id_transporte) {
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
    public Transporte TransporteporId(int id_transporte) {
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

//Otros Metodos
    public boolean validarDatos(String usuario, String password) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "SELECT correo, contrasena from profesor";
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {

                if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return false;
    }

    public int validarAdmin(String usuario) {
        Statement sentencia = null;
        ResultSet rs = null;
        Connection conn = AccesoBaseDatos.getInstance().getConn();
        boolean admin = false;

        try {
            sentencia = conn.createStatement();
            // dentro de executeQuery va el código de la select
            String sql = "select perfil from profesor where correo = ?";

            // Utilizamos PreparedStatement para evitar problemas de SQL Injection y mejorar la legibilidad del código
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                // Seleccionamos el administrador correspondiente al usuario y lo retornamos
                if (rs.getString("perfil").equals("SuperUsuario")) {
                    return 1;
                } else if (rs.getString("perfil").equals("Administrador")) {
                    return 2;
                } else if (rs.getString("perfil").equals("EquipoDirectivo")) {
                    return 3;
                } else if (rs.getString("perfil").equals("Profesor")) {
                    return 4;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia " + ex.getMessage());
            }
        }
        return 0;
    }
}
