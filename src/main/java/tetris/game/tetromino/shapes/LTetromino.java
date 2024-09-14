package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.Block;

import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */
public final class LTetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.ORANGE);

    public LTetromino(GameState state) {
        super(
                state,
                new Block[][] {
                        { BLOCK, TetrominoBlock.EMPTY_BLOCK },
                        { BLOCK, TetrominoBlock.EMPTY_BLOCK },
                        { BLOCK,                      BLOCK }
            }
        );
    }
}
