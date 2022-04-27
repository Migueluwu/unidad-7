/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import ejercicio9.Vehiculo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author 34616
 */
public class Ej10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Escritura.crearCarpeta("copias");
        Escritura.copiarFicheros("Deportivo.csv", "copias/Deportivos.csv");
        Escritura.copiarFicheros("Furgoneta.csv", "copias/Furgonetas.csv");
        Escritura.copiarFicheros("Turismo.csv", "copias/Turismos.csv");
        Escritura.listarFicherosDirectorio("copias");
        
        File copia=new File("copias");
        ArrayList <Vehiculo>listaVehiculos=Lectura.guardarEnArrayvehiculos(copia);
        System.out.println(listaVehiculos.toString());
        System.out.println("----------------------------------------------");
        ordenarPorMatricula(listaVehiculos);
        System.out.println(listaVehiculos.toString());
        
        Escritura.borrarFicheros("Deportivos.csv");
        Escritura.borrarFicheros("Furgonetas.csv");
        Escritura.borrarFicheros("Turismos.csv");
        Escritura.listarFicherosDirectorio("./");
        
        
        
        Stream<Vehiculo> vehiculosBlancos = listaVehiculos.stream().filter(v -> v.getColor().equalsIgnoreCase("Blanco")).distinct().
                sorted((v1,v2)->v1.getMatricula().compareTo(v2.getMatricula()));
        for(Vehiculo aux :listaVehiculos){
            System.out.println(aux.toString());
        }
        System.out.println("-------------------");
        listaVehiculos.stream().map(v->v.getMarca()).distinct().forEach(System.out::println);
        
        System.out.println(listaVehiculos.stream().filter(v ->v.getMarca().equalsIgnoreCase("Tesla")).count());
        
        System.out.println(listaVehiculos.stream().anyMatch(v-> v.getMarca().equalsIgnoreCase("Tesla") && ( v.getColor().equalsIgnoreCase("Rojo"))));
    }
    
    
    
     private static void ordenarPorMatricula(ArrayList<Vehiculo>listaVehiculos){
       Collections.sort(listaVehiculos,
               (Vehiculo v1, Vehiculo v2)->v1.getMatricula().compareTo(v2.getMatricula()));
    }
     
    
}
