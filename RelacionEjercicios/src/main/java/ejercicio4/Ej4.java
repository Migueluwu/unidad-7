/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String idFichero = "ejercicio4.txt";
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Deportivo(4,"1233gfgf","Tesla","Rojo"));
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Deportivo());
        listaVehiculos.add(new Turismo(65,"345345yjyj","Seat","Azul"));
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Turismo());
        listaVehiculos.add(new Furgoneta(7,"987lolo","Toyota","verde"));
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        listaVehiculos.add(new Furgoneta());
        String tmp;
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for(int i=0;i<listaVehiculos.size();i++){
                tmp="";
                if(listaVehiculos.get(i) instanceof Deportivo){
                    tmp="2-";
                }else if(listaVehiculos.get(i) instanceof Turismo){
                    tmp="1-";
                }else if(listaVehiculos.get(i) instanceof Furgoneta){
                    tmp="3-";
                }
                
                tmp=tmp+listaVehiculos.get(i).toString();
                flujo.write(tmp);
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
