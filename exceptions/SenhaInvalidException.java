package exceptions;

public class SenhaInvalidException extends Exception {
    private static final long serialVersionUID = 2L;

    public SenhaInvalidException() {

        super("A senha é inválida");
    }
}