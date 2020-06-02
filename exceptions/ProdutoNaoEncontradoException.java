package exceptions;

public class ProdutoNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 2L;

    public ProdutoNaoEncontradoException() {

        super("Produto nao encontrado");
    }
}