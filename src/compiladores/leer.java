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

/**
 * Nombres: Miguel Angel Cervantes Garcia
 *          Juan Antonio Ovalle Patiño
 * Num Boletas: 2017670201
 *            2017670891
 * Fecha de Entrega: 1)30 / Enero / 2019
 *                   2)6 / Febrero / 2019
 * Evidencia: 1)Lectrura de caracter por caracter
 *            2)Forma variables y nuemros con punto decimal
 * Nombre de la maestra: Karina Rodriguez Mejia
 * Programa Academico: Ingenieria en Sistemas Computacionales
 * Unidad de Aprendizaje: Compiladores
 * @author ovall
 */

public class leer {
    
    public int i = 0;
    public String msj = "";
    
    public leer(){
        String cadena;
        File archivo = new File("jsjs.txt");
        FileReader fr;
        try{
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //Guarda en un arreglo lo que hay en cada linea del archivo
            while( (cadena = br.readLine()) != null)
                msj += cadena+"\n"; 
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public char caracter() {
        try {
            return msj.charAt(i++);
        } catch (Exception e) {
            return ' ';
        }
    }
    
    public String formarVariable(){
        //([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])* 
        char x =  caracter();
        if((x > 64 && x < 91) || (x > 96 && x <123))
            //El caracter es una letra
            return formarCadena(x);
        else if((x > 47 && x < 58))
            //El caracter es un numero
            return formarNumero(x);
        else
            return ""+x;
    }
    
    public String formarCadena(char x){
        String cadena = ""+x;
        int z = x;
        while((z>64 && z<91) || (z>96 && z<123) || (z>47 && z<58)){
            x = caracter();
            z = x;
            if((z>64 && z<91) || (z>96 && z<123) || (z>47 && z<58))
                cadena+= ""+x;
            else{
                i--;
                return cadena;
            }
        }
        return cadena;
    }
    
    public String formarNumero(char x){
        String nuemro = ""+x;
        int z = x, punto = 0;
        while( (punto < 2) || (z > 47 && z < 58) ){
            x = caracter();
            z = x;
            if(x == '.' && punto == 0){
                punto++;
                nuemro+= ""+x;
            }
            else if(x == '.' && punto != 0)
                return nuemro;
            else if(z > 47 && z < 58)
                nuemro+= ""+x;
            else{
                String[] n = nuemro.split("\\.");
                if(n.length == 1){
                    i=i-2;
                    return n[0];
                }
                else
                    return nuemro;
            }
        }
        return nuemro;
    }
    
    public static void main(String[] args) {
        
        leer l = new leer();
        /*for(int i=0; i<8;i++)
            System.out.println(l.caracter());*/
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
        System.out.println(l.formarVariable());
    }
    
}
