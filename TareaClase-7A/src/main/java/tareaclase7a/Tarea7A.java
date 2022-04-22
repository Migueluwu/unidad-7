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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Tarea7A {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String idFichero = "RelPerCen.csv";
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        leerFichero(idFichero, listaProfesores);
//        System.out.println(listaProfesores.toString());
//        System.out.println("Numero de profesores: " + listaProfesores.size());
        HashMap<String, Integer> mapAsignaturaProfesores = new HashMap<>();
        rellenarMap(listaProfesores, mapAsignaturaProfesores);
//        System.out.println(mapAsignaturaProfesores);
        rellenarFichero(mapAsignaturaProfesores);
    }

    public static void leerFichero(String idFichero, ArrayList<Profesor> listaProfesores) {
        String linea;
        String[] tokens;
        System.out.println("Leyendo el fichero: " + idFichero);
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                listaProfesores.add(new Profesor(tokens[0].concat(tokens[1]), tokens[2], tokens[3],
                        fechaFormateada(tokens[4]), fechaFormateada(tokens[5]),
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

    public static void rellenarFichero(HashMap<String, Integer> mapAsignaturas) throws IOException {
        String idFichero = "profesoresPorDepartamento.csv";
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Map.Entry<String, Integer> entry : mapAsignaturas.entrySet()) {
                flujo.write(entry.getKey()+"\t,"+entry.getValue());
                flujo.newLine();
            }

            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
