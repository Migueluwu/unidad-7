/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import ejercicio1.Naipe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Lectura {
    public static ArrayList<Ronda> leerFichero(String idFichero){
        String[] tokens;
        String linea;
        ArrayList<Ronda> partida=new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(" ");
                //Primer naipe
                
                Ronda ronda=new Ronda();
                
                ronda.getRonda().add(new Naipe(convertirLetraNumero(tokens[0]), tokens[1]));
                ronda.getRonda().add(new Naipe(convertirLetraNumero(tokens[2]), tokens[3]));
                ronda.getRonda().add(new Naipe(convertirLetraNumero(tokens[4]), tokens[5]));
                ronda.getRonda().add(new Naipe(convertirLetraNumero(tokens[6]), tokens[7]));
                
                
                
                partida.add(ronda);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return partida;
    }
    public static int convertirLetraNumero(String letra){
        if(letra.equals("A")){
            return 14;
        }else if(letra.equals("J")){
            return 11;
        }else if(letra.equals("Q")){
            return 12;
        }else if(letra.equals("K")){
            return 13;
        }else{
            return Integer.parseInt(letra);
        }
    }
}
