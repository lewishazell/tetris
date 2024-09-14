package tetris.game.tetromino.shapes;

import tetris.game.GameOverException;
import tetris.game.GameState;
import tetris.game.Tetris;
import tetris.game.Utils;
import tetris.game.tetromino.*;

import java.util.function.BiPredicate;

/**
 * Created by lewis on 11/17/16.
 */

/**
 * Abstract Tetromino shape.
 */
abstract class Shape implements Tetromino {
    /**
     * Co-ordinates.
     */
    private int x = 3, y, rotations = 0;
    /**
     * 2D array of blocks that make the shape.
     */
    protected Block[][] blocks;
    /**
     * The game state.
     */
    private final GameState state;

    /**
     * Gets the x ordinate of the Tetromino.
     * @return The x ordinate of the Tetromino.
     */
    @Override
    public int getX() {
        return x + Utils.getXCorrection(getRotations(), getHeight(), getWidth());
    }

    /**
     * Gets the y ordinate of the Tetromino.
     * @return The y ordinate of the Tetromino.
     */
    @Override
    public int getY() {
        return y + Utils.getYCorrection(getRotations(), getHeight(), getWidth());
    }

    /**
     * Gets the height of the Tetromino
     * @return
     */
    @Override
    public int getHeight() {
        return blocks.length;
    }

    /**
     * Gets the width of the Tetromino.
     * @return The width of the Tetromino.
     */
    @Override
    public int getWidth() {
        return blocks[0].length;
    }

    /**
     * Gets the parent game engine.
     * @return The parent game engine.
     */
    @Override
    public Tetris getParent() { return getState().getParent(); }

    /**
     * Gets whether the Tetromino is active.
     * @return TRUE if the Tetromio is active, FALSE otherwise.
     */
    @Override
    public boolean isActive() { return state.getTetromino() == this; }

    /**
     * Gets the game state.
     * @return The game state.
     */
    private GameState getState() {
        return state;
    }

    protected int getRotations() {
        return rotations;
    }

    protected void setRotations(int rotations) {
        if(rotations >= 4)
            this.rotations = rotations % 4;
        else if(rotations < 0)
            this.rotations = 4 - ((-rotations) % 4);
        else
            this.rotations = rotations;
    }

    /**
     * Superclass initialiser. Sets the GameState, 2D block array and initial y ordinate.
     * @param state The game state.
     * @param blocks The 2D block array.
     */
    protected Shape(GameState state, Block[][] blocks) {
        this.state = state;
        this.blocks = blocks;
        y = -getHeight();
    }

    /**
     * Generalised search for collisions.
     * @param rangePredicate Predicate to check whether or not the r and c values are out of range for the search. The second predicate is only run if this is true.
     * @param collisionPredicate Predicate to check whether or not a collision has occoured.
     * @return TRUE if a collision has occoured, FALSE otherwise.
     */
    private boolean checkCollision(BiPredicate<Integer, Integer> rangePredicate, BiPredicate<Integer, Integer> collisionPredicate) {
        for(int r = 0; r < getHeight(); r++)
            for(int c = 0; c < getWidth(); c++)
                if(rangePredicate.test(r, c))
                    if(collisionPredicate.test(r, c))
                        return true;
        return false;
    }

    /**
     * Rotates the Tetromino.
     * @param direction The direction to rotate the Tetromino (Clockwise/Anti-clockwise)
     * @throws CannotRotateException
     * @throws InactiveTetrominoException
     */
    @Override
    public void rotate(Rotation direction) throws CannotRotateException, InactiveTetrominoException {
        if(!isActive()) throw new InactiveTetrominoException("Attempt to act on an inactive Tetromino.");
        boolean cw = direction == Rotation.CLOCKWISE;
        int w = blocks.length;
        int h = blocks[0].length;
        // Swapped height and width because the array will be rotated
        Block[][] rotated = new Block[h][w];
        for(int r = 0; r < w; r++)
            for(int c = 0; c < h; c++)
                rotated[c][cw ? w - 1 - r : r] = blocks[r][cw ? c : h - 1 - c];
        int x = this.x + Utils.getXCorrection(getRotations() + direction.getValue(), h, w);
        int y = this.y + Utils.getYCorrection(getRotations() + direction.getValue(), h, w);
        if(y + h > getState().getParent().getHeight())
            throw new CannotRotateException("The Shape cannot be rotated because it would go through the playing field floor.");
        if(x + w > getState().getParent().getWidth() || x < 0)
            throw new CannotRotateException("The Shape cannot be rotated because it would go through the playing field wall.");
        if(checkCollision((r, c) -> y + c >= 0, (r, c) -> getState().getField()[y + c][x + r] != TetrominoBlock.EMPTY_BLOCK && rotated[c][r] != TetrominoBlock.EMPTY_BLOCK))
            throw new CannotRotateException("The Shape cannot be rotated because it would overlap an existing block.");
        blocks = rotated;
        setRotations(getRotations() + direction.getValue());
    }

    /**
     * Creates a copy of the Tetromino's internal 2D Block array.
     * @return A copy of the Tetromino's internal 2D Block array.
     */
    @Override
    public Block[][] toArray() {
        // Defensive copy (disallow modification of internal array)
        return Utils.copyOf(blocks);
    }

    /**
     * Moves the Tetromino left or right.
     * @param direction The direction to move the Tetromino (LEFT or RIGHT).
     * @throws CollisionException
     * @throws InactiveTetrominoException
     */
    @Override
    public void move(Direction direction) throws CollisionException, InactiveTetrominoException {
        if(!isActive()) throw new InactiveTetrominoException("Attempt to act on an inactive Tetromino.");
        int dx = direction == Direction.LEFT ? -1 : 1;
        if(getX() + dx < 0 || getX() + getWidth() + dx > getState().getField()[0].length)
            throw new CollisionException("The Tetromino has collided with the side of the playing field.");
        if(checkCollision((r, c) -> getY() + r >= 0, (r, c) -> getState().getField()[getY() + r][getX() + c + dx] != TetrominoBlock.EMPTY_BLOCK && blocks[r][c] != TetrominoBlock.EMPTY_BLOCK))
            throw new CollisionException("The Tetromino has collided with the side of a block.");
        x += dx;
    }

    /**
     * Makes the Tetromino fall down the playing field (moves it down).
     * @throws CollisionException
     * @throws InactiveTetrominoException
     * @throws GameOverException
     */
    @Override
    public void fall() throws CollisionException, InactiveTetrominoException, GameOverException {
        if(!isActive()) throw new InactiveTetrominoException("Attempt to act on an inactive Tetromino.");
        try {
            if (getY() + getHeight() == getState().getField().length)
                throw new CollisionException("The Tetromino has collided with the bottom of the playing field.");
            if (checkCollision((r, c) -> r + getY() + 1 >= 0, (r, c) -> getState().getField()[r + getY() + 1][c + getX()] != TetrominoBlock.EMPTY_BLOCK && blocks[r][c] != TetrominoBlock.EMPTY_BLOCK))
                throw new CollisionException("The Tetromino has collided with a block.");
            y++;
        }catch(CollisionException ex) {
            Utils.copyTo(getParent().toArray(), getState().getField());
            if(getY() < 0) {
                getState().setOver(true);
                throw new GameOverException("The Tetrominos have stacked to the top and the game is over.", ex);
            }
            for(int r = getY(); r < getY() + getHeight(); r++) {
                if (Utils.isComplete(getState().getField()[r])) {
                    Utils.shift(getState().getField(), r);
                    getState().setScore(getState().getScore() + 10);
                }
            }
            getState().setTetromino(getState().getNextTetromino());
            getState().setNextTetromino(getState().generate());
            throw ex;
        }
    }

    /**
     * Creates a String representing the internal array of the Tetromino.
     * @return A String representing the internal array of the Tetromino.
     */
    @Override
    public String toString() {
        String s = "";
        for(int r = 0; r < blocks.length; r++) {
            s += "{";
            for(int c = 0; c < blocks[0].length; c++)
                s+= (blocks[r][c] != TetrominoBlock.EMPTY_BLOCK ? "1" : "0") + (c != blocks[0].length - 1 ? ", " : "");
            s += "}";
        }
        return s;
    }
}
