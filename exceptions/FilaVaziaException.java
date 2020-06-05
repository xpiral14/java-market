package exceptions;

public class FilaVaziaException extends Exception {
    private static final long serialVersionUID = 1L;

    public FilaVaziaException() {

        super("Categoria nao encontrada");
    }
}