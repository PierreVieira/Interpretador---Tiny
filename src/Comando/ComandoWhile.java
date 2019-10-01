package Comando;

import Expressao.Expressao;
import Variavel.Memoria;

public class ComandoWhile extends Comando{

    int linhaEnd;
    Expressao exp;
    public ComandoWhile(int lin, Expressao raizArvoreExpressao) {
        this.linha = lin;
        this.exp = raizArvoreExpressao;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd = lin;
    }

    public int executa(Memoria local, Memoria global) {
        double v = exp.avalia(local,global);
        if(v == 1){
            return this.linha+1;
        }
        return linhaEnd+1;
    }
}
