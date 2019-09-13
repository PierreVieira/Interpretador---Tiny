package Comando;

import Expressao.Expressao;

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

    public int executa() {
        double v = exp.avalia();
        if(v == 1){
            return this.linha+1;
        }
        return linhaEnd+1;
    }
}
