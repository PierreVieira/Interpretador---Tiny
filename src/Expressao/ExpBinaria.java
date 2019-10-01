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
        double v, CMD1, CMD2;
        //Tive que fazer uma gambiarra mandando o 1 pro 2 e o 2 pro 1 pra poder funcionar
        cmd2 = (Expressao) exp1;
        cmd1 = (Expressao) exp2;
        CMD1 = cmd1.avalia();
        CMD2 = cmd2.avalia();
        switch(this.op){
            case "+":
                v = CMD1 + CMD2; break;
            case "-":
                v = CMD1 - CMD2; break;
            case "*":
                v = CMD1 * CMD2; break;
            case "/":
                v = CMD1 / CMD2; break;
            default:
                v = 8789798979846.546846;
                System.out.println("Sabia que n ia dar certo!!!");
        }
        //System.out.println(cmd1.avalia()+" "+" "+this.op+" "+cmd2.avalia()+" = "+v);
        return v; //só pra compilar
    }
}