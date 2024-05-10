///*
//package Clases;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// *
// * @author DAW122
// */
//public class FicheroProfesorCSV {
//    private String nombreFicheroCSVLeer;
//    private ArrayList<Profesor> profesores;
//
//    public FicheroProfesorCSV(String nombreFicheroCSVLeer, ArrayList<Profesor> profesores) {
//        this.nombreFicheroCSVLeer = nombreFicheroCSVLeer;
//        if(profesores == null){
//            this.profesores = new ArrayList<Profesor>();
//        }else{
//        this.profesores = profesores;}
//    }
//            
//    //recuperar los datos
//    
//    public void leerFicheroProfesoresCSV(){
//        FileReader fr;
//        try { 
//            fr = new FileReader(this.nombreFicheroCSVLeer);
//            String linea ="";
//            
//            BufferedReader br = new BufferedReader(fr);
//            while((linea = br.readLine()) !=null){
//                String[] datoslinea =linea.split(","); //le decimos que va separado por puntos y comas
//                
//                String nombre = datoslinea[1]; //ver uso de trim()-> elimina espacios en blanco iniciales y finales
//                String apellido = datoslinea[2];
//                int departamento = Integer.parseInt(datoslinea[3]);
//                String correo = datoslinea[4];
//                String contrasena = datoslinea[5];
//                String perfil = datoslinea[6];
//                Perfil PERFIL = Perfil.valueOf(perfil);
//                String dni = datoslinea[7];
//                int activo = Integer.parseInt(datoslinea[8]);
//                boolean ACTIVO = false;
//                if(activo ==1){
//                    ACTIVO=true;
//                }
//                Profesor p = new Profesor(id_profesor, nombre, apellido, departamento, correo,contrasena,PERFIL,dni,ACTIVO);
//                this.profesores.add(p); 
//                
//            }
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch(IOException ex){
//            ex.printStackTrace();
//        }
//        
//    }
//        private String extraerNombre(String apellidosNombre) {
//        return apellidosNombre.split("\\s+")[1];
//    }
//
//    private String extraerApellidos(String apellidosNombre) {
//        return apellidosNombre.split("\\s+")[0];
//    }
//    
//    //mostrar los cursos
//    
//    public void mostrarProfesores(){
//        for(Profesor c : this.profesores){
//            System.out.println(c.toString());
//        }
//    }
//   
//    public ArrayList<Profesor> getProfesores() {
//        return new ArrayList<>(profesores); // Devolver una copia de la lista
//    }
//    
//    public void anadirProfesor(Profesor p){
//        profesores.add(p);
//    }
//}
//
