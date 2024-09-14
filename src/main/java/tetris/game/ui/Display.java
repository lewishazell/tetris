package tetris.game.ui;

import tetris.game.Tetris;
import tetris.game.GameOverException;
import tetris.game.TetrisException;
import tetris.game.tetromino.CollisionException;
import tetris.game.tetromino.Direction;
import tetris.game.tetromino.Rotation;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

/**
 * Created by lewis on 12/11/16.
 */

/**
 * Tetris game display.
 */
public final class Display extends JPanel implements KeyListener, MouseListener {
    /**
     * The game engine.
     */
    private final Tetris tetris;
    /**
     * The playing field display.
     */
    private final Field field;
    /**
     * The side panel (scores and next tetromino) display.
     */
    private final SidePanel panel;
    /**
     * The tetromino fall timer.
     */
    private final Timer fall;
    /**
     * The music player.
     */
    private Clip music;

    private int blockSize;

    /**
     * Gets the game engine.
     * @return The game engine.
     */
    private Tetris getTetris() {
        return tetris;
    }

    /**
     * Sets whether the music is playing or not.
     * @param play Boolean to determine whether or not to play music.
     */
    public void playMusic(boolean play) {
        if(music != null && play)
            music.loop(Clip.LOOP_CONTINUOUSLY);
        else
            music.stop();
    }

    /**
     * Initialises a Tetris game display.
     * @param tetris The game engine.
     * @param playMusic Whether to play music or not.
     */
    public Display(Tetris tetris, int blockSize, boolean playMusic, String musicFile) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this(tetris, blockSize);
        music = AudioSystem.getClip();
        if(musicFile != null) music.open(AudioSystem.getAudioInputStream(new File(musicFile)));
        playMusic(playMusic);
    }

    /**
     * Initialises a Tetris game display.
     * @param tetris The game engine.
     */
    public Display(Tetris tetris, int blockSize) {
        setLayout(null);
        this.tetris = tetris;
        this.blockSize = blockSize;
        field = new Field(tetris);
        panel = new SidePanel(tetris);
        add(field);
        add(panel);
        setSize(2 * tetris.getWidth() * blockSize, tetris.getHeight() * blockSize);
        fall = new Timer(1000, e -> {
            fall();
        });
        fall.start();
    }

    /**
     * Stops the music and shows the game over message.
     */
    private void gameOver() {
        fall.stop();
        playMusic(false);
        panel.update();
    }

    /**
     * Makes the active Tetromino fall.
     */
    private void fall() {
        try {
            getTetris().getTetromino().fall();
        }catch(TetrisException ex) {
            if(ex instanceof CollisionException)
                panel.update();
            else if(ex instanceof GameOverException)
                gameOver();
        }
        repaint();
    }

    /**
     * Sets the size of the Tetris game Display.
     * @param w The width of the display.
     * @param h The height of the display.
     */
    @Override
    public void setSize(int w, int h) {
        super.setSize(w, h);
        field.setSize((int) w / 2, h);
        panel.setSize((int) w / 2, h);
    }

    /**
     * Sets the location of the Tetris game Display.
     * @param x The x ordinate.
     * @param y The y ordinate.
     */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        field.setLocation(x, y);
        panel.setLocation(x + field.getWidth(), y);
    }

    public void keyTyped(KeyEvent e) {

    }

    /**
     * Handles a key press.
     * @param e The key press event.
     */
    public void keyPressed(KeyEvent e) {
        try {
            switch (e.getKeyCode()) {
                case VK_LEFT:
                case VK_A:
                    getTetris().getTetromino().move(Direction.LEFT);
                    break;
                case VK_RIGHT:
                case VK_D:
                    getTetris().getTetromino().move(Direction.RIGHT);
                    break;
                case VK_DOWN:
                case VK_S:
                    fall.restart();
                    fall();
                    break;
                case VK_Q:
                    getTetris().getTetromino().rotate(Rotation.ANTI_CLOCKWISE);
                    break;
                case VK_E:
                    getTetris().getTetromino().rotate(Rotation.CLOCKWISE);
                    break;
            }
            field.repaint();
        }catch(TetrisException ex) {
            // Nothing needs to be done, these exceptions don't imply failure.
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        try {
            if (SwingUtilities.isLeftMouseButton(e)) {
                getTetris().getTetromino().move(Direction.LEFT);
            } else if (SwingUtilities.isRightMouseButton(e)) {
                getTetris().getTetromino().move(Direction.RIGHT);
            } else if (SwingUtilities.isMiddleMouseButton(e)) {
                getTetris().getTetromino().rotate(Rotation.CLOCKWISE);
            }
        }catch(TetrisException ex) {
            // Nothing needs to be done...
        }
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}


}
