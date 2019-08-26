package Expressao;

import Variavel.*;

public class ExpBinaria extends Expressao{

    String op;
    Object exp1, exp2;
    Expressao cmd1, cmd2;

    public ExpBinaria(String op, Object exp1, Object exp2) {
        this.op= op;
        this.exp1= exp1;
        this.exp2= exp2;
    }

    public double avalia() {
        double v;
        cmd1 = (Expressao) exp1;
        cmd2 = (Expressao) exp2;
        switch(this.op){
            case "+":
                v = cmd1.avalia() + cmd2.avalia(); break;
            case "-":
                v = cmd1.avalia() - cmd2.avalia(); break;
            case "*":
                v = cmd1.avalia() * cmd2.avalia(); break;
            case "/":
                v = cmd1.avalia() / cmd2.avalia(); break;
            default:
                v = 8789798979846.546846;
                System.out.println("Sabia que n ia dar certo!!!");
        }
        return v; //só pra compilar
    }
}