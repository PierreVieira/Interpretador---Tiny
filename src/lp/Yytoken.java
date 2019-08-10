//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lp;

class Yytoken {
    public int m_index;
    public String m_text;
    public int m_line;
    public int m_charBegin;
    public int m_charEnd;

    Yytoken(int var1, String var2, int var3, int var4, int var5) {
        this.m_index = var1;
        this.m_text = new String(var2);
        this.m_line = var3;
        this.m_charBegin = var4;
        this.m_charEnd = var5;
    }

    public String toString() {
        return "Token #" + this.m_index + ": " + this.m_text + " (line " + this.m_line + ")";
    }
}
