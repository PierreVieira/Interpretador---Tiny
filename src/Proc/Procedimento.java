package Proc;
import Variavel.*;
import Comando.*;
import java.util.*;


public class Procedimento {
    String nome;     										   // nome do procedimento
    Vector comandos;    									  // vetor de comandos
    String [] parametros;									 // parametros formais
    String [] variaveisLocal;								// variaveis local
    static Memoria global = new Memoria();			       // variaveis globais


    public Procedimento( String n, String [] p ){
        nome= n;
        parametros= p;
    }

    public String getNome(){
        return nome;
    }

    public static void setVariaveisGlobal( String [] vG ){
        char var;
        for(int i = 0, posicao; vG[i] != null; ++i){
            var = vG[i].charAt(0);
            posicao = var - 97;
            global.var[posicao] = 0;
        }
    }

    public void setVariaveisLocal( String [] vL ){
        this.variaveisLocal = vL;
    }

    public void setListaComandos( Vector c ){
        this.comandos = c;
    }

    public void executa(double [] argumentos) {
        Memoria local = new Memoria(); 				// variaveis local
        char var;
        int i, posicao;
        if(variaveisLocal != null ){// adiciona variaveis locais na memoria local
            for(i = 0; variaveisLocal[i] != null; i++){
                var = variaveisLocal[i].charAt(0);
                posicao = var - 97;
                local.var[posicao] = argumentos[i];
            }
        }
        // associa argumentos a seus respectivos parametros formais
        int pc= 0;
        do {
            pc=  ((Comando) comandos.elementAt(pc)).executa(local, global);
        } while (pc < comandos.size() );
    }
}