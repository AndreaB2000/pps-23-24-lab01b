package e1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {

    private Piece piece;
    private final int pieceInitialX = 1;
    private final int pieceInitialY = 1;
    private final int deltaX = 1;
    private final int deltaY = 1;

    @BeforeEach
    public void beforeEach() {
        this.piece = new PieceImpl(this.pieceInitialX, this.pieceInitialY);
    }
   
    @Test
    public void testInstantiation() {
        Piece defaultCoordinatesPiece = new PieceImpl();
        assertNotNull(defaultCoordinatesPiece);
    }

    @Test
    public void testInstantiationWithGivenCoordinates() {
        assertNotNull(this.piece);
    }

    @Test
    public void testCoordinates() {
        assertAll(
            () -> assertEquals(this.pieceInitialX, this.piece.getX()),
            () -> assertEquals(this.pieceInitialY, this.piece.getY())
        );
    }

    @Test
    public void testMove() {
        this.piece.move(this.deltaX, this.deltaY);
        assertAll(
            () -> assertEquals(this.pieceInitialX + this.deltaX, this.piece.getX()),
            () -> assertEquals(this.pieceInitialY + this.deltaY, this.piece.getY())
        );
    }
}
