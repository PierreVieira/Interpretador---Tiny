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
        String s = "";
        s += variavel;
        Variaveis.AdicionarVariavel(exp.avalia(), s);
        return linha+1;
    }
}
