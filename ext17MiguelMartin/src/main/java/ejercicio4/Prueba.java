/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Precipitacion>listaPrecipitaciones=
                LecturaJson.leerPrecipitaciones("precipitacionesBadajoz.json");
        
        for(Precipitacion aux: listaPrecipitaciones){
            System.out.println(aux.toString());
        }
    }
    
}
