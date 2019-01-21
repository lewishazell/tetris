package tetris.game;

/**
 * Created by lewis on 12/10/16.
 */


public class GameOverException extends TetrisException {
    /**
     * Initialises a GameOverException.
     */
    public GameOverException() {}

    /**
     * Initialises a GameOverException with a message.
     * @param message The exception message.
     */
    public GameOverException(String message) { super(message); }

    /**
     * Initiailises a GameOverException with an inner exception.
     * @param inner Inner exception.
     */

    public GameOverException(Throwable inner) { super(inner); }

    /**
     * Initialises a GameOverException with a message and an inner exception.
     * @param message The exception message.
     * @param inner The inner exception.
     */
    public GameOverException(String message, Throwable inner) { super(message, inner); }
}
