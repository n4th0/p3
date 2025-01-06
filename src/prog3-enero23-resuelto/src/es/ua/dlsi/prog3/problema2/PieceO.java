package es.ua.dlsi.prog3.problema2;

public class PieceO extends Piece {
	private static char symbol = '#';
	private static final int BOUNDING_SQUARE_SIZE = 4;

	private static int shape[][] = 
        new int[][] {
	      { 0, 0, 0, 0,	
	    	0, 1, 1, 0,	
	    	0, 1, 1, 0,	
	    	0, 0, 0, 0 },
	      { 0, 0, 0, 0, 
	    	0, 1, 1, 0,	
	    	0, 1, 1, 0,	
	    	0, 0, 0, 0 },
	      { 0, 0, 0, 0, 
	    	0, 1, 1, 0,	
	    	1, 1, 1, 0,	
	    	0, 0, 0, 0 },
	      { 0, 0, 0, 0, 
	    	0, 1, 1, 0,	
	    	0, 1, 1, 0,	
	    	0, 0, 0, 0 } };   

	public PieceO() {
        super();
	}
	public PieceO(PieceO o) {
        setOrientation(o.getOrientation());
	}

	@Override
	public int[][] getShape() {
		int [][] sh = new int[BOUNDING_SQUARE_SIZE][];
		for (int i=0; i<BOUNDING_SQUARE_SIZE; i++) {
			sh[i] = new int[BOUNDING_SQUARE_SIZE];
		}
		
		int x=0;
		for (int i=0; i<BOUNDING_SQUARE_SIZE; i++) {
			for (int j=0; j<BOUNDING_SQUARE_SIZE; j++) {
				sh[i][j] = shape[getOrientation().ordinal()][x];
				x++;
			}
		}
		return sh;
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public Piece clone() {
		return new PieceO(this);
	}

}
