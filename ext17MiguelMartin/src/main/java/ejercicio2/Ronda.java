/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import ejercicio1.Naipe;
import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Ronda {
    private ArrayList<Naipe>ronda= new ArrayList<>();

    public Ronda() {
    }

    @Override
    public String toString() {
        return "Ronda{" + "ronda=" + ronda + '}';
    }

    public ArrayList<Naipe> getRonda() {
        return ronda;
    }

    public void setRonda(ArrayList<Naipe> ronda) {
        this.ronda = ronda;
    }

    


}
