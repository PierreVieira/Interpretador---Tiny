package Comando;

public class ComandoEndw extends Comando {

    int linhaW;

    public ComandoEndw(int lin, int linW) {
        this.linhaW = linW;
        this.linha = lin;
    }

    public int executa() {
        return this.linhaW;
    }
}