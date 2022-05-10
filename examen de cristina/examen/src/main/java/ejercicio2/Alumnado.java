/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;


import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author 34616
 */
public class Alumnado implements Comparable<Alumnado> {
    private String nombre;
    private Map <String,String> notas= new TreeMap<>();

    public Alumnado() {
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, String> getNotas() {
        return notas;
    }

    public void setNotas(Map<String, String> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        String texto="";
        texto=nombre+"\n";
        
        for(String incial: notas.keySet()){
            texto=texto+"["+incial+": "+notas.get(incial)+"] ";
        }
        
        return texto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnado other = (Alumnado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Alumnado o) {
        return this.nombre.compareTo(o.getNombre());
    }
    
}
