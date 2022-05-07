/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7cmiguelmartin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 34616
 */
public class ParteB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<HoraEscolar> horario=new ArrayList<>();
        
        Lectura.rellenarArrayHorario(horario, "hor_curso.csv");
        
        //Obtener todos los registros de 1ESOA que no son de la asignatura MUS.
        List <HoraEscolar>lista1Eso=horario.stream().filter(h ->!h.getAsignatura().equalsIgnoreCase("MUS")).filter(h ->h.getCurso().equalsIgnoreCase("1ESOA")).collect(Collectors.toList());
        lista1Eso.stream().forEach(System.out::println);
        
        System.out.println("---------------------------------");
        
        //Contar las horas que se imparten de la asignatura PROGR
        System.out.println("Horas impartidas de programacion: "+horario.stream().filter(h->h.getAsignatura().equalsIgnoreCase("PROGR")).count());
        
        System.out.println("---------------------------------");
        
        //Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, ordenadas en orden inverso al orden alfabético.
        List <String> listaIniciales=horario.stream().filter(h ->h.getAsignatura().equalsIgnoreCase("REL"))
                .map(h-> h.getProfesor()).distinct().sorted((h1,h2)-> h2.compareTo(h1)).collect(Collectors.toList());
        //listaIniciales.stream().forEach(System.out::println);
        
        System.out.println("---------------------------------");
        
        //Obtener en una lista las aulas donde imparte clase el profesor "JFV"
        List <String> listaClasesJFV=horario.stream().filter(h->h.getProfesor().equalsIgnoreCase("JFV")).map(h -> h.getAula()).distinct().collect(Collectors.toList());
        listaClasesJFV.forEach(System.out::println);
        
        System.out.println("---------------------------------");
        
        //Contar el número de asignaturas distintas que hay
        System.out.println("Numero de asginaturas distintas: "+horario.stream().map(h ->h.getAsignatura()).distinct().count());
        
        System.out.println("---------------------------------");
        
        //Contar el total de horas que se imparten a última hora de la mañana.
        System.out.println("Numero de horas impartidas a ultima hora: "+
                horario.stream().filter(h->h.getHoraDia()==7).count());
        
        System.out.println("---------------------------------");
        
        //Mostrar por consola los profesores que tienen clase a primera hora de la mañana.
        horario.stream().filter(h->h.getHoraDia()==1).map(h-> h.getProfesor()).distinct().forEach(System.out::println);
        
        
    }
    
}
