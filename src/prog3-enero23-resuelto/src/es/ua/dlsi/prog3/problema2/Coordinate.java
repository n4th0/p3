package es.ua.dlsi.prog3.problema2;

/**
 * Represents a coordinate in the game board of the Testris game
 */
public class Coordinate {
	private int row;
	private int column;

	/**
	 * Constructor of the Coordinate class
	 * 
	 * @param row row 
	 * @param column column
	 * @throws TetrisException when row or column are below zero
	 */
	public Coordinate (int row, int column) throws TetrisException {
		if ((row<0) || (column<0))
			throw new TetrisException("Coordinate.Coordinate: row and column must be >=0");
		
		this.row = row;
		this.column = column;
	}

	/**
	 * Getter
	 * 
	 * @return row
	 */
	public int getRow (){ 
		return row; 
	}
	
	/**
	 * Getter
	 * 
	 * @return column
	 */
	public int getColumn () { 
		return column; 	
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('[');
		str.append(row);
		str.append(',');
		str.append(column);
		str.append(']');
		
		return str.toString();
	}
}
