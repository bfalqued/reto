
package Clases;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Borja
 */
public class Teclado {
    public static boolean validarDni(String dni) {
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        boolean result = false;
        try {
            if (dni.length() == 9) {

                if (dni.substring(0, 8).matches("[0-9]+")) {
                    int resultDivision = Integer.parseInt(dni.substring(0, 8)) % 23;
                    if (dni.substring(8, 9).toUpperCase().contentEquals(letrasDni.substring(resultDivision, resultDivision + 1))) {
                        result = true;
                    } else {
                        throw new Exception("La letra no es correcta");
                    }

                } else {
                    throw new Exception("los primeros 8 caracteres del Dni no son numeros");
                }

            } else {
                throw new Exception("El Dni tiene menos de 9 caracteres");
            }

        } catch (Exception e) {
            System.out.println("Error indeterminado...");
            System.out.println(e.getMessage());
        }

        return result;
    }
    public static boolean insertaString(String input) {
        if (Pattern.matches("[a-zA-Z]+", input) && !input.contains("Ñ")) {
            return true;
        } else {
            return false;
        }
    }
   public static boolean validarFechaInicio(LocalDateTime dateTime) {
        if (dateTime == null) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        if (dateTime.isBefore(now)) {
            return false;
        }
        LocalDateTime limiteInferior = LocalDateTime.of(2020, 1, 1, 0, 0);
        LocalDateTime limiteSuperior = LocalDateTime.of(2025, 12, 31, 23, 59);
        if (dateTime.isBefore(limiteInferior) || dateTime.isAfter(limiteSuperior)) {
            return false;
        }
        return true;
    }
    public static boolean validarFechaFin(LocalDateTime dateTime, LocalDateTime dateTimeAnterior) {
        if (dateTime == null || dateTimeAnterior == null) {
            return false;
        }
        if (dateTime.isBefore(dateTimeAnterior)) {
            return false;
        }
        return true;
    }
     public static boolean validarInsercionEntero(int numero) {
            if (numero >= 0) {
                return true;
            } else {
                return false;
            }
    }
     public static boolean validarCodDepartamento(String codigo_departamento) {
        try {
            Pattern pattern = Pattern.compile("^[A-MO-Z]{3}$");
            Matcher matcher = pattern.matcher(codigo_departamento);
            return matcher.matches();
        } catch (Exception e) {
            System.out.println("Error al validar la cadena: " + e.getMessage());
            return false;
        }
    }
     public static boolean validarCodGrupo(String codigo_grupo) {
        try {
            if (codigo_grupo.length() < 1 || codigo_grupo.length() > 5) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error al validar el código: " + e.getMessage());
            return false;
        }
    }
     public static boolean validarCodCurso(String codigo_curso) {
        try {
            if (codigo_curso.length() < 1 ||  codigo_curso.length() > 8) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error al validar el código: " + e.getMessage());
            return false;
        }
    }
}
//public class CargarDatos {


  //  public static void cargarProfesores(String rutaFichero,ArrayList<Profesor> profesores){
    //    FicheroProfesorCSV csv= new FicheroProfesorCSV(rutaFichero,profesores);
      //  csv.leerFicheroProfesoresCSV();
       // ArrayList<Profesor> profesoresCargados =csv.getProfesores();
       // ProfesorDAOImp dao = new ProfesorDAOImp();
        //for(Profesor p : profesoresCargados){ 
        //    dao.guardar(p);
       // }
   // }
//}
//}
