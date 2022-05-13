/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import ejercicio4.LecturaJson;
import ejercicio4.Precipitacion;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author miguel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Precipitacion> listaPrecipitaciones
                = LecturaJson.leerPrecipitaciones("precipitacionesBadajoz.json");

//        for(Precipitacion aux: listaPrecipitaciones){
//            System.out.println(aux.toString());
//        }
        Map<String, Double> mapPrecipitaciones = mapPrecipitacionPorEstacion(listaPrecipitaciones);

        System.out.println(mapPrecipitaciones);
        
        System.out.println(listaPrecipitaciones.stream().filter(p ->p.getFecha().isAfter(LocalDate.of(2017,10,9)))
                .filter(s ->s.getFecha().isBefore(LocalDate.of(2017,10,21))).count());
        
        double suma;
        System.out.println(listaPrecipitaciones.stream().filter(p ->p.getFecha().isAfter(LocalDate.of(2017,10,9)))
            .filter(s ->s.getFecha().isBefore(LocalDate.of(2017,10,21))).map(s->s.getPrecipitacion())
                .mapToDouble(Double::doubleValue).average().getAsDouble());
        
        
//        List<Double> listaDouble=listaPrecipitaciones.stream().filter(p ->p.getFecha().isAfter(LocalDate.of(2017,10,9)))
//                .filter(s ->s.getFecha().isBefore(LocalDate.of(2017,10,21))).map(s->s.getPrecipitacion()).collect(Collectors.toList());
//        
        
        
    }

    public static Map<String, Double> mapPrecipitacionPorEstacion(ArrayList<Precipitacion> lista) {
        Map<String, Double> mapPrecipitaciones = new HashMap<>();
        for (Precipitacion aux : lista) {
            if (!mapPrecipitaciones.containsKey(aux.getEstacionMeteorologica())) {
                mapPrecipitaciones.put(aux.getEstacionMeteorologica(), aux.getPrecipitacion());
            } else {
                mapPrecipitaciones.put(aux.getEstacionMeteorologica(),
                        mapPrecipitaciones.get(aux.getEstacionMeteorologica()) + aux.getPrecipitacion());
            }
        }

        return mapPrecipitaciones;
    }

}
