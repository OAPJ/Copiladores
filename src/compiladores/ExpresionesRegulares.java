/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.util.ArrayList;

/**
 * Nombres: Miguel Angel Cervantes Garcia
 *          Juan Antonio Ovalle Patiño
 * Num Boletas: 2017670201
 *              2017670891
 * Fecha de Entrega: 3)13 / Febrero / 2019 
 *                   4)25 / Febrero / 2019 
 * Evidencia: 3) Expresiones Regulares
 *            4)Velidacion de cadenas, simbolos y numeros
 * Nombre de la maestra: Karina Rodriguez Mejia
 * Programa Academico: Ingenieria en Sistemas Computacionales
 * Unidad de Aprendizaje: Compiladores
 * @author ovall
 */
public class ExpresionesRegulares {
    private ArrayList<String> vf;
    
    public ExpresionesRegulares(){
        vf = new ArrayList<>();
        vf.add("end");   //0
        vf.add("while"); //1
        vf.add("if");    //2
        vf.add("elsif"); //3
        vf.add("else");  //4
        vf.add("wea");   //5
        vf.add("weaS");  //6
        vf.add("weaN");  //7
        vf.add("weaD");  //8
        vf.add("weaBo"); //9
        vf.add("OR");    //10
        vf.add("mod");   //11
        vf.add("AND");   //12
        vf.add("return");//13
        vf.add("+");     //14
        vf.add("-");     //15
        vf.add("*");     //16
        vf.add("/");     //17
        vf.add("^");     //18
        vf.add("=");     //19
        vf.add(">");     //20
        vf.add("<");     //21
        vf.add("¡");     //22
        vf.add("(");     //23
        vf.add(")");     //24
        vf.add(",");     //25
        vf.add("¡=");    //26
        vf.add("++");    //27
        vf.add("--");    //28
        vf.add("=>");    //29
        vf.add("<=");    //30
        vf.add("===");   //31
        vf.add("    ");
    }
    
    public String exRegular(String er){
        if(vf.contains(er))
            return er;
        else
            return "1 Error";
    }
    
    public String validarNumero(String er){
        try {
            double e = Double.parseDouble(er);
            return er;
        } catch (Exception e) {
            return "2 Error ";
        }
    }

    public String getVf(int n) {
        return vf.get(n);
    }
    
    public static void main(String[] args) {
        ExpresionesRegulares e = new ExpresionesRegulares();
        System.out.println(e.validarNumero("4."));
        
    }
}
