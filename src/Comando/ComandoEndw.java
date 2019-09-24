package Comando;

import Variavel.Memoria;

public class ComandoEndw extends Comando {

    int linhaW;

    public ComandoEndw(int lin, int linW) {
        this.linhaW = linW;
        this.linha = lin;
    }

    public int executa(Memoria local, Memoria global) {
        return this.linhaW;
    }
}