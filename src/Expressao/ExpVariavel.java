package Expressao;

import Variavel.*;

public class ExpVariavel extends Expressao{

    char variavel;

    public ExpVariavel(char nomevar) {
        variavel= nomevar;
    }

    public double avalia(Memoria local, Memoria global) {
        int posicao = variavel - 97;
        if(local.var[posicao] != Double.NEGATIVE_INFINITY){
            return local.var[posicao];
        }else if(global.var[posicao] != Double.NEGATIVE_INFINITY){
            return global.var[posicao];
        }
        return -1;
    }

}