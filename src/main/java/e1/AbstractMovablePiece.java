package e1;

public abstract class AbstractMovablePiece implements MovablePiece, UnmovablePiece {

    private Pair<Integer, Integer> coordinates;

    public AbstractMovablePiece() {
        this.coordinates = new Pair<>(0, 0);
    }
    
    public AbstractMovablePiece(final int x, final int y) {
        this.coordinates = new Pair<>(x, y);
    }

    @Override
    public int getX() {
        return this.coordinates.getX();
    }

    @Override
    public int getY() {
        return this.coordinates.getY();
    }

    public abstract boolean canMove(Pair<Integer, Integer> newPosition);

    @Override
    public void move(final Pair<Integer, Integer> newPosition) {
        if (this.canMove(newPosition)) {
            this.coordinates = new Pair<>(
                newPosition.getX(),
                newPosition.getY()
            );
        }
    }
}
