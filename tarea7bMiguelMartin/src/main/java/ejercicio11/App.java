/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author 34616
 */
public class App {
    private int codigo,numDescargas;
    private String nombre,descripcion;
    private double tamanyo;
    private static int contador=0; 
    final private static double tamMin=100;
    final private static double tamMax=1024;
    private static String[] descripciones={"app de calculadora",
        "app de contactos","app de calendario","app de citas","app de juego",
        "app de musica","app de redes sociales","app de imagenes",
        "app de edicion","app de imagenes"};
    public App() {
        Random ale =new Random();
        this.codigo = contador;
        contador++;
        this.numDescargas = numDescargas;
        this.nombre = "app"+codigo+RandomStringUtils.randomAlphabetic(1);
        this.descripcion = descripciones[ale.nextInt(descripciones.length)];
        this.tamanyo = ale.doubles(1, tamMin, tamMax).max().getAsDouble();// no lo entiendo
        this.numDescargas=ale.ints(1,0,50000).max().getAsInt();// no lo entiendo
       
    }

    public App(int codigo, int numDescargas, String nombre, String descripcion, double tamanyo) {
        this.codigo = codigo;
        this.numDescargas = numDescargas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanyo = tamanyo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(double tamanyo) {
        this.tamanyo = tamanyo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        App.contador = contador;
    }

    public static String[] getDescripciones() {
        return descripciones;
    }

    public static void setDescripciones(String[] descripciones) {
        App.descripciones = descripciones;
    }

    @Override
    public String toString() {
        return  codigo + ";"  + nombre + ";" + descripcion + ";" + tamanyo +";" +numDescargas ;
    }
    
}
