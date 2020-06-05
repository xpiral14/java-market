package exceptions;

/**
 * NaoEncontradoException
 */
public class NaoEncontradoException extends Exception{

    /**
	 *
	 */
	private static final long serialVersionUID = 5L;

	public NaoEncontradoException(String message){
        super(message);
    }
    
}