package Comando;
import Variavel.Memoria;

import java.util.*;

public class ComandoRead extends Comando {
   
   Scanner teclado = new Scanner(System.in);
   String name_variavel;
   	
   public ComandoRead(int lin, String name_variavel) {
      linha= lin;
      this.name_variavel = name_variavel;
   }
   
   public int executa(Memoria local, Memoria global) {
      float variavel;
      variavel = teclado.nextFloat();
      return linha+1;
   }
}