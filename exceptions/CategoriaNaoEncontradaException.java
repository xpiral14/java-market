package exceptions;

public class CategoriaNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException() {

        super("Categoria nao encontrada");
    }
}