package e1.logics;

import e1.pieces.MovablePiece;
import e1.pieces.PiecesFactory;
import e1.pieces.PiecesFactoryImpl;
import e1.pieces.UnmovablePiece;
import e1.utils.RandomInitialPositions;
import e1.utils.Pair;

public class LogicsImpl implements Logics {
	
	private UnmovablePiece pawn;
	private MovablePiece knight;
	private RandomInitialPositions initialPositions;
	private int boardSize;

	public LogicsImpl(int boardSize, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.exceptIfBoardSizeIsOne(boardSize);
		this.initializeLogics(boardSize, pawnPosition, knightPosition);
	}
	 
    public LogicsImpl(int boardSize) {
		this.exceptIfBoardSizeIsOne(boardSize);
		this.initialPositions = new RandomInitialPositions(boardSize);
		this.initializeLogics(boardSize, this.initialPositions.next(), this.initialPositions.next());
    }

	private void exceptIfBoardSizeIsOne(final int boardSize) {
		if (boardSize == 1) {
			throw new IllegalArgumentException("Board size must be more than 1.");
		}
	}

	private void initializeLogics(int boardSize, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		final PiecesFactory piecesFactory = new PiecesFactoryImpl();
		this.boardSize = boardSize;
		this.pawn = piecesFactory.createPawn(pawnPosition);
		this.knight = piecesFactory.createKnight(knightPosition);
	}
    
	@Override
	public boolean hit(int row, int column) {
		if (row < 0 || column < 0 || row >= this.boardSize || column >= this.boardSize) {
			throw new IndexOutOfBoundsException("Position must be inside of the board.");
		}
		this.knight.move(new Pair<>(row, column));
		return this.pawn.getX() == this.knight.getX() && this.pawn.getY() == this.knight.getY();
	}

	@Override
	public boolean hasKnight(int row, int column) {
		return this.knight.getX() == row && this.knight.getY() == column;
	}

	@Override
	public boolean hasPawn(int row, int column) {
		return this.pawn.getX() == row && this.pawn.getY() == column;
	}
}
