package Code;

public class RemoveSintaxe {
    public static String OnlyImportant(String txt){
        String txt2 = "";
        char c1;
        for (int i=0; i<txt.length(); i++) {
            c1 = txt.charAt(i);
            if(i != 0 && i != txt.length()-1){
                txt2 += c1;
            }
        }
        return txt2;
    }
}
