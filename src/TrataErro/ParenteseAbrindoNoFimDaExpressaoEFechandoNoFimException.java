package TrataErro;

public class ParenteseAbrindoNoFimDaExpressaoEFechandoNoFimException extends Exception{
    @Override
    public String getMessage() {
        return "Parênteses fechando no início e abrindo no fim da expressão!";
    }
}
