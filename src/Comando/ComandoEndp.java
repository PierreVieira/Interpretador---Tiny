package Comando;

import Variavel.Memoria;

public class ComandoEndp extends Comando {
   
   public ComandoEndp(int lin) {
      linha = lin;
   }


   public int executa(Memoria local, Memoria global) {
      return 0;
   }
}