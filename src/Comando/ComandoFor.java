package Comando;

import Expressao.Expressao;
import Variavel.Memoria;

public class ComandoFor extends Comando{

    int linhaEnd;
    String varValor;
    double limite;
    char variavel;
    String tipo;
    Expressao exp;
    boolean inicio = true;


    public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao) {
        this.linha = lin;
        this.variavel = var.charAt(0);
        this.varValor = vValor;
        this.tipo = tipo;
        this.exp = raizArvoreExpressao;
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

    public int executa(Memoria local, Memoria global) {
        this.limite = exp.avalia();
        String s = ""+this.variavel;
        if(inicio){
            //Variaveis.var[Variaveis.PosicaoDaVariavel(s)] = Double.parseDouble(varValor);
            this.inicio = false;
        }
            if (tipo.equals("to") ) {
                if (/*Variaveis.var[Variaveis.PosicaoDaVariavel(s)] <= this.limite*/) {
                    return this.linha+1;
                }
                else{
                    this.inicio = true;
                }
                    return this.linhaEnd + 1;
            }
            else {
                if (/*Variaveis.var[Variaveis.PosicaoDaVariavel(s)] >= this.limite*/) {
                    return this.linha+1;
                }
                else{
                    this.inicio = true;
                }
                return this.linhaEnd + 1;
            }
    }
}
