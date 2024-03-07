package e1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.pieces.AbstractMovablePiece;
import e1.pieces.MovablePiece;
import e1.utils.Pair;

public class PieceTest {

    private MovablePiece piece;
    private final int pieceInitialX = 1;
    private final int pieceInitialY = 1;
    private final int correctDeltaX = 1;
    private final int correctDeltaY = 2;
    private final int wrongDeltaX = 1;
    private final int wrongDeltaY = 1;

    @BeforeEach
    public void beforeEach() {
        this.piece = new AbstractMovablePiece(new Pair<>(this.pieceInitialX, this.pieceInitialY)) {
			@Override
			public boolean canMove(Pair<Integer, Integer> newPosition) {
				var deltaX = newPosition.getX() - this.getX();
				var deltaY = newPosition.getY() - this.getY();
				return deltaX != 0 && deltaY != 0 && Math.abs(deltaX) + Math.abs(deltaY) == 3;
			}
		};
    }
   
    @Test
    public void testInstantiation() {
        assertNotNull(this.piece);
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
    public void testCorrectMove() {
        this.piece.move(
            new Pair<>(
                this.piece.getX() + this.correctDeltaX,
                this.piece.getY() + this.correctDeltaY
            )
        );
        assertAll(
            () -> assertEquals(this.pieceInitialX + this.correctDeltaX, this.piece.getX()),
            () -> assertEquals(this.pieceInitialY + this.correctDeltaY, this.piece.getY())
        );
    }

    @Test
    public void testWrongMove() {
        this.piece.move(
            new Pair<>(
                this.pieceInitialX + this.wrongDeltaX,
                this.pieceInitialY + this.wrongDeltaY
            )
        );
        assertAll(
            () -> assertEquals(this.pieceInitialX, this.piece.getX()),
            () -> assertEquals(this.pieceInitialY, this.piece.getY())
        );
    }
}
