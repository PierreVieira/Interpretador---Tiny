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

    public double avalia(Memoria local, Memoria global) {
        boolean v = false;
        double valor = FALSE;
        //Tive que fazer uma gambiarra mandando o 1 pro 2 e o 2 pro 1 pra poder funcionar
        opr2 = (Expressao) exp1;
        opr1 = (Expressao) exp2;
        switch(this.op){
            case "<":
                v = opr1.avalia(local,global) < opr2.avalia(local,global); break;
            case ">":
                v = opr1.avalia(local,global) > opr2.avalia(local,global); break;
            case "<=":
                v = opr1.avalia(local,global) <= opr2.avalia(local,global); break;
            case ">=":
                v = opr1.avalia(local,global) >= opr2.avalia(local,global); break;
            case "<>":
                v = opr1.avalia(local,global) != opr2.avalia(local,global); break;
            case "=":
                v = opr1.avalia(local,global) == opr2.avalia(local,global); break;
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