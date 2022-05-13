/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

import ejercicio1.Naipe;
import ejercicio2.Lectura;
import ejercicio2.Ronda;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Ronda>partida=Lectura.leerFichero("escaleraColor.txt");
        
    }
    
    public static void buscarEscalera(ArrayList<Naipe>ronda){
        String palo=ronda.get(0).getPalo();
        for(Naipe naipe:ronda){
            //no me ha dao tiempo
        }
                
            
        
    }
    
}
