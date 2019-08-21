package Comando;

import Variavel.Variaveis;

public class ComandoWriteVar extends Comando {
   
   char variavel_name;
   	
   public ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel_name = txt.charAt(0);
   }
   
   public int executa() {
      float valor_variavel = Variaveis.var[Variaveis.variaveis_permitidas.indexOf(variavel_name)];
      System.out.print(valor_variavel);
      return linha+1;
   }
}