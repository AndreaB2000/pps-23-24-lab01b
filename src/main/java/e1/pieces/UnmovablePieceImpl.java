package e1.pieces;

import e1.utils.Pair;

public class UnmovablePieceImpl extends AbstractMovablePiece {

    public UnmovablePieceImpl() {
        super();
    }

    protected UnmovablePieceImpl(final Pair<Integer, Integer> initialPosition) {
        super(initialPosition);
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> newPosition) {
        return false;
    }
    
}
