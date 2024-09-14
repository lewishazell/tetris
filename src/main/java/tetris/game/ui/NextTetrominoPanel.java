package tetris.game.ui;

import tetris.game.Tetris;
import tetris.game.tetromino.Block;
import tetris.game.tetromino.shapes.TetrominoBlock;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lewis on 12/11/16.
 */

/**
 * Next Tetromino display.
 */
class NextTetrominoPanel extends JPanel {
    /**
     * The game engine.
     */
    private final Tetris tetris;
    /**
     * The size of the blocks in the Tetrominos (in pixels).
     */
    private final int blockSize;

    /**
     * Gets the game engine.
     * @return The game engine.
     */
    private Tetris getTetris() {
        return tetris;
    }

    /**
     * Initialises a NextTetrominoPanel.
     * @param tetris The game engine.
     * @param blockSize The size of the blocks in the Tetrominos (in pixels).
     */
    NextTetrominoPanel(Tetris tetris, int blockSize) {
        this.tetris = tetris;
        this.blockSize = blockSize;
        setPreferredSize(new Dimension(4 * blockSize, 4 * blockSize));
    }

    /**
     * Paints the components
     * @param g The graphics drawing object.
     */
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(getBackground());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
        Block[][] blocks = getTetris().getNextTetromino().toArray();
        int h = getTetris().getNextTetromino().getHeight(),
            w = getTetris().getNextTetromino().getWidth();
        for(int r = 0; r < h; r++) {
            for(int c = 0; c < w; c++) {
                if(blocks[r][c] != TetrominoBlock.EMPTY_BLOCK) {
                    graphics.setColor(getTetris().isOver() ? Color.GRAY : blocks[r][c].getColor());
                    graphics.fillRect(getX() + (getWidth() / 2) - (((w * blockSize) / 2)) + c * blockSize, getY() + r * blockSize, blockSize, blockSize);
                    graphics.setColor(Color.BLACK);
                    graphics.drawRect(getX() + (getWidth() / 2) - (((w * blockSize) / 2)) + c * blockSize, getY() + r * blockSize, blockSize, blockSize);
                }
            }
        }
    }
}
