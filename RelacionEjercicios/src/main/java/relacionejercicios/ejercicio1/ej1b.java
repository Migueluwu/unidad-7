/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejercicios.ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author miguel
 */
public class ej1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String idFichero = "array.txt";
        String tmp;
        int fila=4;
        int columna=4;
        // Array a escribir
        int matrizNumeros[][] = new int[fila][columna];

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < matrizNumeros.length; i++) {
                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf((100*(i+1))+j);
                    // Si es el último de la fila no pone la coma
                    if (j == matrizNumeros[i].length - 1) {
                        // Usamos metodo write() para escribir en el buffer
                        flujo.write(tmp);
                        
                    } else {
                        flujo.write(tmp + "\t");
                        
                    }
                }

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
