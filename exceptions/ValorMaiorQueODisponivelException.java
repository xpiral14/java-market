package exceptions;

public class ValorMaiorQueODisponivelException extends Exception {
    private static final long serialVersionUID = 4L;

    public ValorMaiorQueODisponivelException() {

        super("O valor é maior que o disponivel");
    }
}