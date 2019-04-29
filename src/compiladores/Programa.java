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
    private final leer  leer;
    private final Errores er;
    private final ExpresionesRegulares ep;
    private int i;
    private String ident, num;
    private String a, a2;
    //Si hay un epsilon comparar primero los follows
    
    public Programa(){
        leer = new leer();
        er = new Errores();
        ep = new ExpresionesRegulares();
        ident = "ident";
        num = "num";
        programa();
    }

    public void programa() {
        a = leer.formarVariable();
        if(a.contains(ident)){
            A1();
            Bloque();
            a2 = leer.formarVariable();
            if(a2.equals(ep.getVf(0))){//end
                a2 = leer.formarVariable();
                if(a2.equals(a)) System.out.println("Compilacion exitosa");
                else System.err.println("Error al compilar");
            }
            else System.err.println(er.getError(1));
        }
        else System.err.println(er.getError(2));
    }

    private void A1() {
        i = leer.getI();
        a = leer.formarVariable();
        System.out.println(a);
        identweaN != weaN
        if(!a.equals(ep.getVf(5)) && !a.equals(ep.getVf(6)) && !a.equals(ep.getVf(7)) && !a.equals(ep.getVf(8))
           && !a.equals(ep.getVf(9)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)))
            DeclararFunciones();
        else leer.setI(i);
    }
    
    private void DeclararFunciones(){
        a = leer.formarVariable();
        if(a.contains(ident)){
            Bloque();
            a2 = leer.formarVariable();
            if(a2.equals(ep.getVf(0))){
                a2 = leer.formarVariable();
                if(a2.equals(a)) A2();
                else System.err.println(er.getError(2));
            }
            else System.err.println(er.getError(1));
        }
        else System.err.println(er.getError(2));
    }

    private void A2() {
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(5)) && !a.equals(ep.getVf(6)) && !a.equals(ep.getVf(7)) && !a.equals(ep.getVf(8))
        && !a.equals(ep.getVf(9)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2))){
            if(a.contains(ident)){
                Bloque();
                a2 = leer.formarVariable();
                if(a2.equals(ep.getVf(0))){
                   a2 = leer.formarVariable();
                   if(a.equals(a2)) A2();
                   else System.err.println(er.getError(2));
                }
                else System.err.println(er.getError(1));
            }
            else System.err.println(er.getError(2));
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
            Tipo();
            A4();
        }
        else leer.setI(i);
    }

    private void A4() {
        a =  leer.formarVariable();
        if(a.contains(ident)){
            A5();
            A7();
        }
        else System.err.println(er.getError(2));
    }
    
    private void A5(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(25)) && !a.contains(ident) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)))
            if(a.equals(ep.getVf(19))) A6();
            else System.err.println(er.getError(5));
        else leer.setI(i);
    }
    
    private void A6(){
        a = leer.formarVariable();
        if(a.contains(num)){}
        else if(a.contains(ident)){}
        else System.err.println(er.getError(2));
    }
    
    private void A7(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2)))
            if(a.equals(ep.getVf(25))) A4();
            else System.err.println(er.getError(6));
        else leer.setI(i);
    }
    
    private void Proposicion(){
        a = leer.formarVariable();
        if(a.contains(ident)){
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
                        if(a2.equals(a)) A11();
                        else System.err.println(er.getError(3));
                    }
                    else System.err.println(er.getError(1));
                }
                else System.err.println(er.getError(7));
            }
            else System.err.println(er.getError(7));
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
                        if(a2.equals(a)) A11();
                        else System.err.println(er.getError(3));
                    }
                    else System.err.println(er.getError(1));
                }
                else System.err.println(er.getError(7));
            }
            else System.err.println(er.getError(7));
        }
        else System.err.println(er.getError(2));
    }
    
    private void A8(){ 
        a = leer.formarVariable();
        if(a.equals(ep.getVf(19))) Expresion();
        else if(a.equals(ep.getVf(23))){
            A10();
            a = leer.formarVariable();
            if(!a.equals(ep.getVf(24)))
                System.err.println(er.getError(7));
        }
        else System.err.println(er.getError(5));
    }
    
    private void A10(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))) Parametro();
        else leer.setI(i);
    }
    
    private void A11(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(0))) Proposicion();
        else leer.setI(i);
    }
    
    private void A12(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(0))){
            if(a.equals(ep.getVf(3))){
                a = leer.formarVariable();
                if(a.equals(ep.getVf(23))){
                    Condicion();
                    a = leer.formarVariable();
                    if(a.equals(ep.getVf(24))){
                        A11();
                        A12();
                    }
                    else System.err.println(er.getError(7));
                }
                else System.err.println(er.getError(7));
            }
            else System.err.println(er.getError(9));
        }
        else leer.setI(i);
    }
    
    private void A13(){
        a = leer.formarVariable();
        if(a.equals(ep.getVf(4))) A11();
        else System.err.println(er.getError(10));
    }
    
    private void Tipo(){
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(5)) && !a.equals(ep.getVf(6)) && !a.equals(ep.getVf(7))
                && !a.equals(ep.getVf(8)) && !a.equals(ep.getVf(9)))
            System.err.println(er.getError(11));
    }
    
    private void Expresion(){
        a = leer.formarVariable();
        if(a.contains(ident)) A17_1();
        else if(a.contains(num)) A17();
        else System.err.println(er.getError(2));
    }
    
    private void A17_1(){
        A18_1();
        Expresion();
    }
    
    private void A17(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.contains(ident) && !a.equals(ep.getVf(0)) && !a.equals(ep.getVf(1)) && !a.equals(ep.getVf(2))){
            A18_1();
            Expresion();
        }
        else leer.setI(i);
    }
    
    private void A18_1(){
        a= leer.formarVariable();
        if(!a.equals(ep.getVf(11)) || !a.equals(ep.getVf(14)) || !a.equals(ep.getVf(15)) || !a.equals(ep.getVf(16))
                || !a.equals(ep.getVf(17)) || !a.equals(ep.getVf(18)))
            System.err.println(er.getError(12));
    }
    
    private void Parametro(){
        Tipo();
        a = leer.formarVariable();
        if(a.contains(ident)) A20();
        else System.err.println(er.getError(2));
    }
    
    private void A20(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))){
            if(a.equals(25)) Parametro();
            else System.err.println(er.getError(6));
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
        if(a.contains(ident)){}
        else if(a.contains(num)){}
        else System.err.println(er.getError(2));
    }
    
    private void A23(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(24))){
            A22();
            Condicion();
        }
        else leer.setI(i);
    }
    
    private void A21(){
        i = leer.getI();
        a = leer.formarVariable();
        if(!a.equals(ep.getVf(12)) && !a.equals(ep.getVf(10)) && !a.equals(ep.getVf(24))){
            A18();
            A16();
        }
        else leer.setI(i);
    }
    
    private void A18(){
        a = leer.formarVariable();
        if(!a.contains(ep.getVf(20)) || !a.contains(ep.getVf(21)) || !a.contains(ep.getVf(26)) || 
                !a.contains(ep.getVf(29)) || !a.contains(ep.getVf(30)) || !a.contains(ep.getVf(31)))
            System.err.println(er.getError(13));
        
    }
    
    private void A22(){
        if(!a.contains(ep.getVf(10)) || !a.contains(ep.getVf(12)))
            System.err.println(er.getError(14));
            
    }
    
    public static void main(String[] args) {
        Programa p =  new Programa();
    }
}