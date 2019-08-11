package TrataErro;

public class VariavelInvalidaException extends Exception{
    @Override
    public String getMessage() {
        return "Variável inválida!";
    }
}
