package Comando;

import Variavel.Memoria;

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

    public int executa(Memoria local, Memoria global) {
        String s = ""+this.variavel;
        if(this.tipo.equals("to")){
            //Variaveis.var[Variaveis.PosicaoDaVariavel(s)]++;
        }
        else{
            //Variaveis.var[Variaveis.PosicaoDaVariavel(s)]--;
        }
        return this.linhaFor;
    }
}