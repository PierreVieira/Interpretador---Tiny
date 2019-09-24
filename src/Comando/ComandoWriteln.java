package Comando;

import Variavel.Memoria;

public class ComandoWriteln extends Comando {
   	
   public ComandoWriteln(int lin) {
      linha= lin;
   }
   
   public int executa(Memoria local, Memoria global) {
      System.out.println();
      return linha+1;
   }
}