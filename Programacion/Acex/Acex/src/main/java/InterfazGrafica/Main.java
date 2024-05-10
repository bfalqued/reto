/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazGrafica;

/**
 *
 * @author Borja
 */
public class Main {
    
    public static void main (String[] args){
        aplicacion aplicacion = new aplicacion();
        
        // Crear una instancia de Interfaz pasando la referencia de Aplicacion
        Interfaz interfaz = new Interfaz();
        aplicacion.setInterfaz(interfaz);
        interfaz.setVisible(true);
    }
}
