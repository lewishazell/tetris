package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.Block;
import tetris.game.tetromino.Rotation;

import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Represents an O shaped Tetromino.
 */
public final class OTetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.YELLOW);

    /**
     * Initialises an O shaped Tetromino.
     * @param state The game state.
     */
    public OTetromino(GameState state) {
        super(
                state,
                new Block[][] {
                { BLOCK, BLOCK },
                { BLOCK, BLOCK },
            }
        );
    }

    /**
     * Override for rotation. This Tetromino has rotational symmetry, so does not need to be rotated.
     * @param direction The direction to rotate the Tetromino (Clockwise/Anti-clockwise)
     */
    @Override
    public void rotate(Rotation direction) {
        // This shape has rotational symmetry, so no rotation is required
        setRotations(getRotations() + direction.getValue());
    }
}
