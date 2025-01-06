package es.ua.dlsi.prog3.problema2;


public abstract class Piece {
    // private static int BOUNDING_SQUARE_SIZE = 4;
	private Rotation orientation;
    // private  int[][] shape;


    public Piece(){
		orientation = Rotation.D0;
    }

	public Rotation getOrientation() {
		return orientation;
	}

	public void setOrientation(Rotation o) {
		orientation = o;
	}

	public abstract int[][] getShape(); 
	public abstract char getSymbol();
	public abstract Piece clone();
	

	/** 
	 * Rotate this piece and change its orientation
	 */
	public void rotate () {
		int new_o = getOrientation().ordinal()+1;
		
		if (new_o >= Rotation.values().length)
			new_o = 0;
		
		setOrientation(Rotation.values()[new_o]);
	}

	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		
		int[][] sh = getShape();
		for(int i=0; i<sh.length; i++) {
			for (int j=0; j<sh[i].length; j++) {
				if (sh[i][j] == 1)
					sb.append(getSymbol());
				else
					sb.append('·');
			}
			sb.append('\n');
		}	
		return sb.toString();
	}

}
