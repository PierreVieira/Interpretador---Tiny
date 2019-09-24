package Comando;

import Code.Condicao;
import Expressao.Expressao;
import Variavel.Memoria;

public class ComandoIf extends Comando implements Condicao {

    int linhaEnd;
    Expressao exp;

    public ComandoIf(int lin, Expressao raizArvoreExpressao) {
        this.linha = lin;
        this.exp = raizArvoreExpressao;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd = lin;
    }

    public int executa(Memoria local, Memoria global) {
    double v = exp.avalia();
        if(v == 1){
           return linha+1;
        }
        return linhaEnd;
    }
}
