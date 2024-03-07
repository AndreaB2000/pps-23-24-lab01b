package e1.pieces;

import e1.utils.Pair;

public interface PiecesFactory {
    UnmovablePiece createPawn(Pair<Integer, Integer> initialPosition);
    MovablePiece createKnight(Pair<Integer, Integer> initialPosition);
}
