package TrataErro;

public class ParenteseAbrindoMaiorQueFechandoException extends Exception {
    @Override
    public String getMessage() {
        return "A quantidade de parênteses abrindo é maior que a quantidade de parênteses fechando!";
    }
}
