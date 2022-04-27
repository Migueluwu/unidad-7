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
public class Turismo extends Vehiculo{
    private int cilindradas;

    public Turismo(int cilindradas, String matricula, String marca, String color) {
        super(matricula, marca, color);
        this.cilindradas = cilindradas;
    }

    public Turismo() {
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return super.toString()+ ":" + cilindradas ;
    }
    
}
