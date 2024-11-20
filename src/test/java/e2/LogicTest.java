package e2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

    @Test
    public void testInstantiation() {
        Logics logics = new LogicsImpl(7, 6);
        assertNotNull(logics);
    }

    @Test
    public void testMinesNumber() {
        Logics logics = new LogicsImpl(7, 6);
        int numberOfMines = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(i);
                System.out.println(j);
                if (logics.isThereAMine(new Pair<>(i, j))) {
                    numberOfMines++;
                }
            }
        } 
        assertEquals(6, numberOfMines);
    }
}
