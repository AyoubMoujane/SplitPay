package server.exception.splitException;

/**
 * Thrown when can't find matching split
 *
 */
public class SplitNotFoundException extends Exception{

    public SplitNotFoundException(String message) {
        super(message);
    }
}