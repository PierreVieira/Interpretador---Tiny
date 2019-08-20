package TrataErro;

public class ParenteseAbrindoNoFimDaExpressaoException extends Exception {
    @Override
    public String getMessage() {
        return "Parênteses abrindo no fim da expressão!";
    }
}
