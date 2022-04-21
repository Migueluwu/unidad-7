/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaclase7a;

import java.time.LocalDate;

/**
 *
 * @author miguel
 */
public class Profesor {
    private String nombre,dni,puesto,telefono;
    private LocalDate fechaInicio,fechaFin;
    private boolean evaluador, coordinador;

    public Profesor() {
    }

    public Profesor(String nombre, String dni, String puesto, LocalDate fechaInicio,
            LocalDate fechaFin, String telefono, boolean evaluador, boolean coordinador) {
        this.nombre = nombre;
        this.dni = dni;
        this.puesto = puesto;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", dni=" + dni + ", puesto=" + puesto + ", telefono=" + telefono + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", evaluador=" + evaluador + ", coordinador=" + coordinador + '}';
    }
    
}
