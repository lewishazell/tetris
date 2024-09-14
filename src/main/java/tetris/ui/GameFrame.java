package tetris.ui;

import tetris.game.Tetris;
import tetris.game.ui.Display;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by lewis on 12/10/16.
 */

/**
 * The main game frame.
 */
public class GameFrame extends JFrame {
    /**
     * The game display.
     */
    private Display tetris;

    /**
     * Initialises a GameFrame.
     */
    public GameFrame() {
        int blockSize = 32;
        try {
            tetris = new Display(new Tetris(20, 10), blockSize, true, "music.wav"); // Comment for no music (if you have problems).
        }catch(IOException ex) {
            System.out.println(ex);
            tetris = new Display(new Tetris(20, 10), blockSize);
        }catch(UnsupportedAudioFileException ex) {
            System.out.println(ex);
            tetris = new Display(new Tetris(20, 10), blockSize);
        }catch(LineUnavailableException ex) {
            System.out.println(ex);
            tetris = new Display(new Tetris(20, 10), blockSize);
        }finally{
            tetris.setLocation(0, 0);
            setBackground(Color.BLACK);
            setLayout(null);
            getContentPane().setPreferredSize(new Dimension(tetris.getWidth(), tetris.getHeight()));
            pack();
            getContentPane().add(tetris);
            addKeyListener(tetris);
            addMouseListener(tetris);
            setTitle("Tetris by Lewis Hazell (1505144)");
            setVisible(true);
        }
    }


}
