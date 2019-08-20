package TrataErro;

public class ParenteseFechandoMaiorQueAbrindoException extends Exception{
    @Override
    public String getMessage() {
        return "A quantidade de parênteses fechando é maior que a quantidade de parênteses abrindo!";
    }
}
