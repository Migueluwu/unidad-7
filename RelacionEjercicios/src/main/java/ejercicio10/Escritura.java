/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author 34616
 */
public class Escritura {

    public static void crearCarpeta(String nombreCarpeta) {
        Path directorio = Paths.get(nombreCarpeta);

        try {
            if (!Files.exists(directorio)) {
                Files.createDirectory(directorio);
                System.out.println("Se ha creado el directorio");
            }

        } catch (AccessDeniedException ade) {
            System.out.println("No tienes permisos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        try {
            if (!Files.exists(destino)) {
                Files.copy(origen, destino);
                System.out.println("Se han copiado los archivos");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarFicherosDirectorio(String ruta) {
        Path directorio = Paths.get(ruta);

        try {
            Files.list(directorio).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void borrarFicheros(String ruta) {
        Path fichero = Paths.get(ruta);

        if (Files.exists(fichero)) {
            try {
                Files.delete(fichero);
                System.out.println("Se ha borrado" + ruta);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

}
