package Variavel;
public class Variaveis{
   public static float[] var = new float[26];
   public static String variaveis_permitidas = "abcdefghijklmnopqrstuvwxyz";
//   public static boolean VerificaValidadeVariavel(String variavel){
//      if(variavel.length() != 1) {
//         return false;
//      }
//      else if(variaveis_permitidas.contains(variavel)){
//         return true;
//      }
//      return false;
//   }
   public static void AdicionarVariavel(float valor, String name){
      int posicao = variaveis_permitidas.indexOf(name);
      var[posicao] = valor;
   }
   public static int PosicaoDaVariavel(String nome){
      char c, comparar;
      comparar = nome.charAt(0);
      for (int i=0; i<variaveis_permitidas.length(); i++) {
          c = variaveis_permitidas.charAt(i);
          if(comparar == c){
             return i;
          }
      }
      return 0;
   }
}