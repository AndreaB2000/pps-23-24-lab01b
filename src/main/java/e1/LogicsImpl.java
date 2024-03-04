package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private int size;

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.setSize(size);
		this.pawn = new Pair<Integer,Integer>(pawnPosition.getX(), pawnPosition.getY());
		this.knight = new Pair<Integer,Integer>(knightPosition.getX(), knightPosition.getY());
	}
	 
    public LogicsImpl(int size) {
		this.setSize(size);
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }
    
	private void setSize(int size) {
		if (size == 1) {
			throw new IllegalArgumentException("Size must be greater than 1.");
		}
    	this.size = size;
	}

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException("Position must be inside of the board.");
		}
		// Below a compact way to express allowed moves for the knight
		int deltaX = row - this.knight.getX();
		int deltaY = col - this.knight.getY();
		if (deltaX != 0 && deltaY != 0 && Math.abs(deltaX) + Math.abs(deltaY) == 3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
