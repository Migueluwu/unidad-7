/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import ejercicio11.App;
import ejercicio11.ListaApps;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 34616
 */
public class LecturaXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        // TODO code application logic here
        leerFicheroXML("appsxml/aplicacionesxml.xml");
    }

    private static void leerFicheroXML(String idFichero) throws JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(ListaApps.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        ListaApps lista = (ListaApps) um.unmarshal(new File(idFichero));

        ArrayList<App> listaApps = lista.getListaApps();

        listaApps.forEach(System.out::println);
    }
}
