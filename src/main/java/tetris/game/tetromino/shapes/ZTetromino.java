package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.*;
import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */
public final class ZTetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.RED);

    public ZTetromino(GameState state) {
        super(
                state,
                new Block[][]{
                        {                     BLOCK, BLOCK, TetrominoBlock.EMPTY_BLOCK},
                        {TetrominoBlock.EMPTY_BLOCK, BLOCK,                      BLOCK},
                }
        );
    }
}
