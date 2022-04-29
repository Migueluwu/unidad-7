/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package tareaclase7a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author miguel
 */
public class Tarea7A {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String idFichero = "RelPerCen.csv";
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        leerFichero(idFichero, listaProfesores);
        listaProfesores.stream().forEach(System.out::println);
        System.out.println("Numero de profesores: " + listaProfesores.size());
        System.out.println("---------------------------------------------------------------------------------");
        HashMap<String, Integer> mapAsignaturaProfesores = new HashMap<>();
        rellenarMap(listaProfesores, mapAsignaturaProfesores);
//        System.out.println(mapAsignaturaProfesores);
        rellenarFicheroMap(mapAsignaturaProfesores);
        rellenarFicheroProfesores(listaProfesores);
        // Busca en la lista si hay alguien que se llame así
        String nombre="Maud Brigitte Marie";
        System.out.println(listaProfesores.stream().anyMatch(p-> p.getNombre()
                .equalsIgnoreCase("Maud Brigitte Marie"))?"En la lista hay alguien que se llama así"
                :"En la lista no hay nadie que se llame así");
//        System.out.println((Utils.buscarPorNombre(listaProfesores,
//                "Maud Brigitte Marie"))?"En la lista hay alguien que se llama así":"En la lista no hay nadie que se llame así");
        System.out.println("---------------------------------------------------------------------------------");
        // Cuenta cuantos coordinadores hay en la lista de esa asignatura
        
        System.out.println("el numero de coordinadores que hay de esta asignatura es "+
                listaProfesores.stream().filter(p->p.getPuesto().
                        equalsIgnoreCase("Matemáticas P.E.S.")).count());
//        System.out.println("el numero de coordinadores que hay de esta asignatura es "+ Utils.contarCoordinadoresPorAsignatura(listaProfesores, "Matemáticas P.E.S."));
        System.out.println("---------------------------------------------------------------------------------");
        //devuelve una lista de profesores ordenada por nombre que tienen la letra pedida en el dni
        
        List<Profesor>listaProfesoresConMismaLetra=listaProfesores.stream().filter(p->p.getDni().contains("A"))
                .sorted((p1,p2)->p1.getNombre().compareTo(p2.getNombre())).collect(Collectors.toList());
        listaProfesoresConMismaLetra.stream().forEach(System.out::println);
//        ArrayList<Profesor>listaProfesoresConMismaLetra=Utils.listaProfesoresConMismoDni(listaProfesores, 'A');
//        System.out.println(listaProfesoresConMismaLetra.toString());
        System.out.println("---------------------------------------------------------------------------------");
        //El metodo devuelve un ArrrayList ordenado inversamente por el dni de los profesores que han tomado posesion el mismo dia indicado 
        List<Profesor>listaProfesoresMismaPosesion=listaProfesores.stream().
                filter(p->p.getFechaInicio().equals(LocalDate.of(2020, 9, 1))).
                sorted((p1,p2)->p2.getDni().compareTo(p1.getDni())).collect(Collectors.toList());
        listaProfesoresMismaPosesion.stream().forEach(System.out::println);
//        ArrayList<Profesor>listaProfesoresMismaPosesion=Utils.listaProfesoresMismaPosesion(listaProfesores, LocalDate.of(2020, 9, 1));
//        System.out.println(listaProfesoresMismaPosesion.toString());

    }

    public static void leerFichero(String idFichero, ArrayList<Profesor> listaProfesores) {
        String linea;
        String[] tokens;
        System.out.println("Leyendo el fichero: " + idFichero);
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                listaProfesores.add(new Profesor(
                        tokens[0].concat(tokens[1]).substring(1,(tokens[0].concat(tokens[1])).length()-1),
                        tokens[2], tokens[3],fechaFormateada(tokens[4]), fechaFormateada(tokens[5]),
                        tokens[6], devolverBooleano(tokens[7]), devolverBooleano(tokens[8])));

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static LocalDate fechaFormateada(String fecha) {
        if (fecha.isBlank()) {
            return null;
        }
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static boolean devolverBooleano(String token) {

        return !token.equalsIgnoreCase("no");

    }

    public static void rellenarMap(ArrayList<Profesor> listaProfesores,
            HashMap<String, Integer> mapAsignaturas) {

        for (Profesor profesor : listaProfesores) {
            if (mapAsignaturas.containsKey(profesor.getPuesto())) {
                mapAsignaturas.put(profesor.getPuesto(), mapAsignaturas.get(profesor.getPuesto()) + 1);
            } else {
                mapAsignaturas.put(profesor.getPuesto(), 1);
            }
        }
    }

    public static void rellenarFicheroMap(HashMap<String, Integer> mapAsignaturas) throws IOException {
        String idFichero = "profesoresPorDepartamento.csv";
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Map.Entry<String, Integer> entry : mapAsignaturas.entrySet()) {
                flujo.write(entry.getKey() + "\t," + entry.getValue());
                flujo.newLine();
            }

            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rellenarFicheroProfesores(ArrayList<Profesor> listaProfesores) throws IOException {
        String idFichero = "profesoresQueHanTrabajao.csv";
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Profesor profesor : listaProfesores) {
                LocalDate fechaFin;
                if(profesor.getFechaFin()==null){
                    fechaFin=LocalDate.now();
                }else{
                    fechaFin=profesor.getFechaFin();
                }
                if (ChronoUnit.DAYS.between(profesor.getFechaInicio(), fechaFin) >= 100) {
                    flujo.write(profesor.getNombre()+"\t"+profesor.getDni()+"\t"+profesor.getPuesto()+"\t"+profesor.getFechaInicio()+"\t"+profesor.getFechaFin());
                    if(profesor.isEvaluador()){
                        flujo.write(" \t Sí \t");
                    }else{
                        flujo.write("No \t");    
                    }
                    if(profesor.isCoordinador()){
                        flujo.write("Sí");
                    }else{
                        flujo.write("No");

                    }
                    flujo.newLine();
                }
            }
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

