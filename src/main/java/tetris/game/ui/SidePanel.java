package tetris.game.ui;

import tetris.game.Tetris;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lewis on 12/10/16.
 */

/**
 * Side panel display.
 */
class SidePanel extends JPanel {
    /**
     * The game engine.
     */
    private final Tetris tetris;
    /**
     * The score label.
     */
    private final JLabel score = new JLabel("Score: 0", SwingConstants.CENTER);
    /**
     * The title label.
     */
    private final JLabel title = new JLabel("Tetris", SwingConstants.CENTER);
    /**
     * The next Tetromino display.
     */
    private final NextTetrominoPanel next;

    /**
     * Gets the game engine.
     * @return The game engine.
     */
    private Tetris getTetris() {
        return tetris;
    }

    /**
     * Initialises a side panel.
     * @param tetris The game engine.
     */
    SidePanel(Tetris tetris) {
        this.tetris = tetris;
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
        score.setForeground(Color.WHITE);
        score.setFont(new Font(score.getFont().getName(), Font.PLAIN, 14));
        JPanel top = new JPanel();
        top.setBackground(Color.DARK_GRAY);
        add(top, BorderLayout.NORTH);
        top.setLayout(new BorderLayout());
        top.add(title, BorderLayout.NORTH);
        top.add(score, BorderLayout.CENTER);
        next = new NextTetrominoPanel(tetris, 24);
        next.setBackground(getBackground());
        add(next, BorderLayout.CENTER);
    }

    /**
     * Updates the side panel.
     */
    public void update() {
        score.setText("Score: " + tetris.getScore());
        if(tetris.isOver()) title.setText("Game over");
    }
}
