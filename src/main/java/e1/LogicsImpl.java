package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private UnmovablePiece pawn;
	private Piece knight;
	private final Random random = new Random();
	private int boardSize;

	public LogicsImpl(int boardSize, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.setBoardSize(boardSize);
		this.pawn = new PieceImpl(pawnPosition.getX(), pawnPosition.getY());
		this.knight = new PieceImpl(knightPosition.getX(), knightPosition.getY());
	}
	 
    public LogicsImpl(int boardSize) {
		this.setBoardSize(boardSize);
		var pawnPosition = this.randomEmptyPosition();
		var knightPosition = this.randomEmptyPosition();
        this.pawn = new PieceImpl(pawnPosition.getX(), pawnPosition.getY());
        this.knight = new PieceImpl(knightPosition.getX(), knightPosition.getY());
    }
    
	private void setBoardSize(int boardSize) {
		if (boardSize == 1) {
			throw new IllegalArgumentException("Board size must be greater than 1.");
		}
    	this.boardSize = boardSize;
	}

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> newPosition = new Pair<>(this.random.nextInt(boardSize),this.random.nextInt(boardSize));
    	// the recursive call below prevents clash with an existing pawn
		if (this.pawn != null && (this.pawn.getX() == newPosition.getX() && this.pawn.getY() == newPosition.getY())) {
			return randomEmptyPosition();
		} else {
    		return newPosition;
		}
    }
    
	@Override
	public boolean hit(int row, int column) {
		if (row < 0 || column < 0 || row >= this.boardSize || column >= this.boardSize) {
			throw new IndexOutOfBoundsException("Position must be inside of the board.");
		}
		// Below a compact way to express allowed moves for the knight
		int deltaX = row - this.knight.getX();
		int deltaY = column - this.knight.getY();
		if (deltaX != 0 && deltaY != 0 && Math.abs(deltaX) + Math.abs(deltaY) == 3) {
			this.knight.move(deltaX, deltaY);
			return this.pawn.getX() == this.knight.getX() && this.pawn.getY() == this.knight.getY();
		}
		return false;
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
