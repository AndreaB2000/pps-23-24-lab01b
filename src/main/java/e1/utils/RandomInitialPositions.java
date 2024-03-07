package e1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInitialPositions implements InitialPositions {

    private final int boardSize;
	private final Random random = new Random();
    private final List<Pair<Integer, Integer>> takenPositions;

    public RandomInitialPositions(final int boardSize) {
        this.boardSize = boardSize;
        this.takenPositions = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return this.takenPositions.size() < this.boardSize * this.boardSize;
    }

    @Override
    public Pair<Integer, Integer> next() {
        return generateEmptyPosition();
    }

    private Pair<Integer, Integer> generateEmptyPosition() {
    	var newPosition = new Pair<>(this.random.nextInt(boardSize), this.random.nextInt(boardSize));
        if (this.takenPositions.contains(newPosition)) {
            return generateEmptyPosition();
        } else {
            this.takenPositions.add(newPosition);
            return newPosition;
        }
    }

}
