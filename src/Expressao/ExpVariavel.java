package Expressao;

import Variavel.*;

public class ExpVariavel extends Expressao{

    char variavel;

    public ExpVariavel(char nomevar) {
        variavel= nomevar;
    }

    public double avalia(Memoria local, Memoria global) {
        if(local.var[variavel - 97] != -1){
            return local.var[variavel-97];
        }else if(global.var[variavel - 97] != -1){
            return global.var[variavel-97];
        }
        return -1;
    }

}