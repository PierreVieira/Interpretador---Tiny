//Antônio Pierre Martins Vieira
//Eduardo Vinícius Silva de Lima
//Thiago Danilo Souza Pereira
package Code;

public class tiny {
   public static void main(String[] args) {
      Interpretador inter= new Interpretador(args[0]);
      inter.leArquivo();
      inter.executa();
   }
}