package Comando;

import Variavel.Memoria;

public class ComandoWriteVar extends Comando {
   
   char variavel_name;
   	
   public ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel_name = txt.charAt(0);
   }
   
   public int executa(Memoria local, Memoria global) {
      //double valor_variavel = Variaveis.var[Variaveis.variaveis_permitidas.indexOf(variavel_name)];
      System.out.print(valor_variavel);
      return linha+1;
   }
}