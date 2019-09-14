package Comando;

import Expressao.Expressao;

public class ComandoFor extends Comando{

    int linhaEnd;
    int varValor;
    double limite;
    char variavel;
    String tipo;
    Expressao exp;
    boolean inicio = true;


    public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao) {
        this.linha = lin;
        this.variavel = var.charAt(0);
        this.varValor = Integer.parseInt(vValor);
        this.tipo = tipo;
        this.exp = raizArvoreExpressao;
        System.out.printf("linha: %d\nvariavel: %s\nvarValor: %s\ntipo: %s\n", this.linha+1, this.variavel, this.varValor, this.tipo);
    }


    public char getVar(){
        return variavel;
    }

    public String getTipo(){
        return tipo;
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
