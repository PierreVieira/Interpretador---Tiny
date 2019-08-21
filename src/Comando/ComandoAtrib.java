package Comando;

import Variavel.*;
import Expressao.*;

public class ComandoAtrib extends Comando {

    char variavel;
    Expressao exp;

    public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao) {
        this.exp = raizArvoreExpressao;
        this.variavel = var;
        this.linha = lin;
    }

    public int executa() {
        return linha+1;
    }
}
