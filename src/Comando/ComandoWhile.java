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

    }

    public int executa() {
        return 0; // só pra compilar
    }
}
