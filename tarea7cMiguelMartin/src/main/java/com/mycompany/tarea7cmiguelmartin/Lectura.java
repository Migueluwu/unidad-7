/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7cmiguelmartin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 34616
 */
public class Lectura {
    public static void rellenarArrayHorario(ArrayList<HoraEscolar> horario, String idFichero){
         String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                linea=quitarComillasYEspacio(linea);
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                
                horario.add(new HoraEscolar(tokens[1],tokens[2],tokens[3],tokens[4],Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6])));
                
//                horario.add(new HoraEscolar(quitarComillas(tokens[1]),quitarComillas(tokens[2]),quitarComillas(tokens[3]),
//                        Integer.parseInt(quitarComillas(tokens[4])),Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
 
     public static String quitarComillasYEspacio(String linea){
        String lineaSin="";
        for(int i=0;i<linea.length();i++){
            if(!(linea.charAt(i)=='"'||linea.charAt(i)==' ')){
                lineaSin=lineaSin+linea.charAt(i);
            }
        }
        return lineaSin;
    }
}
