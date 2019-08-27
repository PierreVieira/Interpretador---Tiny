package Expressao;

import Variavel.*;

public class ExpLogica extends Expressao{

    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE  = 1;
    static final double FALSE = 0;

    public ExpLogica(String op, Object exp1, Object exp2) {
        this.op= op;
        this.exp1= exp1;
        this.exp2= exp2;
    }

    public double avalia() {
        boolean v = false,
                opr1B = false,
                opr2B = false;
        double valor= FALSE;
    //Tive que fazer uma gambiarra mandando o 1 pro 2 e o 2 pro 1 pra poder funcionar
        opr2 = (Expressao) exp2;
        opr1 = (Expressao) exp1;
        if(opr1.avalia() == 1){
            opr1B = true;
        }
        if(opr2.avalia() == 1){
            opr2B = true;
        }
        switch(this.op){
            case "and":
                v = opr1B && opr2B; break;
            case "or":
                v = opr1B || opr2B; break;
            case "not":
                System.out.println("estou no not");
                v = !(opr1B); break;
            case "=":
                v = opr1B == opr2B; break;
            default:
                System.out.println("Sabia que n ia dar certo!!!");
        }



        if( v == true ){
            valor= TRUE;
        }

        return valor;

    }
}