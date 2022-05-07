/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author 34616
 */
public class Escritura {

    public static void escrbirFicheroTxt(ArrayList<App> listaApp, String idFichero) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (App aux : listaApp) {
                flujo.write(aux.toString());

                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirFicheroXml(ArrayList<App> listaApp, String idFichero) throws JAXBException {
        ListaApps listaApps = new ListaApps(listaApp);
        JAXBContext contexto = JAXBContext.newInstance(listaApps.getClass());
        Marshaller serializador = contexto.createMarshaller();
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        serializador.marshal(listaApps, System.out);
        serializador.marshal(listaApps, new File(idFichero));
    }

    public static void escribirFicheroJson(ArrayList<App> listaApp, String idFichero) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();

        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idFichero), listaApp);
    }

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

    public static void escribirAppsEnFicheroTxt(ArrayList<App> listaApp ) {
        for (App aux : listaApp) {
            try (BufferedWriter flujo = new BufferedWriter(new FileWriter("aplicaciones/"+aux.getNombre()+".txt"))) {

                flujo.write(aux.toString());
                flujo.flush();
                System.out.println("Fichero aplicaciones " +aux.getNombre()  + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
