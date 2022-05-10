/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 34616
 */
public class RegistroJSON {
    @JsonProperty("Alumno/a") 
    private String alumnoA;
    @JsonProperty("OACV") 
    private String oACV;
    @JsonProperty("EA") 
    private String eA;
    @JsonProperty("TII") 
    private String tII;
    @JsonProperty("TC") 
    private String tC;
    @JsonProperty("ING") 
    private String iNG;
    @JsonProperty("FOL") 
    private String fOL;
    @JsonProperty("CEAC") 
    private String cEAC;

    public RegistroJSON() {
    }

    public RegistroJSON(String alumnoA, String oACV, String eA, String tII, String tC, String iNG, String fOL, String cEAC) {
        this.alumnoA = alumnoA;
        this.oACV = oACV;
        this.eA = eA;
        this.tII = tII;
        this.tC = tC;
        this.iNG = iNG;
        this.fOL = fOL;
        this.cEAC = cEAC;
    }

    public String getAlumnoA() {
        return alumnoA;
    }

    public void setAlumnoA(String alumnoA) {
        this.alumnoA = alumnoA;
    }

    public String getoACV() {
        return oACV;
    }

    public void setoACV(String oACV) {
        this.oACV = oACV;
    }

    public String geteA() {
        return eA;
    }

    public void seteA(String eA) {
        this.eA = eA;
    }

    public String gettII() {
        return tII;
    }

    public void settII(String tII) {
        this.tII = tII;
    }

    public String gettC() {
        return tC;
    }

    public void settC(String tC) {
        this.tC = tC;
    }

    public String getiNG() {
        return iNG;
    }

    public void setiNG(String iNG) {
        this.iNG = iNG;
    }

    public String getfOL() {
        return fOL;
    }

    public void setfOL(String fOL) {
        this.fOL = fOL;
    }

    public String getcEAC() {
        return cEAC;
    }

    public void setcEAC(String cEAC) {
        this.cEAC = cEAC;
    }

    @Override
    public String toString() {
        return  "alumnoA=" + alumnoA + ", oACV=" + oACV + ", eA=" + eA + ", tII=" +
                tII + ", tC=" + tC + ", iNG=" + iNG + ", fOL=" + fOL + ", cEAC=" + cEAC;
    }
}
