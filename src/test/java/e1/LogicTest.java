package e1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    private final int size = 5;

    @BeforeEach
    public void beforeEach() {
        this.logics = new LogicsImpl(this.size);
    }
    
    @Test
    public void testInstantiation() {
        assertNotNull(this.logics);
    }

    @Test
    public void testKnightPresence() {
        var knightPosition = this.getKnightPosition();
        assertAll(
            () -> assertNotEquals(-1, knightPosition.getX()),
            () -> assertNotEquals(-1, knightPosition.getY())
        );
    }

    @Test
    public void testPawnPresence() {
        var pawnPosition = this.getPawnPosition();
        assertAll(
            () -> assertNotEquals(-1, pawnPosition.getX()),
            () -> assertNotEquals(-1, pawnPosition.getY())
        );
    }

    private Pair<Integer, Integer> getKnightPosition() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.logics.hasKnight(i, j)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return new Pair<>(-1, -1);
    }

    private Pair<Integer, Integer> getPawnPosition() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.logics.hasPawn(i, j)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return new Pair<>(-1, -1);
    }

    @Test
    public void testPiecesNotOverlap() {
        var knightPosition = this.getKnightPosition();
        var pawnPosition = this.getPawnPosition();
        assertFalse(
            knightPosition.getX() == pawnPosition.getX() && 
            knightPosition.getY() == pawnPosition.getY()
        );
    }

    // This test does not cover all possible moves of the piece
    @Test
    public void testHitMovement() {
        var knightPositionBeforeHit = this.getKnightPosition();
        int deltaX = (knightPositionBeforeHit.getX() > this.size / 2) ? -1 : 1;
        int deltaY = (knightPositionBeforeHit.getY() > this.size / 2) ? -2 : 2;
        this.logics.hit(
            knightPositionBeforeHit.getX() + deltaX,
            knightPositionBeforeHit.getY() + deltaY
        );
        var knightPositionAfterHit = this.getKnightPosition();
        assertAll(
            () -> assertEquals(knightPositionBeforeHit.getX() + deltaX, knightPositionAfterHit.getX()),
            () -> assertEquals(knightPositionBeforeHit.getY() + deltaY, knightPositionAfterHit.getY())
        );
    }

    // Additional tests after small additions to LogicsImpl

    @Test
    public void testInstantnationPassingPiecesPositions() {
        var pawnPosition = new Pair<>(0, (int) this.size / 2);
        var knightPosition = new Pair<>((int) this.size / 2, 0);
        var newLogics = new LogicsImpl(this.size, pawnPosition, knightPosition);
        assertNotNull(newLogics);
    }

    @Test
    public void testWrongSizeInstantiation() {
       assertThrows(IllegalArgumentException.class, () -> {
        var wrongLogic = new LogicsImpl(1);
        wrongLogic.hasKnight(0, 0);
       }); 
    }
}
