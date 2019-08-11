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

   private void trataComandoWriteStr(int linha) {
      String txt = "";
      String txt2 = "";
      txt = LessOnlyImportant();
      txt2 = RemoveSintaxe.OnlyImportant(txt);
      ComandoWriteStr c = new ComandoWriteStr(linha, txt2);
      comandos.addElement(c);
   }

   private void trataComandoRead(int linha) {
      String txt = "";

      ComandoRead c = new ComandoRead(linha, txt);
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

   private String LessOnlyImportant(){
      String caractere = "";
      String txt = "";
      while(true){
         caractere = arq.proximaPalavra();
         if(caractere.equals(";")){
            break;
         }
         txt += caractere;
      }
      return txt;
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
