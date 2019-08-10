//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class Yylex {
    private final int YY_BUFFER_SIZE;
    private final int YY_F;
    private final int YY_NO_STATE;
    private final int YY_NOT_ACCEPT;
    private final int YY_START;
    private final int YY_END;
    private final int YY_NO_ANCHOR;
    private final int YY_BOL;
    private final int YY_EOF;
    private int comment_count;
    private BufferedReader yy_reader;
    private int yy_buffer_index;
    private int yy_buffer_read;
    private int yy_buffer_start;
    private int yy_buffer_end;
    private char[] yy_buffer;
    private int yychar;
    private int yyline;
    private boolean yy_at_bol;
    private int yy_lexical_state;
    private boolean yy_eof_done;
    private final int YYINITIAL;
    private final int COMMENT;
    private final int[] yy_state_dtrans;
    private boolean yy_last_was_cr;
    private final int YY_E_INTERNAL;
    private final int YY_E_MATCH;
    private String[] yy_error_string;
    private int[] yy_acpt;
    private int[] yy_cmap;
    private int[] yy_rmap;
    private int[][] yy_nxt;

    Yylex(Reader var1) {
        this();
        if (null == var1) {
            throw new Error("Error: Bad input stream initializer.");
        } else {
            this.yy_reader = new BufferedReader(var1);
        }
    }

    Yylex(InputStream var1) {
        this();
        if (null == var1) {
            throw new Error("Error: Bad input stream initializer.");
        } else {
            this.yy_reader = new BufferedReader(new InputStreamReader(var1));
        }
    }

    private Yylex() {
        this.YY_BUFFER_SIZE = 512;
        this.YY_F = -1;
        this.YY_NO_STATE = -1;
        this.YY_NOT_ACCEPT = 0;
        this.YY_START = 1;
        this.YY_END = 2;
        this.YY_NO_ANCHOR = 4;
        this.YY_BOL = 128;
        this.YY_EOF = 129;
        this.comment_count = 0;
        this.yy_eof_done = false;
        this.YYINITIAL = 0;
        this.COMMENT = 1;
        this.yy_state_dtrans = new int[]{0, 34};
        this.yy_last_was_cr = false;
        this.YY_E_INTERNAL = 0;
        this.YY_E_MATCH = 1;
        this.yy_error_string = new String[]{"Error: Internal error.\n", "Error: Unmatched input.\n"};
        this.yy_acpt = new int[]{0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 0, 4, 0, 0};
        this.yy_cmap = this.unpackFromString(1, 130, "20:8,15:2,17,20:2,16,20:18,15,20,18,20:5,3,4,9,7,1,8,22,10,21:10,14,2,12,11,13,20:2,23:26,5,19,6,20,24,20,23:26,20:5,0:2")[0];
        this.yy_rmap = this.unpackFromString(1, 35, "0,1:12,2,3,4,5,6,7,8,1:6,9,10,1,11,6,9,12,13,14")[0];
        this.yy_nxt = this.unpackFromString(15, 25, "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,27,16,17,28:2,18,28,19,28,-1:36,20,-1,21,-1:22,22,-1:24,23,-1:28,16,-1,16,-1:8,17:16,-1,25,29,17:5,-1:21,18,31,-1:23,19,-1,19:2,-1:21,26,-1:20,24,-1:8,17:14,32,17,33,30,29,17:5,-1,17:14,32,17,33,25,29,17:5,-1:15,33,-1,33,-1,17,-1:5,1,-1:24");
        this.yy_buffer = new char[512];
        this.yy_buffer_read = 0;
        this.yy_buffer_index = 0;
        this.yy_buffer_start = 0;
        this.yy_buffer_end = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.yy_at_bol = true;
        this.yy_lexical_state = 0;
    }

    private void yybegin(int var1) {
        this.yy_lexical_state = var1;
    }

    private int yy_advance() throws IOException {
        if (this.yy_buffer_index < this.yy_buffer_read) {
            return this.yy_buffer[this.yy_buffer_index++];
        } else {
            int var1;
            if (0 != this.yy_buffer_start) {
                int var2 = this.yy_buffer_start;

                int var3;
                for(var3 = 0; var2 < this.yy_buffer_read; ++var3) {
                    this.yy_buffer[var3] = this.yy_buffer[var2];
                    ++var2;
                }

                this.yy_buffer_end -= this.yy_buffer_start;
                this.yy_buffer_start = 0;
                this.yy_buffer_read = var3;
                this.yy_buffer_index = var3;
                var1 = this.yy_reader.read(this.yy_buffer, this.yy_buffer_read, this.yy_buffer.length - this.yy_buffer_read);
                if (-1 == var1) {
                    return 129;
                }

                this.yy_buffer_read += var1;
            }

            while(this.yy_buffer_index >= this.yy_buffer_read) {
                if (this.yy_buffer_index >= this.yy_buffer.length) {
                    this.yy_buffer = this.yy_double(this.yy_buffer);
                }

                var1 = this.yy_reader.read(this.yy_buffer, this.yy_buffer_read, this.yy_buffer.length - this.yy_buffer_read);
                if (-1 == var1) {
                    return 129;
                }

                this.yy_buffer_read += var1;
            }

            return this.yy_buffer[this.yy_buffer_index++];
        }
    }

    private void yy_move_end() {
        if (this.yy_buffer_end > this.yy_buffer_start && '\n' == this.yy_buffer[this.yy_buffer_end - 1]) {
            --this.yy_buffer_end;
        }

        if (this.yy_buffer_end > this.yy_buffer_start && '\r' == this.yy_buffer[this.yy_buffer_end - 1]) {
            --this.yy_buffer_end;
        }

    }

    private void yy_mark_start() {
        for(int var1 = this.yy_buffer_start; var1 < this.yy_buffer_index; ++var1) {
            if ('\n' == this.yy_buffer[var1] && !this.yy_last_was_cr) {
                ++this.yyline;
            }

            if ('\r' == this.yy_buffer[var1]) {
                ++this.yyline;
                this.yy_last_was_cr = true;
            } else {
                this.yy_last_was_cr = false;
            }
        }

        this.yychar = this.yychar + this.yy_buffer_index - this.yy_buffer_start;
        this.yy_buffer_start = this.yy_buffer_index;
    }

    private void yy_mark_end() {
        this.yy_buffer_end = this.yy_buffer_index;
    }

    private void yy_to_mark() {
        this.yy_buffer_index = this.yy_buffer_end;
        this.yy_at_bol = this.yy_buffer_end > this.yy_buffer_start && ('\r' == this.yy_buffer[this.yy_buffer_end - 1] || '\n' == this.yy_buffer[this.yy_buffer_end - 1] || 2028 == this.yy_buffer[this.yy_buffer_end - 1] || 2029 == this.yy_buffer[this.yy_buffer_end - 1]);
    }

    private String yytext() {
        return new String(this.yy_buffer, this.yy_buffer_start, this.yy_buffer_end - this.yy_buffer_start);
    }

    private int yylength() {
        return this.yy_buffer_end - this.yy_buffer_start;
    }

    private char[] yy_double(char[] var1) {
        char[] var3 = new char[2 * var1.length];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var3[var2] = var1[var2];
        }

        return var3;
    }

    private void yy_error(int var1, boolean var2) {
        System.out.print(this.yy_error_string[var1]);
        System.out.flush();
        if (var2) {
            throw new Error("Fatal Error.\n");
        }
    }

    private int[][] unpackFromString(int var1, int var2, String var3) {
        boolean var4 = true;
        int var6 = 0;
        int var7 = 0;
        int[][] var10 = new int[var1][var2];

        for(int var11 = 0; var11 < var1; ++var11) {
            for(int var12 = 0; var12 < var2; ++var12) {
                if (var6 != 0) {
                    var10[var11][var12] = var7;
                    --var6;
                } else {
                    int var8 = var3.indexOf(44);
                    String var9 = var8 == -1 ? var3 : var3.substring(0, var8);
                    var3 = var3.substring(var8 + 1);
                    int var13 = var9.indexOf(58);
                    if (var13 == -1) {
                        var10[var11][var12] = Integer.parseInt(var9);
                    } else {
                        String var5 = var9.substring(var13 + 1);
                        var6 = Integer.parseInt(var5);
                        var9 = var9.substring(0, var13);
                        var7 = Integer.parseInt(var9);
                        var10[var11][var12] = var7;
                        --var6;
                    }
                }
            }
        }

        return var10;
    }

    public Yytoken yylex() throws IOException {
        boolean var2 = true;
        int var3 = this.yy_state_dtrans[this.yy_lexical_state];
        boolean var4 = true;
        int var5 = -1;
        boolean var6 = true;
        this.yy_mark_start();
        int var7 = this.yy_acpt[var3];
        if (0 != var7) {
            var5 = var3;
            this.yy_mark_end();
        }

        while(true) {
            int var1;
            if (var6 && this.yy_at_bol) {
                var1 = 128;
            } else {
                var1 = this.yy_advance();
            }

            var4 = true;
            int var10 = this.yy_nxt[this.yy_rmap[var3]][this.yy_cmap[var1]];
            if (129 == var1 && var6) {
                return null;
            }

            if (-1 != var10) {
                var3 = var10;
                var6 = false;
                var7 = this.yy_acpt[var10];
                if (0 != var7) {
                    var5 = var10;
                    this.yy_mark_end();
                }
            } else {
                if (-1 == var5) {
                    throw new Error("Lexical Error: Unmatched Input.");
                }

                int var9 = this.yy_acpt[var5];
                if (0 != (2 & var9)) {
                    this.yy_move_end();
                }

                this.yy_to_mark();
                String var8;
                switch(var5) {
                    case -31:
                    case -30:
                    case -29:
                    case -28:
                    case -27:
                    case -26:
                    case -25:
                    case -24:
                    case -23:
                    case -22:
                    case -21:
                    case -20:
                    case -19:
                    case -18:
                    case -17:
                    case -16:
                    case -15:
                    case -14:
                    case -13:
                    case -12:
                    case -11:
                    case -10:
                    case -9:
                    case -8:
                    case -7:
                    case -6:
                    case -5:
                    case -4:
                    case -3:
                    case -2:
                    case -1:
                    case 1:
                    case 16:
                    case 24:
                        break;
                    case 0:
                    case 27:
                    case 31:
                    default:
                        this.yy_error(0, false);
                        break;
                    case 2:
                        return new Yytoken(0, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 3:
                        return new Yytoken(1, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 4:
                        return new Yytoken(2, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 5:
                        return new Yytoken(3, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 6:
                        return new Yytoken(4, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 7:
                        return new Yytoken(5, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 8:
                        return new Yytoken(6, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 9:
                        return new Yytoken(7, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 10:
                        return new Yytoken(8, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 11:
                        return new Yytoken(9, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 12:
                        return new Yytoken(10, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 13:
                        return new Yytoken(12, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 14:
                        return new Yytoken(14, this.yytext(), this.yyline, this.yychar, this.yychar + 1);
                    case 15:
                        System.out.println("Illegal character: <" + this.yytext() + ">");
                        Utility.error(3);
                        break;
                    case 17:
                        var8 = this.yytext().substring(1, this.yytext().length());
                        Utility.error(2);
                        Utility.asert(var8.length() == this.yytext().length() - 1);
                        return new Yytoken(41, var8, this.yyline, this.yychar, this.yychar + var8.length());
                    case 18:
                        return new Yytoken(18, this.yytext(), this.yyline, this.yychar, this.yychar + this.yytext().length());
                    case 19:
                        return new Yytoken(19, this.yytext(), this.yyline, this.yychar, this.yychar + this.yytext().length());
                    case 20:
                        return new Yytoken(13, this.yytext(), this.yyline, this.yychar, this.yychar + 2);
                    case 21:
                        return new Yytoken(11, this.yytext(), this.yyline, this.yychar, this.yychar + 2);
                    case 22:
                        return new Yytoken(15, this.yytext(), this.yyline, this.yychar, this.yychar + 2);
                    case 23:
                        return new Yytoken(16, this.yytext(), this.yyline, this.yychar, this.yychar + 2);
                    case 25:
                        var8 = this.yytext().substring(1, this.yytext().length() - 1);
                        Utility.asert(var8.length() == this.yytext().length() - 2);
                        return new Yytoken(17, var8, this.yyline, this.yychar, this.yychar + var8.length());
                    case 26:
                        return new Yytoken(18, this.yytext(), this.yyline, this.yychar, this.yychar + this.yytext().length());
                    case 28:
                        System.out.println("Illegal character: <" + this.yytext() + ">");
                        Utility.error(3);
                        break;
                    case 29:
                        var8 = this.yytext().substring(1, this.yytext().length());
                        Utility.error(2);
                        Utility.asert(var8.length() == this.yytext().length() - 1);
                        return new Yytoken(41, var8, this.yyline, this.yychar, this.yychar + var8.length());
                    case 30:
                        var8 = this.yytext().substring(1, this.yytext().length() - 1);
                        Utility.asert(var8.length() == this.yytext().length() - 2);
                        return new Yytoken(17, var8, this.yyline, this.yychar, this.yychar + var8.length());
                    case 32:
                        var8 = this.yytext().substring(1, this.yytext().length());
                        Utility.error(2);
                        Utility.asert(var8.length() == this.yytext().length() - 1);
                        return new Yytoken(41, var8, this.yyline, this.yychar, this.yychar + var8.length());
                }

                var6 = true;
                var3 = this.yy_state_dtrans[this.yy_lexical_state];
                var4 = true;
                var5 = -1;
                this.yy_mark_start();
                var7 = this.yy_acpt[var3];
                if (0 != var7) {
                    var5 = var3;
                    this.yy_mark_end();
                }
            }
        }
    }
}
