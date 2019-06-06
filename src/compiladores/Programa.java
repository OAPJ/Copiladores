/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Nombres: Miguel Angel Cervantes Garcia, Juan Antonio Ovalle Patiño Num
 * Boletas: 2017670201, 2017670891 
 * Fecha de Entrega: 16 / Mayo / 2019
 *                   06 / Juanio/ 2019
 * Evidencia: Compilacion del lenguaje
 *            Semantico
 * Nombre de la maestra: Karina Rodriguez Mejia
 * Programa Academico: Ingenieria en Sistemas Computacionales
 * Aprendizaje: Compiladores
 * 
 * @author ovall
 */
public class Programa {
    private final leer  leer;
    private final Errores er;
    private final ExpresionesRegulares ep;
    private int i;
    private String ident, num;
    private String a, a2;
    private Map<String, ArrayList<String>> tipoVariables;
    private ArrayList<String> variables;
    private int variableTipo;
    private boolean error;
    private String auxExpresion, tipo;
    
    public Programa(){
        variableTipo = 0;
        leer = new leer();
        er = new Errores();
        ep = new ExpresionesRegulares();
        ident = "ident";
        num = "num";
        error = false;
        variables = new ArrayList<>();
        tipoVariables = new HashMap<String, ArrayList<String> >();
        tipoVariables.put(ep.getVf(5), new ArrayList<String>());
        tipoVariables.put(ep.getVf(6), new ArrayList<String>());
        tipoVariables.put(ep.getVf(7), new ArrayList<String>());
        tipoVariables.put(ep.getVf(8), new ArrayList<String>());
        tipoVariables.put(ep.getVf(9), new ArrayList<String>());
        auxExpresion = "";
        tipo = "";
        programa();
    }

    public void programa() {
        a = leer.formarVariable();
        String aux = a;
        if(a.contains(ident)){
            A1();
            Bloque();
            a2 = leer.formarVariable();
            if(a2.equals(ep.getVf(0))){//end
                a2 = leer.formarVariable();
                if(a2.equals(aux) && !error) System.out.println("Compilacion exitosa");
                else System.err.println("Error al compilar");
            }
            else System.err.println("Prog "+er.getError(1));
        }
        else System.err.println("Prog "+er.getError(2));
    }

    private void A1() {
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(5)) && !a.equals(ep.getVf(6)) && !a.equals(ep.getVf(7)) && !a.equals(ep.getVf(8))
           && !a.equals(ep.getVf(9)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)) && !a.contains(ident)){
            leer.setI(i);
            DeclararFunciones();
        }
        else leer.setI(i);
    }
    
    private void DeclararFunciones(){
        a = leer.formarVariable();
        if(a.contains(ep.getVf(32))){
            a = leer.formarVariable();
            String aux = a;
            if(a.contains(ident)){
                Bloque();
                a2 = leer.formarVariable();
                if(a.equals(ep.getVf(0))){
                    a2 = leer.formarVariable();
                    if(aux.equals(a2)){
                        A2();
                    }
                    else System.err.println("DF1 "+er.getError(2));
                }
                else System.err.println("DF2 "+er.getError(1));
            }
            else System.err.println("DF3 "+er.getError(2));
        }
        else System.err.println("DF4 "+er.getError(15));
    }

    private void A2() {
        i = leer.getI();
        a = leer.formarVariable();
        String aux = a;
        if(!a.equals(ep.getVf(5)) && !a.equals(ep.getVf(6)) && !a.equals(ep.getVf(7)) && !a.equals(ep.getVf(8))
        && !a.equals(ep.getVf(9)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)) && !a.contains(ident)){
            if(a.contains(ep.getVf(32))){
                a = leer.formarVariable();
                if(a.contains(ident)){
                    Bloque();
                    a2 = leer.formarVariable();
                    if(a2.equals(ep.getVf(0))){
                       a2 = leer.formarVariable();
                       if(aux.equals(a2)) {
                           A2();
                       }
                       else System.err.println(er.getError(2));
                    }
                    else System.err.println("A2 "+er.getError(1));
                }
                else System.err.println("A2 "+er.getError(2));
            }
            else System.err.println("A2 "+er.getError(15));
        }
        else leer.setI(i);
    }
    
    private void Bloque() {
        A3();
        Proposicion();
    }

    private void A3() {
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2))){
            leer.setI(i);
            Tipo();
            A4();
        }
        else leer.setI(i);
    }

    private void A4() {
        a =  leer.formarVariable();
        ArrayList<String> aux = new ArrayList<>();
        if(a.contains(ident)){
            String aux2 = a.replace(ident, "");
            if(variables.contains(aux2)) {
                System.err.println("Variable ya ocupada");
                error = true;
            }
            else
            {
                variables.add(aux2);
                if(variableTipo == 1){
                    aux = tipoVariables.get(ep.getVf(5));
                    aux.add(aux2);
                    tipoVariables.put(ep.getVf(5), aux);
                }
                else if(variableTipo == 2){
                    aux = tipoVariables.get(ep.getVf(6));
                    aux.add(aux2);
                    tipoVariables.put(ep.getVf(6), aux);
                }
                else if(variableTipo == 3){
                    aux = tipoVariables.get(ep.getVf(7));
                    aux.add(aux2);
                    tipoVariables.put(ep.getVf(7), aux);
                }
                else if(variableTipo == 4){
                    aux = tipoVariables.get(ep.getVf(8));
                    aux.add(aux2);
                    tipoVariables.put(ep.getVf(8), aux);
                }
                else if(variableTipo == 5){
                    aux = tipoVariables.get(ep.getVf(9));
                    aux.add(aux2);
                    tipoVariables.put(ep.getVf(9), aux);
                }
            }
            A5();
            A7();
        }
        else System.err.println("A4 "+er.getError(2));
    }
    
    private void A5(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(25)) && !a.contains(ident) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)))
            if(a.equals(ep.getVf(19))) 
                A6();
            else System.err.println("A5 "+er.getError(5));
        else leer.setI(i);
    }
    
    private void A6(){
        a = leer.formarVariable();
        if(a.contains(num)){}
        else if(a.contains(ident)){}
        else System.err.println("A6"+er.getError(2));
    }
    
    private void A7(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)))
            if(a.equals(ep.getVf(25))) A4();
            else System.err.println("A7 "+er.getError(6));
        else leer.setI(i);
    }
    
    private void Proposicion(){
        a = leer.formarVariable();
        String aux = a, aux2;
        if(a.contains(ident)){
            //System.out.println("Pro "+a);
            aux2 = a.replace(ident, "");
            if(!variables.contains(aux2)){
                System.err.println("PRO Varable no definida: "+aux2);
                error = true;
            }
            //Verifar que tipo es
            boolean var = false;
            if(!tipoVariables.get(ep.getVf(5)).isEmpty()){
                if(tipoVariables.get(ep.getVf(5)).contains(aux2)){
                    tipo = ep.getVf(5);
                    var = true;
                }
            }
            if(!tipoVariables.get(ep.getVf(6)).isEmpty()){
                if(tipoVariables.get(ep.getVf(6)).contains(aux2)){
                    tipo = ep.getVf(6);
                    var = true;
                }
            }
            if(!tipoVariables.get(ep.getVf(7)).isEmpty()){
                if(tipoVariables.get(ep.getVf(7)).contains(aux2)){
                    tipo = ep.getVf(7);
                    var = true;
                }
            }
            if(!tipoVariables.get(ep.getVf(8)).isEmpty()){
                if(tipoVariables.get(ep.getVf(8)).contains(aux2)){
                    tipo = ep.getVf(8);
                    var = true;
                }
            }
            if(!tipoVariables.get(ep.getVf(9)).isEmpty()){
                if(tipoVariables.get(ep.getVf(5)).contains(aux2)){
                    tipo = ep.getVf(9);
                    var = true;
                }
            }
            A8();
            A11();
        }
        else if(a.equals(ep.getVf(1))){
            a2 = leer.formarVariable();
            if(a2.equals(ep.getVf(23))){
                Condicion();
                a2 = leer.formarVariable();
                if(a2.equals(ep.getVf(24))){
                    A11();
                    a2 = leer.formarVariable();
                    if(a2.equals(ep.getVf(0))){
                        a2 = leer.formarVariable();
                        if(a2.equals(aux))
                            A11();
                        else System.err.println("PRO "+er.getError(3));
                    }
                    else System.err.println("PRO "+er.getError(1));
                }
                else System.err.println("PRO "+er.getError(7));
            }
            else System.err.println("PRO "+er.getError(7));
        }
        else if(a.equals(ep.getVf(2))){
            a2 = leer.formarVariable();
            if(a2.equals(ep.getVf(23))){
                Condicion();
                a2 = leer.formarVariable();
                if(a2.equals(ep.getVf(24))){
                    A11();
                    A12();
                    A13();
                    a2 = leer.formarVariable();
                    if(a2.equals(ep.getVf(0))){
                        a2 = leer.formarVariable();
                        if(a2.equals(aux)) A11();
                        else System.err.println("PRO "+er.getError(3));
                    }
                    else System.err.println("PRO "+er.getError(1));
                }
                else System.err.println("PRO "+er.getError(7));
            }
            else System.err.println("PRO "+er.getError(7));
        }
        else System.err.println("PRO "+er.getError(2));
    }
    
    private void A8(){ 
        a = leer.formarVariable();
        if(a.equals(ep.getVf(19))){
            Expresion();
        }
        else if(a.equals(ep.getVf(23))){
            A10();
            a = leer.formarVariable();
            if(!a.equals(ep.getVf(24)))
                System.err.println("A8 "+er.getError(7));
        }
        else System.err.println("A8 "+er.getError(5));
    }
    
    private void A10(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))){
            leer.setI(i);
            Parametro();
        }
        else leer.setI(i);
    }
    
    private void A11(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(0))){
            leer.setI(i);
            Proposicion();
        }
        else leer.setI(i);
    }
    
    private void A12(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(0)) && !a.equals(ep.getVf(4))){
            if(a.equals(ep.getVf(3))){
                a = leer.formarVariable();
                if(a.equals(ep.getVf(23))){
                    Condicion();
                    a = leer.formarVariable();
                    if(a.equals(ep.getVf(24))){
                        A11();
                        A12();
                    }
                    else System.err.println("A12 "+er.getError(7));
                }
                else System.err.println("A12 "+er.getError(7));
            }
            else System.err.println("A12 "+er.getError(9));
        }
        else leer.setI(i);
    }
    
    private void A13(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(0))){
            //a = leer.formarVariable();
            if(a.equals(ep.getVf(4))) A11();
            else System.err.println("A13 "+er.getError(10));
        }
        else leer.setI(i);
        
    }
    
    private void Tipo(){
        a = leer.formarVariable();
        if(a.equals(ep.getVf(5))){
            tipoVariables.put(ep.getVf(5), tipoVariables.get(ep.getVf(5)));
            variableTipo = 1;
        }
        else if(a.equals(ep.getVf(6))){
            tipoVariables.put(ep.getVf(6), tipoVariables.get(ep.getVf(6)));
            variableTipo = 2;
        }
        else if(a.equals(ep.getVf(7))){
            tipoVariables.put(ep.getVf(7), tipoVariables.get(ep.getVf(7)));
            variableTipo = 3;
        }
        else if(a.equals(ep.getVf(8))){
            tipoVariables.put(ep.getVf(8), tipoVariables.get(ep.getVf(8)));
            variableTipo = 4;
        }
        else if(a.equals(ep.getVf(9))){
            tipoVariables.put(ep.getVf(9), tipoVariables.get(ep.getVf(9)));
            variableTipo = 5;
        }
        else System.err.println("TI "+er.getError(11));
    }
    
    private void Expresion(){
        a = leer.formarVariable();
        String aux = "";
        if(a.contains(ident)){
            aux = a.replace(ident, "");
            if(!variables.contains(aux)){
                System.err.println("Variable no declarada "+aux);
                error = true;
            }
            if(!tipoVariables.get(tipo).contains(aux)){
                System.err.println("Tipo de varibale no coincide "+aux);
                error = true;
            }
            A17_1();
        }
        else if(a.contains(num)){
            aux = a.replace(num, "");
            if(!tipo.equals(ep.getVf(7)) && !tipo.equals(ep.getVf(8))){
                System.out.println("Tipo de variable no coincide " + aux);
                error =  true;
            }
            A17();
        }
        else System.err.println("EXP "+er.getError(2));
    }
    
    private void A17_1(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(0)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2))){
            if(a.equals(ep.getVf(23))){
                A10();
                a = leer.formarVariable();
                if(a.equals(ep.getVf(24))){}
                else System.err.println("A17_1 "+er.getError(7));
            }
            else if (a.equals(ep.getVf(14)) || a.equals(ep.getVf(15)) || a.equals(ep.getVf(16)) 
                        || a.equals(ep.getVf(17)) || a.equals(ep.getVf(18)) || a.equals(ep.getVf(11))){
                leer.setI(i);
                A18_1();
                Expresion();
            }
            else System.err.println("A17_1 "+er.getError(16));
        }
        else leer.setI(i);
    }
    
    private void A17(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(0)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2))){
            leer.setI(i);
            A18_1();
            Expresion();
        }
        else leer.setI(i);
    }
    
    private void A18_1(){
        a= leer.formarVariable();
        if(!a.equals(ep.getVf(11)) && !a.equals(ep.getVf(14)) && !a.equals(ep.getVf(15)) && !a.equals(ep.getVf(16))
                && !a.equals(ep.getVf(17)) && !a.equals(ep.getVf(18)))
            System.err.println("A18_1 "+er.getError(12));
    }
    
    private void Parametro(){
        Tipo();
        a = leer.formarVariable();
        if(a.contains(ident)) A20();
        else System.err.println("PAR "+er.getError(2));
    }
    
    private void A20(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))){
            if(a.equals(25)) Parametro();
            else System.err.println("A20 "+er.getError(6));
        }
        else leer.setI(i);
    }
    
    private void Condicion(){
        A16();
        A21();
        A23();
    }
    
    private void A16(){
        a = leer.formarVariable();
        if(a.contains(ident)){
            String aux = a.replace(ident, "");
            if(!variables.contains(aux)){
                System.err.println("Varaible no definida "+aux);
                error = true;
            }
        }
        else if(a.contains(num)){}
        else System.err.println("A16 "+er.getError(2));
    }
    
    private void A23(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))){
            leer.setI(i);
            A22();
            Condicion();
        }
        else leer.setI(i);
    }
    
    private void A21(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(12)) && !a.equals(ep.getVf(10)) && !a.equals(ep.getVf(24))){
            leer.setI(i);
            A18();
            A16();
        }
        else leer.setI(i);
    }
    
    private void A18(){
        a = leer.formarVariable();
        if(!a.contains(ep.getVf(20)) && !a.contains(ep.getVf(21)) && !a.contains(ep.getVf(26)) && 
                !a.contains(ep.getVf(29)) && !a.contains(ep.getVf(30)) && !a.contains(ep.getVf(31)))
            System.err.println("A18 "+er.getError(13));
        
    }
    
    private void A22(){
        a = leer.formarVariable();
        if(!a.contains(ep.getVf(10)) && !a.contains(ep.getVf(12)))
            System.err.println("A22 "+er.getError(14));
            
    }
    
    public static void main(String[] args) {
        Programa p =  new Programa();
    }
}