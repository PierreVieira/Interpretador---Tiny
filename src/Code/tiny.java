package Code;
import java.io.*;
import java.util.*;
import lp.*;

public class tiny {
   
   public static void main(String[] args) {
      System.out.println("Fazendo um interpretador dahora!");
      Interpretador inter= new Interpretador(args[0]);
      if (args.length == 1) {
         inter.leArquivo();
         inter.executa();
      }
      else if ((args.length == 2) && (args[1].equals("-l")))
         inter.listaArquivo();
   }
}
