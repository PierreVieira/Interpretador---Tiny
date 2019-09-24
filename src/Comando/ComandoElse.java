package Comando;

import Code.Condicao;
import Variavel.Memoria;

public class ComandoElse extends Comando implements Condicao {

    int linhaEnd;

    public ComandoElse(int lin) {
        this.linha = lin;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd =  lin;
    }

    public int executa(Memoria local, Memoria global) {
        return linhaEnd;//só pra compilar
    }
}
