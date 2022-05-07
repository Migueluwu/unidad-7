/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author 34616
 */
public class Ej11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, IOException {
        // TODO code application logic here
        ArrayList<App> listaApp=new ArrayList<>();
        for(int i=0;i<50;i++){
            listaApp.add(new App());
        }
        for(App aux:listaApp){
            System.out.println(aux.toString());
        }
        Escritura.crearCarpeta("appstxt");
        Escritura.escrbirFicheroTxt(listaApp, "./appstxt/aplicacionestxt.txt");
        
        Escritura.crearCarpeta("appsxml");
        Escritura.escribirFicheroXml(listaApp, "./appsxml/aplicacionesxml.xml");
        
        Escritura.crearCarpeta("appsjson");
        Escritura.escribirFicheroJson(listaApp, "./appsjson/aplicacionesxml.json");
        
        Escritura.crearCarpeta("copias");
        Escritura.copiarFicheros("appstxt/aplicacionestxt.txt", "copias/aplicacionestxt.txt");
        Escritura.copiarFicheros("appsxml/aplicacionesxml.xml", "copias/aplicacionesxml.xml");
        Escritura.copiarFicheros("appsjson/aplicacionesxml.json", "copias/aplicacionesxml.json");
        
        Escritura.crearCarpeta("aplicaciones");
        Escritura.escribirAppsEnFicheroTxt(listaApp);
    }
    
}
