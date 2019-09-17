package Comando;

import Variavel.Variaveis;

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
        String s = ""+this.variavel;
        if(this.tipo.equals("to")){
            Variaveis.var[Variaveis.PosicaoDaVariavel(s)]++;
        }
        else{
            Variaveis.var[Variaveis.PosicaoDaVariavel(s)]--;
        }
        return this.linhaFor;
    }
}