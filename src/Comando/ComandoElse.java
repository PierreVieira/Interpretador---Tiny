package Comando;

import Code.Condicao;

public class ComandoElse extends Comando implements Condicao {

    int linhaEnd;

    public ComandoElse(int lin) {
        this.linha = lin;
    }

    public void setLinhaEnd(int lin){
        this.linhaEnd =  lin;
    }

    public int executa() {
        return linhaEnd;//só pra compilar
    }
}
