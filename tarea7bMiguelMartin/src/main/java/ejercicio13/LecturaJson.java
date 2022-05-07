/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ejercicio11.App;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 34616
 */
public class LecturaJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        leerJson("appsJson/aplicacionesxml.json");
    }
    private static void leerJson(String idFichero) throws IOException{
         ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<App> lista = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));
        System.out.println("---- Lista de Apps ----");
        for (App app : lista) {
            System.out.println(app);
        }
    }
}
