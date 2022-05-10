/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import ejercicio1.LecturaCSV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author 34616
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Map<String,String>nombres=LecturaCSV.leerFichero("nombresModulos.csv");
        ArrayList<RegistroJSON> calificaciones=LecturaJson.leerFicheroJSON("calificacionesGrupo.json");
        for(RegistroJSON aux: calificaciones){
            System.out.println(aux.toString());
        }
        ArrayList<Alumnado>listaAlumnado=new ArrayList<>();
        for(RegistroJSON aux: calificaciones){
            listaAlumnado.add(RegistrosToAlumnado.RegistroAlumnado(aux));
        }
        for(Alumnado aux: listaAlumnado){
            System.out.println(aux);
        }
    }
    
}
