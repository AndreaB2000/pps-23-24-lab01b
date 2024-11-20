package e2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final List<Pair<Integer, Integer>> mines;
    private final Random random;

    public LogicsImpl(int size, int numberOfMines) {
        this.mines = new LinkedList<>();
        this.random = new Random();
        for (int i = 0; i < numberOfMines; i++) {
            this.mines.add(this.generateNewMinePosition());
        }
    }

    private Pair<Integer, Integer> generateNewMinePosition() {
        var newPosition = new Pair<>(this.random.nextInt(), this.random.nextInt());
        if (this.mines.contains(newPosition)) {
            return this.generateNewMinePosition();
        } else {
            return newPosition;
        }
    }

    @Override
    public void hitCell(Pair<Integer, Integer> position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hitCell'");
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flagCell'");
    }

    @Override
    public boolean isThereAMine(Pair<Integer, Integer> position) {
        return this.mines.contains(position);
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameOver'");
    }

    @Override
    public boolean hasBeenHit(Pair<Integer, Integer> position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBeenHit'");
    } 

}
