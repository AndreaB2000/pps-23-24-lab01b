package e1;

public class PieceImpl implements Piece {

    private Pair<Integer, Integer> coordinates;

    public PieceImpl() {
        this.coordinates = new Pair<Integer,Integer>(0, 0);
    }
    
    public PieceImpl(final int x, final int y) {
        this.coordinates = new Pair<Integer,Integer>(x, y);
    }

    @Override
    public int getX() {
        return this.coordinates.getX();
    }

    @Override
    public int getY() {
        return this.coordinates.getY();
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.coordinates = new Pair<Integer,Integer>(
            this.coordinates.getX() + deltaX,
            this.coordinates.getY() + deltaY
        );
    }
}
