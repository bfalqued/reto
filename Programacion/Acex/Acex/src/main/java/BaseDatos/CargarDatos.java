
package BaseDatos;
import BaseDatos.AccesoBaseDatos;
import Enumerados.Perfil;
import Clases.Profesor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



/**
 *
 * @author DAW122
 */
public class CargarDatos {

    MetodosBD bd=new MetodosBD();
    
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    

    // Método para cargar datos de profesores desde un archivo CSV
    public  List <Profesor> cargarCSVProfesores(File fichero) {
        List<Profesor> profesores = new ArrayList<>();
        String linea;
        int idProfesor = 0;
        FileReader fr;
        try  {if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String apellidos = datoslinea[0];
                    String nombre = datoslinea[1];
                    String dni = datoslinea[2];
                    String correo = datoslinea[3];
                    int departamento = Integer.parseInt(datoslinea[4]);
                    idProfesor++;
                    Profesor p = new Profesor(idProfesor, nombre, apellidos, bd.DepartamentoporId(departamento), correo,generarContraseña(8), Perfil.profesor,dni,true);
                    profesores.add(p);

                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return profesores;
    }

    // Método para insertar un profesor en la base de datos
    public void insertarProfesores(List<Profesor> listaProfesor) {
    String sqlInsertar = "INSERT INTO profesor(id_profesor, nombre, apellidos, dni, perfil, departamento, correo, activo, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String sqlActualizarActivo = "UPDATE profesor SET activo = true WHERE DNI = ?";
    String sqlActualizarInactivo = "UPDATE profesor SET activo = false WHERE DNI = ?";
    
    try (PreparedStatement pstmtInsertar = getConnection().prepareStatement(sqlInsertar);
         PreparedStatement pstmtActualizarActivo = getConnection().prepareStatement(sqlActualizarActivo);
         PreparedStatement pstmtActualizarInactivo = getConnection().prepareStatement(sqlActualizarInactivo)) {
        
        // Cambiar el estado de los profesores ya cargados a inactivo
        for (Profesor p : listaProfesor) {
            try {
                pstmtActualizarInactivo.setString(1, p.getDni());
                pstmtActualizarInactivo.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al actualizar estado de profesor existente: " + e.getMessage());
            }
        }
        
        // Insertar o actualizar los nuevos profesores
        for (Profesor p : listaProfesor) {
            try {
                // Si el profesor ya existe, actualiza su estado a activo
                if (profesorExiste(p.getDni())) {
                    pstmtActualizarActivo.setString(1, p.getDni());
                    pstmtActualizarActivo.executeUpdate();
                } else {
                    // Si el profesor no existe, inserta un nuevo registro con estado activo
                    pstmtInsertar.setInt(1, p.getId_profesor());
                    pstmtInsertar.setString(2, p.getNombre());
                    pstmtInsertar.setString(3, p.getApellido());
                    pstmtInsertar.setString(4, p.getDni());
                    pstmtInsertar.setString(5, p.getPerfil().name());
                    pstmtInsertar.setInt(6, p.getDepartamento().getId_departamento());
                    pstmtInsertar.setString(7, p.getCorreo());
                    pstmtInsertar.setBoolean(8, p.isActivo());
                    pstmtInsertar.setString(9, p.getContrasena());
                    pstmtInsertar.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("Error al insertar o actualizar profesor: " + e.getMessage());
            }
        }
        
    } catch (SQLException e) {
        System.out.println("Error al preparar la sentencia SQL: " + e.getMessage());
    }
}
    
    private static String generarContraseña(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        char[] password = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            password[i] = caracteres.charAt(r.nextInt(caracteres.length()));
        }
        return new String(password);
    }

    // Método para verificar si un profesor ya existe en la base de datos
    private  boolean profesorExiste(String dni) throws SQLException {
        String query = "SELECT COUNT(*) FROM profesor WHERE dni = '" + dni + "'";
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            rs.next();
            return rs.getInt(1) > 0;
        }
    }
}
