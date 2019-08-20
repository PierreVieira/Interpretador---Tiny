package TrataErro;

public class ParenteseFechandoNoInicioDaExpressaoException extends Exception{
    @Override
    public String getMessage() {
        return "Parênteses fechando no início da expressão!";
    }
}
