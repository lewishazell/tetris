package tetris.game;

import tetris.game.tetromino.Block;
import tetris.game.tetromino.shapes.TetrominoBlock;

/**
 * Created by ljhaze on 09/12/2016.
 */
public abstract class Utils {
    /**
     * Creates a copy of a 2D Block array.
     * @param original The original array.
     * @return A copy of the original array.
     */
    public static Block[][] copyOf(Block[][] original) {
        Block[][] copy = new Block[original.length][original[0].length];
        copyTo(original, copy);
        return copy;
    }

    /**
     * Copies one 2D Block array to another.
     * @param original The original array.
     * @param copy The array to copy to.
     */
    public static void copyTo(Block[][] original, Block[][] copy) {
        int h = original.length;
        int w = original[0].length;
        for(int r = 0; r < h; r++)
            for(int c = 0; c < w; c++)
                copy[r][c] = original[r][c];
    }

    /**
     * Checks whether a row has been filled.
     * @param row The row to check.
     * @return TRUE if the row is filled, FALSE otherwise.
     */
    public static boolean isComplete(Block[] row) {
        int w = row.length;
        for(int c = 0; c < w; c++)
            if(row[c] == TetrominoBlock.EMPTY_BLOCK) return false;
        return true;
    }

    /**
     * Clears a row.
     * @param row The row to clear.
     */
    public static void clear(Block[] row) {
        int w = row.length;
        for(int c = 0; c < w; c++)
            row[c] = TetrominoBlock.EMPTY_BLOCK;
    }

    /**
     * Shifts all rows, above the specified starting row, down.
     * @param blocks The 2D array of blocks.
     * @param row The starting row.
     */
    public static void shift(Block[][] blocks, int row) {
        int h = blocks.length;
        int w = blocks[0].length;
        for(int r = row; r > 0; r--)
            for(int c = 0; c < w; c++)
                blocks[r][c] = blocks[r - 1][c];
        clear(blocks[0]);
    }

    /**
     * Calculates the X correction for a rotation.
     * @param rotations How many times the Tetromino has been rotated.
     * @param height The height of the Tetromino.
     * @param width The width of the Tetromino.
     * @return
     */
    public static int getXCorrection(int rotations, int height, int width) {
        switch(rotations) {
            case 1:
                return -(width - 1);
            case 2:
                return -(width - 1);
            default:
                return 0;
        }
    }

    /**
     * Calculates the Y correction for a rotation.
     * @param rotations How many times the Tetromino has been rotated.
     * @param height The height of the Tetromino.
     * @param width The width of the Tetromino.
     * @return
     */
    public static int getYCorrection(int rotations, int height, int width) {
        switch(rotations) {
            case 2:
                return - (height - 1);
            case 3:
                return - (height - 1);
            default:
                return 0;
        }
    }
}
