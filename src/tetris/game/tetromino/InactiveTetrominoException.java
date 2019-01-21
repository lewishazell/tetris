package tetris.game.tetromino;

import tetris.game.TetrisException;

/**
 * Created by lewis on 12/10/16.
 */

/**
 * Exception thrown when an attempt is made to act upon (move/rotate) an inactive Tetromino.
 */
public class InactiveTetrominoException extends TetrisException {
    /**
     * Initialises an InactiveTetrominoException.
     */
    public InactiveTetrominoException() {}

    /**
     * Initialises an InactiveTetrominoException with a message.
     * @param message The exception message.
     */
    public InactiveTetrominoException(String message) {
        super(message);
    }

    /**
     * Initiailises an InactiveTetrominoException with an inner exception.
     * @param inner Inner exception.
     */
    public InactiveTetrominoException(Throwable inner) {
        super(inner);
    }

    /**
     * Initialises an InactiveTetrominoException with a message and an inner exception.
     * @param message The exception message.
     * @param inner The inner exception.
     */
    public InactiveTetrominoException(String message, Throwable inner) {
        super(message, inner);
    }
}
