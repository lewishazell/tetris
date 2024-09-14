package tetris.game.tetromino;

import tetris.game.GameOverException;
import tetris.game.Tetris;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Tetromino interface.
 */
public interface Tetromino {
    /**
     * Gets the x ordinate of the Tetromino.
     * @return The x ordinate of the Tetromino.
     */
    int getX();

    /**
     * Gets the y ordinate of the Tetromino.
     * @return The y ordinate of the Tetromino.
     */
    int getY();

    /**
     * Gets the height of the Tetromino.
     * @return The height of the Tetromino.
     */
    int getHeight();

    /**
     * Gets the width of the Tetromino.
     * @return The widht of the Tetromino.
     */
    int getWidth();

    /**
     * Gets the parent game engine.
     * @return The parent game engine.
     */
    Tetris getParent();

    /**
     * Rotates the Tetromino.
     * @param direction The direction of rotation (CLOCKWISE or ANTI_CLOCKWISE).
     * @throws CannotRotateException
     * @throws InactiveTetrominoException
     */
    void rotate(Rotation direction) throws CannotRotateException, InactiveTetrominoException;

    /**
     * Creates a copy of the internal 2D block array of the Tetromino.
     * @return
     */
    Block[][] toArray();

    /**
     * Moves the Tetromino left or right.
     * @param d The direction to move (LEFT or RIGHT).
     * @throws CollisionException
     * @throws InactiveTetrominoException
     */
    void move(Direction d) throws CollisionException, InactiveTetrominoException;

    /**
     * Makes the Tetromino fall (moves it down).
     * @throws CollisionException
     * @throws InactiveTetrominoException
     * @throws GameOverException
     */
    void fall() throws CollisionException, InactiveTetrominoException, GameOverException;

    /**
     * Gets whether the Tetromino is the currently active Tetromino on the game engine.
     * @return TRUE if the Tetromino is the currently active Tetromino, FALSE otherwise.
     */
    boolean isActive();
}
