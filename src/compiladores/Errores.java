/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.util.ArrayList;

/**
 *
 * @author ovall
 */
public class Errores {
    private ArrayList<String> error;
    
    public Errores(){
        error = new ArrayList<>();
        error.add("Error de compilación");          //0
        error.add("Error Falta un end");            //1
        error.add("Error Falta Identificador");     //2
        error.add("Error Falta un while");          //3
        error.add("Error Falta un if");             //4
        error.add("Error Falta un =");              //5
        error.add("Error Falta un ,");              //6
        error.add("Error Falta un ( ó )");          //7
        error.add("Error Falta Numero");            //8
        error.add("Error Falta un elsif");          //9
        error.add("Error Falta un else");           //10
        error.add("Error Falta Tipo de Variable");  //11
        error.add("Error Falta algun signo");       //12
        error.add("Error Falta una comparación");   //13
        error.add("Error Falta un AND ó OR");       //14
    }
    
    public String getError(int a){
        return error.get(a);
    }
    
}
