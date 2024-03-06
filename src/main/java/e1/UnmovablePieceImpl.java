package e1;

public class UnmovablePieceImpl extends AbstractMovablePiece {

    public UnmovablePieceImpl() {
        super();
    }

    public UnmovablePieceImpl(final int x, final int y) {
        super(x, y);
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> newPosition) {
        return false;
    }
    
}
