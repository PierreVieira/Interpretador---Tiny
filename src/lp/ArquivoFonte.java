//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoFonte {
    private FileReader arq;
    private BufferedReader dados;
    private Yylex yy;

    public ArquivoFonte(String var1) {
        try {
            this.arq = new FileReader(var1);
            this.dados = new BufferedReader(this.arq);
            this.yy = new Yylex(this.dados);
        } catch (Exception var3) {
            System.out.println(var3);
        }

    }

    public String proximaPalavra() {
        try {
            Yytoken var1 = this.yy.yylex();
            return var1 == null ? "EOF" : var1.m_text;
        } catch (IOException var2) {
            System.out.println(var2);
            return "";
        }
    }
}
