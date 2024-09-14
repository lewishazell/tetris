package tetris.game;

import tetris.game.tetromino.*;
import tetris.game.tetromino.shapes.*;

/**
 * Created by lewis on 11/29/16.
 */

/**
 * The game engine.
 */
public final class Tetris {
    /**
     * The game's state.
     */
    private final GameState state;

    /**
     * Gets the height of the playing field.
     * @return The height of the playing field.
     */
    public int getHeight() {
        return state.getField().length;
    }

    /**
     * Gets the width of the playing field.
     * @return The width of the playing field.
     */
    public int getWidth() {
        return state.getField()[0].length;
    }

    /**
     * Gets the active Tetromino.
     * @return The active Tetromino.
     */
    public Tetromino getTetromino() {
        return getState().getTetromino();
    }

    /**
     * Gets the next active Tetromino.
     * @return The next active Tetromino.
     */
    public Tetromino getNextTetromino() { return getState().getNextTetromino(); }

    /**
     * Gets the game state.
     * @return The game state.
     */
    private GameState getState() {
        return state;
    }

    /**
     * Gets the current score.
     * @return The current score.
     */
    public int getScore() {
        return getState().getScore();
    }

    /**
     * Gets whether the game is over.
     * @return TRUE if the game is over, FALSE otherwise.
     */
    public boolean isOver() {
        return getState().isOver();
    }

    /**
     * Initialises a Tetris playing field with the default size (h: 22, w: 10).
     */
    public Tetris() {
        this(22, 10);
    }

    /**
     * Initialises a Tetris playing field with the specified size.
     * @param height The height, in blocks, of the playing field.
     * @param width The width, in blocks, of the playing field.
     */
    public Tetris(int height, int width) {
        if(height < 4) throw new IllegalArgumentException("Argument 'height' must be greater than 4.");
        if(width < 4) throw new IllegalArgumentException("Argument 'width' must be greater than 4.");
        state = new GameState(this, new Block[height][width]);
        state.setTetromino(getState().generate());
        for(int r = 0; r < getHeight(); r++)
            for(int c = 0; c < getWidth(); c++)
                getState().getField()[r][c] = TetrominoBlock.EMPTY_BLOCK;
    }

    /**
     * Generates a string representing the internal 2D block array (field).
     * @return
     */
    @Override
    public String toString() {
        Block[][] a = toArray();
        String s = "";
        for(int r = 0; r < a.length; r++) {
            s += "{";
            for(int c = 0; c < a[0].length; c++)
                s+= (a[r][c] != TetrominoBlock.EMPTY_BLOCK ? "1" : "0") + (c != a[0].length - 1 ? ", " : "");
            s += "}";
        }
        return s;
    }

    /**
     * Creates a copy of the internal 2D block array.
     * @return A copy of the internal 2D block array.
     */
    public Block[][] toArray() {
        Block[][] a = Utils.copyOf(getState().getField());
        Block[][] shape = getTetromino().toArray();
        for (int r = 0; r < getTetromino().getHeight(); r++)
            for (int c = 0; c < getTetromino().getWidth(); c++)
                if (shape[r][c] != TetrominoBlock.EMPTY_BLOCK && getTetromino().getY() + r >= 0)
                    a[getTetromino().getY() + r][getTetromino().getX() + c] = shape[r][c];
        return a;
    }
}
