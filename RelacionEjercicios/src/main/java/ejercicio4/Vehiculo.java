
package ejercicio4;

import java.util.Random;


/**
 *
 * @author miguel
 */
public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String color;

    public Vehiculo(String matricula, String marca, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
    }

    public Vehiculo() {
        String []marcas={"Ford", "Fiat","Toyota","Tesla","Reanult"};
        Random ale=new Random();
       this.marca=marcas[ale.nextInt(marcas.length)];
                
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  matricula + ":" + marca + ":" + color;
    }
    
}
