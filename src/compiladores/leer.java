/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Nombres: Miguel Angel Cervantes Garcia
 *          Juan Antonio Ovalle Patiño
 * Num Boletas: 2017670201
 *            2017670891
 * Fecha de Entrega: 30 / Enero/ 2019
 * Evidencia: Lectrura de caracter por caracter
 * Nombre de la maestra: Karina Rodriguez Mejia
 * Programa Academico: Ingenieria en Sistemas Computacionales
 * Unidad de Aprendizaje: Compiladores
 * @author ovall
 */
public class leer {
    int i = 0;
    String msj = "";
    public leer(){
        File archivo = new File("C:/Users/ovall/OneDrive/Documents/jsjs.txt");
        FileReader fr;
        Stream lineas;
        try{
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String lines = "";
            while( ( lines = br.readLine()) != null)
                msj+=lines;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public char caracter() {
        return msj.charAt(i++);
    }
    
    public static void main(String[] args) {
        
        leer j = new leer();
        for(int i=0; i<22;i++)
        System.out.println(j.caracter());
        
    }
    
}
