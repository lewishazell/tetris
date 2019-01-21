package tetris.game.tetromino;

import tetris.game.TetrisException;

/**
 * Created by lewis on 12/10/16.
 */
public class CannotRotateException extends TetrisException {
    /**
     * Initialises a CannotRotateException.
     */
    public CannotRotateException() {}

    /**
     * Initialises a CannotRotateException with a message.
     * @param message The exception message.
     */
    public CannotRotateException(String message) {
        super(message);
    }

    /**
     * Initiailises a CannotRotateException with an inner exception.
     * @param inner Inner exception.
     */
    public CannotRotateException(Throwable inner) {
        super(inner);
    }

    /**
     * Initialises a CannotRotateException with a message and an inner exception.
     * @param message The exception message.
     * @param inner The inner exception.
     */
    public CannotRotateException(String message, Throwable inner) {
        super(message, inner);
    }
}
