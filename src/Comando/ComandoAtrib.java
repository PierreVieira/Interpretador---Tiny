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
        if(local.var[variavel - 97] != -1){
            local.var[variavel - 97] = this.exp.avalia();
        }else if(global.var[variavel -97] != -1){
            global.var[variavel - 97] = this.exp.avalia();
        }
        return linha+1;
    }
}
