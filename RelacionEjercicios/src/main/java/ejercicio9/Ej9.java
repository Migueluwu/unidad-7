/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9;

import ejercicio7.Deportivo;
import static ejercicio7.Ej7.ordenarPorMarca;
import ejercicio7.Furgoneta;
import ejercicio7.Turismo;
import ejercicio7.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Ej9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String idFichero1 = "Deportivo.txt";
        String idFichero2 = "Turismo.txt";
        String idFichero3 = "Furgoneta.txt";

        String idFichero = "ejercicio4.txt";
        System.out.println("Leyendo el fichero: " + idFichero);
        ArrayList<String> listaVehiculos = new ArrayList<>();
        ArrayList<Deportivo> listaDeportivo = new ArrayList<>();
        ArrayList<Turismo> listaTurismo = new ArrayList<>();
        ArrayList<Furgoneta> listaFurgoneta = new ArrayList<>();
        System.out.println(listaTurismo);
        System.out.println("------------------");
        System.out.println(listaDeportivo);
        System.out.println("------------------");
        System.out.println(listaFurgoneta);

    }

    private static void leerCSVVehiculos(String idFichero,ArrayList<Vehiculo>listaVehiculos,
            ArrayList<Turismo> listaTurismo,ArrayList<Deportivo> listaDeportivo,
            ArrayList<Furgoneta> listaFurgoneta) throws FileNotFoundException {
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                listaVehiculos.add(linea);
            }
            for (String aux : listaVehiculos) {
                tokens = aux.split(":");
                if (tokens[0].charAt(0) == '1') {
                    listaTurismo.add(
                            new Turismo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '2') {
                    listaDeportivo.add(
                            new Deportivo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '3') {
                    listaFurgoneta.add(
                            new Furgoneta(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }

            }

        }

    }
