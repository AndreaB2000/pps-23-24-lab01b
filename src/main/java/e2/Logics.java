package e2;

public interface Logics {
    void hitCell(final Pair<Integer, Integer> position);
    void flagCell(final Pair<Integer, Integer> position);
    boolean isThereAMine(final Pair<Integer, Integer> position);
    boolean isGameOver();
    boolean hasBeenHit(final Pair<Integer, Integer> position);
}
