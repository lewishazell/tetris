package tetris.game.tetromino;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Enumeration representing rotation direction (CLOCKWISE or ANTI_CLOCKWISE).
 */
public enum Rotation {
    CLOCKWISE(1),
    ANTI_CLOCKWISE(-1);

    private final int value;

    public int getValue() {
        return value;
    }

    private Rotation(int value) {
        this.value = value;
    }
}
