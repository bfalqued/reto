
package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DAW122
 */
public class FicheroCursoCSV {
    private String nombreFicheroCSVLeer;
    private String nombreFicheroEscribir;
    private ArrayList<Curso> cursos;

    public FicheroCursoCSV(String nombreFicheroCSVLeer, String nombreFicheroEscribir, ArrayList<Curso> cursos) {
        this.nombreFicheroCSVLeer = nombreFicheroCSVLeer;
        this.nombreFicheroEscribir = nombreFicheroEscribir;
        if(cursos == null){
            this.cursos = new ArrayList<Curso>();
        }else{
        this.cursos = cursos;}
    }
            
    //recuperar los datos
    
    public void leerFicheroCursosCSV(){
        FileReader fr;
        try { 
            fr = new FileReader(this.nombreFicheroCSVLeer);
            String linea ="";
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) !=null){
                String[] datoslinea =linea.split(","); //le decimos que va separado por puntos y comas
                int idcurso = Integer.parseInt(datoslinea[0]);
                String codcurso = datoslinea[1]; //ver uso de trim()-> elimina espacios en blanco iniciales y finales
                String descurso = datoslinea[2];
                String etp = datoslinea[3];
                int activo = Integer.parseInt(datoslinea[4]);// esto es una línea
                boolean ACTIVO = false;
                if(activo==1){
                    ACTIVO = true;
                }
                Etapa etapa= Etapa.valueOf(etp);
                Curso c = new Curso(idcurso, codcurso, descurso, etapa, ACTIVO);
                this.cursos.add(c); //voy añadiendo los cursos
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    //mostrar los cursos
    
    public void mostrarCursos(){
        for(Curso c : this.cursos){
            System.out.println(c.toString());
        }
    }
    
    public ArrayList<Curso> getCursos() {
        return new ArrayList<>(cursos); // Devolver una copia de la lista
    }
    
    public void anadirCurso(Curso c){
        cursos.add(c);
    }
}
