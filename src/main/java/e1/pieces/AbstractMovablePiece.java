package e1.pieces;

import e1.utils.Pair;

public abstract class AbstractMovablePiece implements MovablePiece, UnmovablePiece {

    private Pair<Integer, Integer> coordinates;

    protected AbstractMovablePiece() {
        this.coordinates = new Pair<>(0, 0);
    }
    
    protected AbstractMovablePiece(Pair<Integer, Integer> initialPosition) {
        this.coordinates = new Pair<>(
            initialPosition.getX(),
            initialPosition.getY()
        );
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
