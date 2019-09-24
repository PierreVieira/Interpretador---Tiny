package Comando;

import Variavel.*;
import Expressao.*;
import Proc.*;

public class ComandoCall extends Comando {

    Procedimento procedimento;
    Expressao [] arg;
    int tamanho;

    public ComandoCall(int lin, Procedimento proc, Expressao [] a, int tam ) {

    }

    public int executa( Memoria local, Memoria global) {

        double [] argumentos = new double[this.tamanho];
        int i= 0;

        while( this.arg[i] != null ){
            //preencher o vetor de argumentos
            i++;
        }

        this.procedimento.executa( argumentos );

        return linha+1;
    }
}
