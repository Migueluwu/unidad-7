/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author miguel
 */
public class Deportivo extends Vehiculo{
    private int puertas;

    public Deportivo(int puertas, String matricula, String marca, String color) {
        super(matricula, marca, color);
        this.puertas = puertas;
    }

    public Deportivo() {
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return super.toString()+":" + puertas ;
    }
    
}
