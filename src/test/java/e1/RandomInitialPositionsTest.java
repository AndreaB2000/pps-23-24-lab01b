package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.utils.RandomInitialPositions;
import e1.utils.InitialPositions;
import e1.utils.Pair;

public class RandomInitialPositionsTest {

    private int boardSize = 5;
    private InitialPositions initialPositions;

    @BeforeEach
    public void beforeEach() {
        this.initialPositions = new RandomInitialPositions(this.boardSize);
    }
    
    @Test
    public void testInstantiation() {
        assertNotNull(initialPositions);
    }

    @Test
    public void testHasNextAfterInstantiation() {
        assertTrue(initialPositions.hasNext());
    }

    @Test
    public void testNextsAreDifferent() {
        var results = new HashSet<Pair<Integer, Integer>>();
        for (int i = 0; i < this.boardSize * this.boardSize; i++) {
            results.add(this.initialPositions.next());
        }
        assertEquals(this.boardSize * this.boardSize, results.size());
    }

    @Test
    public void testHasNotNextAfterNSquareNexts() {
        var results = new HashSet<Pair<Integer, Integer>>();
        for (int i = 0; i < this.boardSize * this.boardSize; i++) {
            results.add(this.initialPositions.next());
        }
        assertFalse(this.initialPositions.hasNext());
    }
}
