/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Baraja {
    private ArrayList<Naipe> baraja;

    public Baraja() {
        baraja=new ArrayList<>();
        for(int i=2;i<15;i++){
            baraja.add(new Naipe(i, "P"));
        }
        for(int i=2;i<15;i++){
            baraja.add(new Naipe(i, "D"));
        }
        for(int i=2;i<15;i++){
            baraja.add(new Naipe(i, "T"));
        }
        for(int i=2;i<15;i++){
            baraja.add(new Naipe(i, "C"));
        }
    }

    public ArrayList<Naipe> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Naipe> baraja) {
        this.baraja = baraja;
    }

    @Override
    public String toString() {
        return "Baraja{" + "baraja=" + baraja + '}';
    }
    
}
