package tetris.game.tetromino.shapes;

import tetris.game.tetromino.Block;

import java.awt.*;

/**
 * Created by ljhaze on 05/12/2016.
 */

/**
 * Represents a Block for a Tetromino.
 */
public final class TetrominoBlock implements Block {
    /**
     * Static (and final) EmptyBlock instance.
     */
    public static final EmptyBlock EMPTY_BLOCK = new EmptyBlock();
    /**
     * The color of the Block.
     */
    private Color color;

    /**
     * Gets the color of the Block.
     * @return The color of the Block.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Initialises a TetrominoBlock with a color.
     * @param c The color of the Block.
     */
    TetrominoBlock(Color c) {
        color = c;
    }
}
