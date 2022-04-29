/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String idFichero = "ejercicio4.txt";
        System.out.println("Leyendo el fichero: " + idFichero);
        ArrayList<String> listaVehiculos = new ArrayList<>();
        ArrayList<Vehiculo> lista = new ArrayList<>();
        String linea;
        String[] tokens;

        int contador = 0;
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                listaVehiculos.add(linea);
            }
            for (String aux : listaVehiculos) {
                tokens = aux.split(":");
                if (tokens[0].charAt(0) == '1') {
                    lista.add(
                            new Turismo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '2') {
                    lista.add(
                            new Deportivo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '3') {
                    lista.add(
                            new Furgoneta(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }

            }
            ordenarPorMarca(lista);
            System.out.println(lista.toString());
        }

    }

    public static void ordenarPorMarca(ArrayList<Vehiculo> lista) {
        Collections.sort(lista,
                (Vehiculo v1, Vehiculo v2) -> v1.getMarca().compareTo(v2.getMarca()));

        
    }

}
