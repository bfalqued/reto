
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DAW122
 */
public class FicheroGrupoCSV {
     private String nombreFicheroCSVLeer;
    private String nombreFicheroEscribir;
    private ArrayList<Grupo> grupos;

    public FicheroGrupoCSV(String nombreFicheroCSVLeer, String nombreFicheroEscribir, ArrayList<Grupo> grupos) {
        this.nombreFicheroCSVLeer = nombreFicheroCSVLeer;
        this.nombreFicheroEscribir = nombreFicheroEscribir;
        if(grupos == null){
            this.grupos = new ArrayList<Grupo>();
        }else{
        this.grupos = grupos;}
    }
            
    //recuperar los datos
    
    public void leerFicheroGruposCSV(){
        FileReader fr;
        try { 
            fr = new FileReader(this.nombreFicheroCSVLeer);
            String linea ="";
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) !=null){
                String[] datoslinea =linea.split(","); //le decimos que va separado por puntos y comas
                int idgrupo = Integer.parseInt(datoslinea[0]);
                String codgrupo = datoslinea[1]; //ver uso de trim()-> elimina espacios en blanco iniciales y finales
                int idcurso = Integer.parseInt(datoslinea[2]);
                int alumnos = Integer.parseInt(datoslinea[3]);
                int activo = Integer.parseInt(datoslinea[4]);// esto es una línea
                boolean ACTIVO = false;
                if(activo==1){
                    ACTIVO = true;
                }
                Grupo g = new Grupo(idgrupo, codgrupo, idcurso,alumnos,ACTIVO);
                this.grupos.add(g); //voy añadiendo los cursos
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    //mostrar los cursos
    
    public void mostrarGrupos(){
        for(Grupo g : this.grupos){
            System.out.println(g.toString());
        }
    }
    
    public ArrayList<Grupo> getGrupos() {
        return new ArrayList<>(grupos); // Devolver una copia de la lista
    }
    
    public void anadirGrupo(Grupo g){
        grupos.add(g);
    }
}
