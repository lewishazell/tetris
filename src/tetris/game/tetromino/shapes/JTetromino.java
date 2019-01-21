package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.Block;

import java.awt.*;

/**
 * Created by lewis on 11/18/16.
 */

/**
 * Represents a J shaped Tetromino.
 */
public class JTetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.BLUE);

    /**
     * Initialises a J shaped Tetromino.
     * @param state The game state.
     */
    public JTetromino(GameState state) {
        super(
                state,
                new Block[][] {
                {                      BLOCK,                      BLOCK, BLOCK },
                { TetrominoBlock.EMPTY_BLOCK, TetrominoBlock.EMPTY_BLOCK, BLOCK },
            }
        );
    }
}
