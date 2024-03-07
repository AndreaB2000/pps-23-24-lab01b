package e1.pieces;

import e1.utils.Pair;

public class PiecesFactoryImpl implements PiecesFactory {

    @Override
    public UnmovablePiece createPawn(Pair<Integer, Integer> initialPosition) {
        return new UnmovablePieceImpl(initialPosition);
    }

    @Override
    public MovablePiece createKnight(Pair<Integer, Integer> initialPosition) {
        return new AbstractMovablePiece(initialPosition) {
            @Override
            public boolean canMove(Pair<Integer, Integer> newPosition) {
				var deltaX = newPosition.getX() - this.getX();
				var deltaY = newPosition.getY() - this.getY();
				return deltaX != 0 && deltaY != 0 && Math.abs(deltaX) + Math.abs(deltaY) == 3;
            }
        };
    }
    
}
