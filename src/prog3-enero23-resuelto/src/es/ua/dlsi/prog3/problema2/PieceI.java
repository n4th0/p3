package es.ua.dlsi.prog3.problema2;

/** 
 *  Represents a piece of type I
 */
public class PieceI extends Piece{
	private static char symbol = '#';
	
	/**
	 * Size of the bounding square size of the piece. 
	 */
	private static final int BOUNDING_SQUARE_SIZE = 4;
	
	/**
	 * Shape of this piece for the different possible orientations. 
	 * Each different position of array corresponds to a different orientation.
	 * Positions sets to 1 correspond to the piece as it will be placed on the board.
	 */
	private static int shape[][] = new int[][] {
	      { 0, 0, 0, 0,	
	    	1, 1, 1, 1,	
	    	0, 0, 0, 0,	
	    	0, 0, 0, 0 },
	      { 0, 0, 1, 0, 
	    	0, 0, 1, 0,	
	    	0, 0, 1, 0,	
	    	0, 0, 1, 0 },
	      { 0, 0, 0, 0, 
	    	0, 0, 0, 0,	
	    	1, 1, 1, 1,	
	    	0, 0, 0, 0 },
	      { 0, 1, 0, 0, 
	    	0, 1, 0, 0,	
	    	0, 1, 0, 0,	
	    	0, 1, 0, 0 } }; 
	
	/**
	 *  Constructor of the class PieceI
	 */
	public PieceI () {
	}
	
	/**
	 * Copy constructor of the class PieceI
	 * @param p piece to be copied
	 */
	public PieceI(PieceI p) {
        setOrientation(p.getOrientation());
	}

    public PieceI clone(){
        return new PieceI(this);
    }

	
	// /** Getter
	//  * 
	//  * @return the orientation of this piece
	//  */
	// public Rotation getOrientation() {
	// 	return orientation;
	// }
	
	/**
	 * Return the shape of this piece according to its orientation
	 * 
	 * @return a matrix of BOUNDING_SQUARE_SIZE x BOUNDING_SQUARE_SIZE with
	 *         the shape of this piece, taking into account its orientation
	 */
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
	
	/**
	 * Getter
	 * 
	 * @return the symbol to be used to represent this piece
	 */
	public char getSymbol() {
		return symbol;
	}
	
}
