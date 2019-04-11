/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

/**
 *
 * @author ovall
 */
public class Programa {
    leer  leer;
    ExpresionesRegulares exPr;
    //Si hay un epsilon comparar primero los follows
    
    public Programa(){
        leer = new leer();
        exPr = new ExpresionesRegulares();
    }
    
    public void programa(){
        String inicial = leer.formarVariable();
        if(inicial == "Ident"){
            A1();

        }
        if(inicial == leer.formarVariable()) System.out.println("Compilación Exitosa");
        else System.out.println("Error");
    }
    
    public String A1(){
       // if()
        return DeclararFunciones();
    }

    private String DeclararFunciones() {
        return "";
    }
}
