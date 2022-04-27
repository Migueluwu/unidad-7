/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        String idFichero1 = "Turismo.csv";
        String idFichero2 = "Deportivo.csv";
        String idFichero3 = "Furgoneta.csv";

        
        String idFichero = "ejercicio4.txt";
               
        ArrayList<Vehiculo> listaTurismo = new ArrayList<>();
        ArrayList<Vehiculo> listaDeportivo = new ArrayList<>();
        ArrayList<Vehiculo> listaFurgoneta = new ArrayList<>();
        
        leerCSV4(idFichero, listaTurismo, listaDeportivo, listaFurgoneta);
        escribirTipoVehiculos(listaTurismo, idFichero1);
        escribirTipoVehiculos(listaDeportivo, idFichero2);
        escribirTipoVehiculos(listaFurgoneta, idFichero3);        
    }
    
    private static void leerCSV4(String idFichero, ArrayList<Vehiculo> listaTurismo,
            ArrayList<Vehiculo> listaDeportivo, ArrayList<Vehiculo> listaFurgoneta)
            throws FileNotFoundException {
        String linea;
        String[] tokens;
        ArrayList<String> listaVehiculos = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero); 
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void escribirTipoVehiculos (ArrayList<Vehiculo>listaVehiculo, String idFichero){
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i <listaVehiculo.size() ; i++) {
               if(listaVehiculo.get(i)instanceof Turismo){
                   flujo.write(listaVehiculo.get(i).getMatricula()+";"
                       +listaVehiculo.get(i).getMarca()+";"+
                       listaVehiculo.get(i).getColor()+";"+((Turismo)listaVehiculo.get(i)).getCilindradas());
               }else if(listaVehiculo.get(i)instanceof Deportivo){
                   flujo.write(listaVehiculo.get(i).getMatricula()+";"
                       +listaVehiculo.get(i).getMarca()+";"+
                       listaVehiculo.get(i).getColor()+";"+((Deportivo)listaVehiculo.get(i)).getPuertas());
               }else if(listaVehiculo.get(i)instanceof Furgoneta){
                   flujo.write(listaVehiculo.get(i).getMatricula()+";"
                       +listaVehiculo.get(i).getMarca()+";"+
                       listaVehiculo.get(i).getColor()+";"+((Furgoneta)listaVehiculo.get(i)).getAsientos());
               }

                
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
}
