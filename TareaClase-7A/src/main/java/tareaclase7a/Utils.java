/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaclase7a;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 34616
 */
public class Utils {

    public static boolean buscarPorNombre(ArrayList<Profesor> listaProfesores, String nombre) {
        // No se puede hacer contais porque no esta implementado la clase equals
        String[] nombreCompleto;
        for (Profesor aux : listaProfesores) {
            nombreCompleto = aux.getNombre().split(" ");
            if (Utils.concatenarNombre(nombreCompleto).equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private static String concatenarNombre(String[] nombre) { //Por si el nombre es compuesto puede concatenar hasta 4 palabras
       
        String aux = nombre[2];
        for (int i = 3; i < nombre.length; i++) {
            aux = aux.concat(" " + nombre[i]);
        }
        return aux;
    }
    
    public static int contarCoordinadoresPorAsignatura(ArrayList<Profesor> listaProfesores, String asigantura) {
        int contador=0;
        for(Profesor profesor :listaProfesores){
            if(profesor.getPuesto().equals(asigantura)&& profesor.isCoordinador()){
                contador++;
            }
        }
        return contador;
    }
    
    
    public static ArrayList<Profesor> listaProfesoresConMismoDni(ArrayList<Profesor> listaProfesores, char letradni) {
        ArrayList<Profesor>listaProfesoresDni=new ArrayList<>();
        for(Profesor profesor:listaProfesores){
            if(profesor.getDni().contains(String.valueOf(letradni))){
                listaProfesoresDni.add(profesor);
            }
        }
        Utils.ordenarPorNombre(listaProfesores);
        return listaProfesoresDni;
    }
    
    private static void ordenarPorNombre(ArrayList<Profesor>listaProfesores){
        Collections.sort(listaProfesores,(Profesor p1, Profesor p2)->p1.getNombre().compareTo(p2.getNombre()));
    }
    public static ArrayList<Profesor>listaProfesoresMismaPosesion(ArrayList<Profesor>listaProfesores,LocalDate fecha){
        ArrayList<Profesor>listaProfesoresMismaFecha=new ArrayList<>();
        for(Profesor profesor :listaProfesores){
            if(profesor.getFechaInicio().isEqual(fecha)){
                listaProfesoresMismaFecha.add(profesor);
            }
        }
        Utils.ordenarPorDniInverso(listaProfesoresMismaFecha);
        return listaProfesoresMismaFecha;
    }
    
    private static void ordenarPorDniInverso(ArrayList<Profesor>listaProfesores){
        Collections.sort(listaProfesores,(Profesor p1, Profesor p2)->p1.getDni().compareTo(p2.getDni()));
        Collections.reverse(listaProfesores);
    }
}
    