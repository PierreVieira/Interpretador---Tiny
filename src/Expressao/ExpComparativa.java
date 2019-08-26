package Expressao;

import Variavel.*;

public class ExpComparativa extends Expressao{

    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE  = 1;
    static final double FALSE = 0;

    public ExpComparativa(String op, Object exp1, Object exp2) {
        this.op= op;
        this.exp1= exp1;
        this.exp2= exp2;
    }

    public double avalia() {
        boolean v = false;
        double valor = FALSE;
        opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;
       // System.out.println("\n1 = "+opr1.toString());
       // System.out.println("2 = "+opr2.toString());
        switch(this.op){
            case "<":
                v = Double.parseDouble(opr1.toString()) < Double.parseDouble(opr2.toString()); break;
            case ">":
                v = Double.parseDouble(opr1.toString()) > Double.parseDouble(opr2.toString()); break;
            case "<=":
                v = Double.parseDouble(opr1.toString()) <= Double.parseDouble(opr2.toString()); break;
            case ">=":
                v = Double.parseDouble(opr1.toString()) >= Double.parseDouble(opr2.toString()); break;
            case "<>":
               // System.out.println("CAIUUUU!!");
                v = !opr1.equals(opr2); break;
            case "=":
                v = opr1.equals(opr2); break;
            default:
                System.out.println("Sabia que n ia dar certo!!!");
        }


        if( v == true ){
            valor = TRUE;
        }
        //System.out.println("Your number was " + valor);
        return valor;
    }
}