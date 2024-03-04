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

    /**
     * Moves the piece in the direction expressed by parameters.
     * 
     * @param deltaX - Offset on X axis
     * @param deltaY - Offset on Y axis
     */
    void move(final int deltaX, final int deltaY);
}
