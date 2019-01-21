package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.Block;
import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Represents an I/Bar tetromino.
 */
public final class ITetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.CYAN);

    /**
     * Initialises a new I shaped Tetromino.
     * @param state THe game state.
     */
    public ITetromino(GameState state) {
        super(
            state,
            new Block[][] {
                { BLOCK },
                { BLOCK },
                { BLOCK },
                { BLOCK }
            }
        );
    }
}
