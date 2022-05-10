/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Map;

/**
 *
 * @author 34616
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String,String>nombres=LecturaCSV.leerFichero("nombresModulos.csv");
        
        nombres.forEach((k,v) -> System.out.println(k + ": " + v));
        
    }
    
}
