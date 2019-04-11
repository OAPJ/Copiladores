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
    private ArrayList<String> variablesDefinidas;
    
    public ExpresionesRegulares(){
        variablesDefinidas = new ArrayList<>();
        variablesDefinidas.add("weaS");
        variablesDefinidas.add("wea");
        variablesDefinidas.add("weaN");
        variablesDefinidas.add("weaD");
        variablesDefinidas.add("weaBo");
        variablesDefinidas.add("+");
        variablesDefinidas.add("-");
        variablesDefinidas.add("*");
        variablesDefinidas.add("/");
        variablesDefinidas.add("^");
        variablesDefinidas.add("mod");
        variablesDefinidas.add("=");
        variablesDefinidas.add("===");
        variablesDefinidas.add(">");
        variablesDefinidas.add("=>");
        variablesDefinidas.add("<");
        variablesDefinidas.add("<=");
        variablesDefinidas.add("¡");
        variablesDefinidas.add("¡=");
        variablesDefinidas.add("AND");
        variablesDefinidas.add("OR");
        variablesDefinidas.add("++");
        variablesDefinidas.add("--");
        variablesDefinidas.add("while");
        variablesDefinidas.add("end");
        variablesDefinidas.add("if");
        variablesDefinidas.add("elsif");
        variablesDefinidas.add("else");
        variablesDefinidas.add("(");
        variablesDefinidas.add(")");
        variablesDefinidas.add(",");
        variablesDefinidas.add("return");
    }
    
    public String exRegular(String er){
        if(variablesDefinidas.contains(er))
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

    public ArrayList<String> getVariablesDefinidas() {
        return variablesDefinidas;
    }
    
    public static void main(String[] args) {
        ExpresionesRegulares e = new ExpresionesRegulares();
        System.out.println(e.validarNumero("4."));
        
    }
}
