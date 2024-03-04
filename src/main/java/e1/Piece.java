package e1;

public interface Piece {

    /**
     * @return The X coordinate of the piece.
     */
    int getX();

    /**
     * @return The Y coordinate of the piece.
     */
    int getY();

    void move(final int deltaX, final int deltaY);
}
