/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7cmiguelmartin;

/**
 *
 * @author 34616
 */
public class HoraEscolar {
    private String curso,profesor,asignatura,aula;
    private int diaSemana,horaDia;

    public HoraEscolar() {
    }

    public HoraEscolar(String curso, String profesor, String asignatura, String aula, int diaSemana, int horaDia) {
        this.curso = curso;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.aula = aula;
        this.diaSemana = diaSemana;
        this.horaDia = horaDia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(int horaDia) {
        this.horaDia = horaDia;
    }

    @Override
    public String toString() {
        return "curso=" + curso + ", profesor=" + profesor + ", asignatura=" + asignatura + ", aula=" + aula + ", diaSemana=" + diaSemana + ", horaDia=" + horaDia + '}';
    }
    
}
