/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoclase;

import jcarlos.backendjavajson.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Programa {

    public static void main(String[] args) throws JsonProcessingException {
        
        String url1 = "https://jsonplaceholder.typicode.com/users";
        
        mostrarUsuario(url1);
        
    }
    

    public static void mostrarUsuario(String url) {       
        String respuesta = "";
        ConexionHTTP conexion = new ConexionHTTP();
        Json mapeador = new Json();

        try {
            respuesta = conexion.peticionHttpGet(url);
            ArrayList<Usuario> listaUsuario = mapeador.stringToList(respuesta);
            listaUsuario.forEach(l -> System.out.println(l.toString()));
        } catch (Exception e) {
            // Manejar excepción
            System.out.println("Error durante la conexión HTTP");
            e.printStackTrace();
        }
    }

}
