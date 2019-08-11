package Code;
public class Variaveis{
   public static float[] var = new float[26];
   protected static String variaveis_permitidas = "abcdefghijklmnopqrstuvwxyz";
   protected static boolean VerificaValidadeVariavel(String variavel){
      if(variavel.length() != 1) {
         return false;
      }
      else if(variaveis_permitidas.contains(variavel)){
         return true;
      }
      return false;
   }
   protected static void AdicionarVariavel(float valor, String name){
      int posicao = variaveis_permitidas.indexOf(name);
      var[posicao] = valor;
   }

}