package tetris.game.tetromino;

import tetris.game.TetrisException;

/**
 * Created by lewis on 12/9/16.
 */

/**
 * Exception thrown when a collision occurs between a Tetromino and another Tetromino or the bounds of the playing field.
 */
public class CollisionException extends TetrisException {
    /**
     * Initialises a CollisionException.
     */
    public CollisionException() {}

    /**
     * Initialises a CollisionException with a message.
     * @param message The exception message.
     */
    public CollisionException(String message) { super(message); }

    /**
     * Initiailises a CollisionException with an inner exception.
     * @param inner Inner exception.
     */
    public CollisionException(Throwable inner) { super(inner); }

    /**
     * Initialises a CollisionException with a message and an inner exception.
     * @param message The exception message.
     * @param inner The inner exception.
     */
    public CollisionException(String message, Throwable inner) { super(message, inner); }
}
