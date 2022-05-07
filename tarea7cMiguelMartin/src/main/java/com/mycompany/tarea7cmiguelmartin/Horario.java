/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7cmiguelmartin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author 34616
 */
public class Horario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<HoraEscolar> horario=new ArrayList<>();
        
        Lectura.rellenarArrayHorario(horario, "hor_curso.csv");
        
        Set<String> listaGrupos=new TreeSet<>();
        Set<String>listaProfesores=new TreeSet<>();
        rellenarListaGrupos(listaGrupos, horario);
        rellenarListaProfesores(listaProfesores, horario);
        
        Consultar(listaProfesores, listaGrupos, horario);  
        
        
    }
    
    private static void Consultar(Set<String> listaProfesores,Set<String> listaGrupos, ArrayList<HoraEscolar>horario ) throws IOException{
        String opcion;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Si desea consultar el horario de un profesor pulse A, si desea consultar el horario de un Grupo pulse B");
        opcion=sc.nextLine().toUpperCase();
        switch(opcion){
            case"A":
                System.out.println("Estas son las iniciales de los profesores: ");
                for(String aux: listaProfesores){
                    System.out.println(aux);
                }
                
                System.out.println("Teclee las inciales del profesor del que quieres generar su horario");
                opcion=sc.nextLine();
                Escritura.escribirProfesorJson(horario, opcion);
                break;
                
            case "B":
                System.out.println("Estos son todos los grupos");
                for(String aux:listaGrupos){
                    System.out.println(aux);
                }
                System.out.println("Teclee el nombre del grupo que quieres generar su horario");
                opcion=sc.nextLine();
                Escritura.escribirGrupoJson(horario, opcion);
                break;
            default:
                System.out.println("Valor Erroneo");
        }
    }
    
    
    private static void rellenarListaGrupos(Set<String>listaGrupos,ArrayList<HoraEscolar>horario){
        for(HoraEscolar hora: horario){
            listaGrupos.add(hora.getCurso());
        }
    }
    
    private static void rellenarListaProfesores(Set<String>listaProfesores,ArrayList<HoraEscolar>horario){
        for(HoraEscolar hora: horario){
            listaProfesores.add(hora.getProfesor());
        }
    }
    
}
