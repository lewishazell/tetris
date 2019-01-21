package tetris.game.tetromino.shapes;

import tetris.game.tetromino.*;

import java.awt.*;

/**
 * Created by ljhaze on 05/12/2016.
 */

/**
 * Represents an empty Tetromino block.
 */
public final class EmptyBlock implements Block {
    private static final Color INVISIBLE = new Color(0, 0, 0, 0);

    /**
     * Gets the color of the Block (invisible).
     * @return The color of the Block.
     */
    @Override
    public Color getColor() {
        return INVISIBLE;
    }

    /**
     * Initialises an empty block.
     */
    EmptyBlock() {

    }
}
