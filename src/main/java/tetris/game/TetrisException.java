package tetris.game;

/**
 * Created by lewis on 12/9/16.
 */

/**
 * Superclass exception, from which all exceptions in the package and subpackages inherit.
 */
public class TetrisException extends Exception {
    /**
     * Initialises a TetrisException.
     */
    public TetrisException() {}

    /**
     * Initialises a TetrisException with a message.
     * @param message The exception message.
     */
    public TetrisException(String message) {
        super(message);
    }

    /**
     * Initiailises a TetrisException with an inner exception.
     * @param inner Inner exception.
     */
    public TetrisException(Throwable inner) {
        super(inner);
    }

    /**
     * Initialises a TetrisException with a message and an inner exception.
     * @param message The exception message.
     * @param inner The inner exception.
     */
    public TetrisException(String message, Throwable inner) {
        super(message, inner);
    }
}
