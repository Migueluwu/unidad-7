/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoclase;

import jcarlos.backendjavajson.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

public class Json {

    public ArrayList<Usuario> stringToList(String json) throws JsonProcessingException {
        ObjectMapper mapeador = new ObjectMapper();

        ArrayList<Usuario> listaUsuario = mapeador.readValue(json,
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Usuario.class));
        
        return listaUsuario;
    }
    
    public Usuario stringToPojo(String json) throws JsonProcessingException {
        ObjectMapper mapeador = new ObjectMapper();

        Usuario usuario = mapeador.readValue(json,Usuario.class);
        
        return usuario;
    }
}
