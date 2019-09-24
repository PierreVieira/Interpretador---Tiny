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
        String s = "";
        s += variavel;
        //Variaveis.AdicionarVariavel(exp.avalia(), s);
        return linha+1;
    }
}
