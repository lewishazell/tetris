package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.Block;

import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Represents an S shaped Tetromino.
 */
public final class STetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.YELLOW);

    /**
     * Initialises an S shaped Tetromino.
     * @param state The game state.
     */
    public STetromino(GameState state) {
        super(
                state,
                new Block[][] {
                        {                      BLOCK, TetrominoBlock.EMPTY_BLOCK },
                        {                      BLOCK,                      BLOCK },
                        { TetrominoBlock.EMPTY_BLOCK,                      BLOCK }
            }
        );
    }
}
