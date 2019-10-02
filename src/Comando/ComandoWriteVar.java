package Comando;

import Variavel.Memoria;

public class ComandoWriteVar extends Comando {
   
   char variavel_name;
   	
   public ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel_name = txt.charAt(0);
   }
   
   public int executa(Memoria local, Memoria global) {
      if(local.var[variavel_name - 97] != Double.NEGATIVE_INFINITY){
         System.out.println(local.var[variavel_name - 97]);
      }else if(global.var[variavel_name -97] != Double.NEGATIVE_INFINITY){
         System.out.println(global.var[variavel_name - 97]);
      }
      return linha+1;
   }
}