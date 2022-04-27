/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import ejercicio9.Vehiculo;
import ejercicio9.Deportivo;
import ejercicio9.Furgoneta;
import ejercicio9.Turismo;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 34616
 */
public class Lectura {

    public static ArrayList<Vehiculo> guardarEnArrayvehiculos(File idFolder) {
        ArrayList<Vehiculo>listaVehiculos=new ArrayList<>();
        
        try {
            for (File file : idFolder.listFiles()) {
                System.out.println(file.getName());
                leerFicheroYGuardarEnArray(file, listaVehiculos);
            }
        } catch (DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
        return listaVehiculos;
    }
    
    public static void leerFicheroYGuardarEnArray(File idFichero,ArrayList<Vehiculo>listaVehiculos){
        String linea;
        String[] tokens;
        try ( Scanner datosFichero = new Scanner(idFichero, "UTF-8")) {
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(";");
                if (tokens[0].charAt(0) == '1') {
                    listaVehiculos.add(
                            new Turismo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '2') {
                    listaVehiculos.add(
                            new Deportivo(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
                if (tokens[0].charAt(0) == '3') {
                    listaVehiculos.add(
                            new Furgoneta(Integer.parseInt(tokens[3]), tokens[0], tokens[1], tokens[2]));
                }
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
