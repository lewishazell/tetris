package tetris.game.ui;

import tetris.game.Tetris;
import tetris.game.tetromino.*;
import tetris.game.tetromino.shapes.TetrominoBlock;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lewis on 12/10/16.
 */

/**
 * The playing field display.
 */
class Field extends JPanel {
    /**
     * The game engine.
     */
    private final Tetris tetris;

    /**
     * Gets the game engine.
     * @return The game engine.
     */
    private Tetris getTetris() {
        return tetris;
    }

    /**
     * Initialises a new playing field display.
     * @param tetris The game engine.
     */
    Field(Tetris tetris) {
        this.tetris = tetris;
        setBackground(Color.BLACK);
    }

    /**
     * Paints the display.
     * @param g Graphics drawing object.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        int ws = getWidth() / getTetris().getWidth(),
            hs = getHeight() / getTetris().getHeight();
        g.clearRect(0, 0, getWidth(), getHeight());
        Block[][] blocks = getTetris().toArray();
        for(int r = 0; r < getTetris().getHeight(); r++) {
            for(int c = 0; c < getTetris().getWidth(); c++) {
                if(blocks[r][c] != TetrominoBlock.EMPTY_BLOCK) {
                    graphics.setColor(getTetris().isOver() ? Color.GRAY : blocks[r][c].getColor());
                    graphics.fillRect(getX() + c * ws, getY() + r * hs, ws, hs);
                    graphics.setColor(Color.BLACK);
                    graphics.drawRect(getX() + c * ws, getY() + r * hs, ws, hs);
                }
            }
        }
    }
}
