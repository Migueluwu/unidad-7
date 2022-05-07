/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 34616
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaApps {  //No entiendo esto
    @XmlElementWrapper(name = "listaApps")

    // XmlElement establece el nombre de los elementos
    // Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "App")


    
    ArrayList<App>listaApps;

    public ListaApps() {
    }

    public ArrayList<App> getListaApps() {
        return listaApps;
    }
    
    public ListaApps(ArrayList<App> listaApps) {
        this.listaApps = listaApps;
    }
}
