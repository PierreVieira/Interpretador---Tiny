package Code;
import java.io.*;
import java.util.*;

import TrataErro.VariavelInvalidaException;
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
            else if(comandoAtual.equals("writeVar")){
                trataComandoWriteVar(linha);
                linha++;
            }
            else if(comandoAtual.equals("read")) {
                trataComandoRead(linha);
                linha++;
            }
        } while (!comandoAtual.equals("endp"));
    }

    private void trataComandoWriteStr(int linha) {
        String conteudo = Filtro();
        ComandoWriteStr c = new ComandoWriteStr(linha, conteudo);
        comandos.addElement(c);
    }

    private void trataComandoRead(int linha){
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
            System.out.print("Erro na linha "+Integer.toString(linha+1)+": ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    private void trataComandoWriteVar(int linha) {
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

    private void trataComandoEndp(int lin) {
        ComandoEndp c = new ComandoEndp(lin);
        comandos.addElement(c);
    }

    private void trataComandoWriteln(int lin) {

        ComandoWriteln c = new ComandoWriteln(lin);
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

    public void executa() {
        Comando cmd;
        int pc= 0;
        do {
            cmd= (Comando) comandos.elementAt(pc);
            pc= cmd.executa();
        } while (pc != -1);
    }
}