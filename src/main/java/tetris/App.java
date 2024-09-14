package tetris;

import tetris.ui.GameFrame;

import javax.swing.*;

/**
 * Created by lewis on 11/17/16.
 */
public class App {
    /**
     * Program entry point.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
