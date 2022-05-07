/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7cmiguelmartin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 34616
 */
public class Escritura {
    public static void escribirProfesorJson(ArrayList<HoraEscolar> horario, String idFichero) throws IOException {
        ArrayList<HoraEscolar>horarioAux=new ArrayList<>();
        for(HoraEscolar aux: horario){
            if(aux.getProfesor().equalsIgnoreCase(idFichero)){
                horarioAux.add(aux);
            }
        }
        idFichero=idFichero.concat(".json");
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File(idFichero), horarioAux);
    }
    
     public static void escribirGrupoJson(ArrayList<HoraEscolar> horario, String idFichero) throws IOException {
        ArrayList<HoraEscolar>horarioAux=new ArrayList<>();
        for(HoraEscolar aux: horario){
            if(aux.getCurso().equalsIgnoreCase(idFichero)){
                horarioAux.add(aux);
            }
        }
        idFichero=idFichero.concat(".json");
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File(idFichero), horarioAux);
    }
}
