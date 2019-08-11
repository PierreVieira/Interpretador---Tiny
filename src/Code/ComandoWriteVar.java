package Code;
import java.io.*;
import java.util.*;

import lp.*; 

class ComandoWriteVar extends Comando {
   
   char variavel_name;
   	
   ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel_name = txt.charAt(0);
   }
   
   public int executa() {
      float valor_variavel = Variaveis.var[Variaveis.variaveis_permitidas.indexOf(variavel_name)];
      System.out.print(valor_variavel);
      return linha+1;
   }
}