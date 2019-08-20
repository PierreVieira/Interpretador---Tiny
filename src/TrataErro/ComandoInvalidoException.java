package TrataErro;

public class ComandoInvalidoException extends Exception {

    public String getMessage(String comando) {
        return "Comando inválido!\nO comando '"+comando+"' não pode ser reconhecido!";
    }
}
