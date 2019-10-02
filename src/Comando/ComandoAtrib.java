package Comando;

import Expressao.Expressao;
import Variavel.Memoria;

public class ComandoAtrib extends Comando {

    char variavel;
    Expressao exp;

    public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao) {
        this.exp = raizArvoreExpressao;
        this.variavel = var;
        this.linha = lin;
    }

    public int executa(Memoria local, Memoria global) {
        if(local.var[variavel - 97] != Double.NEGATIVE_INFINITY){
            local.var[variavel - 97] = this.exp.avalia(local,global);
        }else if(global.var[variavel -97] != Double.NEGATIVE_INFINITY){
            global.var[variavel - 97] = this.exp.avalia(local,global);
        }
        return linha+1;
    }
}
