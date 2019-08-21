package Comando;
import java.util.*;

import Variavel.Variaveis;

public class ComandoRead extends Comando {
   
   Scanner teclado = new Scanner(System.in);
   String name_variavel;
   	
   public ComandoRead(int lin, String name_variavel) {
      linha= lin;
      this.name_variavel = name_variavel;
   }
   
   public int executa() {
      float variavel;
      variavel = teclado.nextFloat();
      Variaveis.AdicionarVariavel(variavel, name_variavel);
      return linha+1;
   }
}