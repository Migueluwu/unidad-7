/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author 34616
 */
public class LecturaCSV {
    public static Map<String,String> leerFichero(String idFichero){
        Map<String,String> nombre=new TreeMap<>();
        System.out.println("Leyendo el fichero: " + idFichero);
        
        String[] tokens;
        String linea;
        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                nombre.put(tokens[0], tokens[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return nombre;
    }
}
