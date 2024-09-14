package tetris.game;

import tetris.game.tetromino.Block;
import tetris.game.tetromino.Tetromino;
import tetris.game.tetromino.shapes.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lewis on 12/10/16.
 */

/**
 * Represents the game state.
 *
 * The data within this is to be shared between Engine and Shape, but should not be accessible by any other classes (especially outside of the tetromino packages).
 * Since Engine and Shape are in different packages (Shape is in a subpackage), this is the best way to keep the shared data encapsulated.
 */
public final class GameState {
    /**
     * The parent game engine.
     */
    private final Tetris parent;
    /**
     * The 2D block array representing the playing field.
     */
    private final Block[][] field;
    /**
     * The active tetromino.
     */
    private Tetromino tetromino;
    /**
     * The next active tetromino.
     */
    private Tetromino next;
    /**
     * All Tetromino classes (for generation).
     */
    private final Class[] tetrominos = new Class[] {
            ITetromino.class,
            JTetromino.class,
            LTetromino.class,
            OTetromino.class,
            STetromino.class,
            TTetromino.class,
            ZTetromino.class
    };
    /**
     * The current score.
     */
    private int score = 0;
    /**
     * Game over boolean.
     */
    private boolean over = false;

    /**
     * Gets whether the game is over.
     * @return TRUE if the game is over, FALSE otherwise.
     */
    public boolean isOver() {
        return over;
    }

    /**
     * Sets whether the game is over.
     * @param over Boolean to determine whether the game is over.
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * Gets the active Tetromino.
     * @return THe active Tetromino.
     */
    public Tetromino getTetromino() {
        return tetromino;
    }

    /**
     * Sets the active Tetromino.
     * @param tetromino The active Tetromino.
     */
    public void setTetromino(Tetromino tetromino) {
        this.tetromino = tetromino;
    }

    /**
     * Gets the next active Tetromino.
     * @return
     */
    public Tetromino getNextTetromino() { return next; }

    /**
     * Sets the next active Tetromino.
     * @param next The next active Tetromino.
     */
    public void setNextTetromino(Tetromino next) { this.next = next; }

    /**
     * Gets the parent game engine.
     * @return The parent game engine.
     */
    public Tetris getParent() {
        return parent;
    }

    /**
     * Gets the 2D Block array representing the playing field.
     * @return The 2D block array representing the playing field.
     */
    public Block[][] getField() {
        return field;
    }

    /**
     * Gets the current score.
     * @return The current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the current score.
     * @param score The current score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Initialises a game state.
     * @param parent The parent game engine.
     * @param field The 2D block array representing the playing field.
     */
    GameState(Tetris parent, Block[][] field) {
        this.parent = parent;
        this.field = field;
        setTetromino(generate());
        setNextTetromino(generate());
    }

    /**
     * Generates a random Tetromino.
     * @return A random Tetromino.
     */
    public Tetromino generate() {
        try {
            // A little bit of reflection never hurt anybody :)
            return (Tetromino) tetrominos[ThreadLocalRandom.current().nextInt(0, tetrominos.length)].getConstructor(new Class[] { GameState.class }).newInstance(new Object[] { this });
        }catch(IllegalAccessException e) { // None of these should ever happen given the code is correct. However, if they do, the program will crash with an error message.
            throw new RuntimeException(e);
        }catch(InstantiationException e) {
            throw new RuntimeException(e);
        }catch(NoSuchMethodException e) {
            throw new RuntimeException(e);
        }catch(InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
