package tetris.game.tetromino.shapes;

import tetris.game.GameState;
import tetris.game.tetromino.*;
import java.awt.*;

/**
 * Created by lewis on 11/17/16.
 */
public final class TTetromino extends Shape {
    private static final Block BLOCK = new TetrominoBlock(Color.MAGENTA);

    public TTetromino(GameState state) {
        super(
                state,
                new Block[][] {
                { BLOCK,  TetrominoBlock.EMPTY_BLOCK },
                { BLOCK,                       BLOCK },
                { BLOCK, TetrominoBlock.EMPTY_BLOCK}
            }
        );
    }
}
