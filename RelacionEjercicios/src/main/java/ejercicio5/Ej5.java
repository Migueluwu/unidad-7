/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String idFichero = "array.txt";
        String linea;
        String []tokens;
        int suma;
        int sumaTotal=0;
        System.out.println("Leyendo el fichero: " + idFichero);
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                suma=0;
                linea = datosFichero.nextLine();
                tokens= linea.split("\t");
                for(String aux :tokens){
                    suma=suma+Integer.parseInt(aux);
                    
                }
                System.out.println(suma);
                sumaTotal+=suma;
            }
            System.out.println("Suma Total: "+sumaTotal);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}