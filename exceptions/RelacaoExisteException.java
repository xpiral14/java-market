package exceptions;

public class RelacaoExisteException extends Exception {
    
    private static final long serialVersionUID = 3L;


    public RelacaoExisteException(String message){
        super(message);
    }
}