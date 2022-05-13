/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author miguel
 */
public class Naipe {
    private int numero;
    private String palo;

    public Naipe() {
    }

    public Naipe(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        String numeroTexto;
        String paloTexto="";
        switch (numero) {
            case 14:
                numeroTexto="AS";
                break;
            case 11:
                numeroTexto="Jack";
                break;
            case 12:
                numeroTexto="Queen";
                break;
            case 13:
                numeroTexto="King";
                break;
            default:
                numeroTexto=Integer.toString(numero);
                break;
        }
        
        switch (palo) {
            case "P":
                paloTexto="picas";
                break;
            case "D":
                paloTexto="diamantes";
                break;
            case "T":
                paloTexto="treboles";
                break;
            case "C":
                paloTexto="corazones";
                break;
            default:
                break;
        }
        
        
        
        return "Naipe{" + "numero=" + numeroTexto + ", palo=" + paloTexto + '}';
    }


}
