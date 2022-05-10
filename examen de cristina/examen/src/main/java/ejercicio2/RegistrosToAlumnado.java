/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Map;

/**
 *
 * @author 34616
 */
public class RegistrosToAlumnado {
    public static Alumnado RegistroAlumnado(RegistroJSON alumno){
        Alumnado notasAlumno=new Alumnado();
        notasAlumno.setNombre(alumno.getAlumnoA());
        
        notasAlumno.getNotas().put("OAVC", alumno.getoACV());
        notasAlumno.getNotas().put("EA", alumno.geteA());
        notasAlumno.getNotas().put("TII", alumno.gettII());
        notasAlumno.getNotas().put("TC", alumno.gettC());
        notasAlumno.getNotas().put("ING", alumno.getiNG());
        notasAlumno.getNotas().put("FOL", alumno.getfOL());
        notasAlumno.getNotas().put("CEAC", alumno.getcEAC());
        
        return notasAlumno;
    }
}
