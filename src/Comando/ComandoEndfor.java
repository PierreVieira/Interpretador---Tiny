package Comando;

import Variavel.*;

public class ComandoEndfor extends Comando {

    int linhaFor;
    char variavel;
    String tipo;

    public ComandoEndfor(int lin, int linFor, char var, String tipo) {
        this.linha = lin;
        this.linhaFor = linFor;
        this.variavel = var;
        this.tipo = tipo;
    }

    public int executa() {
        return this.linhaFor;
    }
}