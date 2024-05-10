
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
public class FicheroDepartamentoCSV {
    private String nombreFicheroCSVLeer;
    private String nombreFicheroEscribir;
    private ArrayList<Departamento> departamentos;
    
    public FicheroDepartamentoCSV(String nombreFicheroCSVLeer, String nombreFicheroEscribir, ArrayList<Departamento> departamentos) {
        this.nombreFicheroCSVLeer = nombreFicheroCSVLeer;
        this.nombreFicheroEscribir = nombreFicheroEscribir;
        if(departamentos == null){
            this.departamentos = new ArrayList<Departamento>();
        }else{
        this.departamentos = departamentos;}
    }
    //recuperar los datos
    
    public void leerFicheroDepartamentosCSV(){
        FileReader fr;
        try { 
            fr = new FileReader(this.nombreFicheroCSVLeer);
            String linea ="";
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) !=null){
                String[] datoslinea =linea.split(","); 
                int id_departamento= Integer.parseInt(datoslinea[0]);
                String nombre = datoslinea[1]; 
                int jefe = Integer.parseInt(datoslinea[2]);
                String codigo_departamento = datoslinea[3];                
                Departamento d = new Departamento(id_departamento, nombre, jefe, codigo_departamento);
                this.departamentos.add(d); 
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    //mostrar los cursos
    
    public void mostrarDepartamentos(){
        for(Departamento c : this.departamentos){
            System.out.println(c.toString());
        }
    }
    //escribimos en el fichero

    public ArrayList<Departamento> getDepartamentos() {
        return new ArrayList<>(departamentos); 
    }
    
    public void anadirDepartamento(Departamento d){
        departamentos.add(d);
    }
}
