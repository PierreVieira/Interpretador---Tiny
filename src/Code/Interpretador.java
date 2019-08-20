package Code;
import java.util.*;

import TrataErro.*;
import lp.*;

class Interpretador {
   private ArquivoFonte arq;
   private Vector comandos;   
   private String comandoAtual;
   private int linha;
   		
   public Interpretador(String nome) {
      arq= new ArquivoFonte(nome);
      comandos= new Vector();
      this.linha = 0;
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
      do {
         comandoAtual= arq.proximaPalavra();
         this.comandoAtual = comandoAtual;
         //System.out.println(comandoAtual);
         //A partir daqui ele irá escolher o comando
         if(comandoAtual.equals("endp")){
            trataComandoEndp();
            linha++;
         }
         else if(comandoAtual.equals("writeln")){
            trataComandoWriteln();
            linha++;
         }
         else if(comandoAtual.equals("writeStr")){
            trataComandoWriteStr();
            linha++;
         }
         else if(comandoAtual.equals("writeVar")){
             trataComandoWriteVar();
             linha++;
         }
         else if(comandoAtual.equals("read")) {
            trataComandoRead();
            linha++;
         }
         else if(Variaveis.variaveis_permitidas.contains(comandoAtual)){//Tem de ser uma atribuição
             trataAtribuicao();
             linha++;
         }
         else if(!comandoAtual.equals(";")){//Chegamos até aqui, então só temos 2 opções, ou o comando é um ; ou é algo que o usuário digitou errado. Logo devemos tratar esse erro.
             trataComandoInvalido(comandoAtual);
             linha++;
         }
      } while (!comandoAtual.equals("endp"));
   }

    private void trataAtribuicao() {
        String name_variavel, string_atribuicao;
        name_variavel = this.comandoAtual;
        verificaPossivelAtribuicao();//Se a atribuição estiver seguida de := não vai dar merda aqui;
        string_atribuicao = pegaStringAtribuicao();
        verificaValidadeStringAtribuicao(string_atribuicao);
        System.out.println(string_atribuicao);
    }

    private void verificaValidadeStringAtribuicao(String string_atribuicao) {
        String numeros, caractere, operandos_validos;
        char c;
        caractere = "";
        numeros = "0123456789";
        operandos_validos = "+-/*";
        verificaParenteses(string_atribuicao);//Se os parenteses tão ok em questão de sintaxe, iremos para o próximo passo
        //PAREI AQUI: VER SE NA ATRIBUIÇÃO TEM SOMENTE NOME DE VARIÁVEL/OPERADORES/NÚMEROS
//        for (int i = 0; i<string_atribuicao.length(); i++) {
//            c = string_atribuicao.charAt(i);
//            caractere += c;
//            if(!(numeros.contains(caractere) || operandos_validos.contains(caractere))){
//
//            }
//            caractere = "";
//        }
    }

    private void verificaParenteses(String string_atribuicao) {
        int p_open, p_closing;
        if((string_atribuicao.charAt(0) == ')') && (string_atribuicao.charAt(string_atribuicao.length() -1) == '(')){
            try {
                throw new ParenteseAbrindoNoFimDaExpressaoEFechandoNoFimException();
            } catch (ParenteseAbrindoNoFimDaExpressaoEFechandoNoFimException e) {
                msgErro();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        else if (string_atribuicao.charAt(string_atribuicao.length() -1) == '('){
            try {
                throw new ParenteseAbrindoNoFimDaExpressaoException();
            } catch (ParenteseAbrindoNoFimDaExpressaoException e) {
                msgErro();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        else if(string_atribuicao.charAt(0) == ')'){
            try {
                throw new ParenteseFechandoNoInicioDaExpressaoException();
            } catch (ParenteseFechandoNoInicioDaExpressaoException e) {
                msgErro();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        p_open = qtdeCaracteresNaString(string_atribuicao, '(');
        p_closing = qtdeCaracteresNaString(string_atribuicao, ')');
        if(p_open > p_closing){
            try {
                throw new ParenteseAbrindoMaiorQueFechandoException();
            } catch (ParenteseAbrindoMaiorQueFechandoException e) {
                msgErro();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        else if(p_closing > p_open){
            try {
                throw new ParenteseFechandoMaiorQueAbrindoException();
            } catch (ParenteseFechandoMaiorQueAbrindoException e) {
                msgErro();
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
   }

    private int qtdeCaracteresNaString(String string_atribuicao, char condicao) {
       char c;
       int cont = 0;
       for (int i = 0; i<string_atribuicao.length(); i++) {
            c = string_atribuicao.charAt(i);
            if(c == condicao){
                cont++;
            }
        }
       return cont;
    }
    private String pegaStringAtribuicao() {
       String string = "";
       do {
           this.comandoAtual = arq.proximaPalavra();
           if (!this.comandoAtual.equals(";")){
               string += this.comandoAtual;
           }
       }while(!this.comandoAtual.equals(";"));
       return string;
    }

    private void verificaPossivelAtribuicao(){
       this.comandoAtual = arq.proximaPalavra();
        if(!this.comandoAtual.equals(":=")){
            trataComandoInvalido(this.comandoAtual);
        }
    }

    private void trataComandoWriteStr() {
      String conteudo = Filtro();
      ComandoWriteStr c = new ComandoWriteStr(linha, conteudo);
      comandos.addElement(c);
    }

    private void trataComandoRead(){
        String conteudo = Filtro();
        try{
            if(Variaveis.VerificaValidadeVariavel(conteudo)){
                ComandoRead c = new ComandoRead(linha, conteudo);
                comandos.addElement(c);
            }
            else{
                throw new VariavelInvalidaException();
            }
        }catch(VariavelInvalidaException e){
            msgErro();
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void trataComandoWriteVar() {
        String conteudo = Filtro();
        try{
            if(Variaveis.VerificaValidadeVariavel(conteudo)){
                ComandoWriteVar c = new ComandoWriteVar(linha, conteudo);
                comandos.addElement(c);
            }
            else{
                throw new VariavelInvalidaException();
            }
        }catch(VariavelInvalidaException e){
            System.out.print("Erro na linha "+Integer.toString(linha+1)+": ");
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    private void trataComandoEndp() {
      ComandoEndp c = new ComandoEndp(linha);
      comandos.addElement(c);
   }
   private void trataComandoWriteln() {
      ComandoWriteln c = new ComandoWriteln(linha);
      comandos.addElement(c);
   }

    private String Filtro(){
       String txt = "";
       String txt2 = "";
       txt = LessOnlyImportant();
       txt2 = RemoveSintaxe.OnlyImportant(txt);
       return txt2;
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
    private void trataComandoInvalido(String comando) {
        try {
            throw new ComandoInvalidoException();
        } catch (ComandoInvalidoException e) {
            msgErro();
            System.out.println(e.getMessage(comando));
            System.exit(1);
        }
    }

    private void msgErro() {
        System.out.print("ERRO NA LINHA "+Integer.toString(linha+1)+": ");
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
