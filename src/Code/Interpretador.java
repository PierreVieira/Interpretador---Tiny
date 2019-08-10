package Code;
import java.io.*;
import java.util.*;
import lp.*;

class Interpretador {
   private ArquivoFonte arq;
   private Vector comandos;   
   private String palavraAtual;
   		
   public Interpretador(String nome) {
      arq= new ArquivoFonte(nome);
      comandos= new Vector();
   }
   
   public void listaArquivo() {
      String palavra;
      
      do {
         palavra= arq.proximaPalavra();
         System.out.println ("Palavra: " + palavra);
      } while (!palavra.equals("EOF"));
   }
   
   public void leArquivo() {
      
      String comandoAtual;
      int linha= 0;
      do {
         comandoAtual= arq.proximaPalavra();
         //A partir daqui ele irá escolher o comando
         if(comandoAtual.equals("endp")){
            trataComandoEndp(linha);
            linha++;
         }
         else if(comandoAtual.equals("writeln")){
            trataComandoWriteln(linha);
            linha++;
         }
         else if(comandoAtual.equals("writeStr")){
            trataComandoWriteStr(linha);
            linha++;
         }
         else if(comandoAtual.equals("read")) {
            trataComandoRead(linha);
            linha++;
         }
      } while (!comandoAtual.equals("endp"));
   }

   private void trataComandoRead(int linha) {

   }

   private void trataComandoWriteStr(int linha) {
      String txt = "";
      String caractere = "";
      String txt2 = "";
      char c1;
      while(true){
         caractere = arq.proximaPalavra();
         if(caractere.equals(";")){
            break;
         }
         txt += caractere;
      }
      for (int i=0; i<txt.length(); i++) {
         c1 = txt.charAt(i);
         if(i != 0 && i != txt.length()-1){
            txt2 += c1;
         }
      }
      ComandoWriteStr c = new ComandoWriteStr(linha, txt2);
      comandos.addElement(c);
   }

   private void trataComandoEndp(int lin) {

      ComandoEndp c = new ComandoEndp(lin);
      comandos.addElement(c);
   }

   private void trataComandoWriteln(int lin) {

      ComandoWriteln c = new ComandoWriteln(lin);
      comandos.addElement(c);
   }

   public void executa() {
      Comando cmd;
      int pc= 0;
      do {
         cmd= (Comando) comandos.elementAt(pc);
         pc= cmd.executa();
      } while (pc != -1);
   }   
}
