package Expressao;

import Variavel.*;

public class ExpSqrt extends Expressao{

    String sqrt;

    public ExpSqrt(String sqrt) {
        this.sqrt= sqrt;
        System.out.println(this.sqrt);
    }

    public double avalia() {
        int posicao_variavel = Variaveis.PosicaoDaVariavel(this.sqrt);
        double raiz, oq_vai_pra_raiz;
        oq_vai_pra_raiz = Variaveis.var[posicao_variavel];
        raiz = Math.sqrt(oq_vai_pra_raiz);
        //System.out.println("Your number was " + raiz);
        return raiz;
    }
}