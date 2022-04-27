/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9;

import ejercicio7.*;
import ejercicio4.*;

/**
 *
 * @author miguel
 */
public class Furgoneta extends Vehiculo{
    private int asientos;

    public Furgoneta(int asientos, String matricula, String marca, String color) {
        super(matricula, marca, color);
        this.asientos = asientos;
    }

    

    public Furgoneta() {
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return super.toString()+ ":" + asientos;
    }

    
}
