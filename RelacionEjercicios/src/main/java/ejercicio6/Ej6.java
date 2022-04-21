/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String idFichero = "ejercicio3.txt";
        System.out.println("Leyendo el fichero: " + idFichero);
        String linea;
        String[] tokens;
        int posicion = 0;
        int numlinea = 0;
        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            while (datosFichero.hasNextLine()) {
                posicion = -1;
                linea = datosFichero.nextLine();
                tokens = linea.split(";");
                if (linea.contains("w") || linea.contains("W")) {
                    for (int i = 0; i < tokens.length - 2; i++) {

                        if (tokens[i].equalsIgnoreCase("w") && tokens[i + 1].equalsIgnoreCase("e")
                                && tokens[i + 2].equalsIgnoreCase("b")) {
                            posicion = i;
                        }
                    }
                }
                System.out.println("Numero de linea " + numlinea + " en la posicion " + posicion);
                numlinea++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
