package es.ua.dlsi.prog3.problema2;

import java.util.Objects;

/**
 * Represents the board of the Tetris game.
 */
public class Board {
	private int height;
	private int width;
	
	private Piece[][] gameboard; // Stores the piece at each location
	private PieceType[][] piecesTypes; // Stores the type of piece at each location
	
	/**
	 * Constructor of the Board class
	 * 
	 * @param height Height of the board (number of rows)
	 * @param width Width of the board (number of columns)
	 * @throws TetrisException when height and width are equal or below zero
	 */
	public Board (int height, int width) throws TetrisException {
		if ((height<=0) || (width<=0))
			throw new TetrisException("heigh and width must be >0");
		
		this.height = height;
		this.width = width;
		
		gameboard = new Piece[height][];
		piecesTypes = new PieceType[height][];
		for (int i=0; i<height; i++) {
			gameboard[i] = new Piece[width];
			piecesTypes[i] = new PieceType[width];
		}

	}
	
	/**
	 * Getter
	 * 
	 * @return The height of the board
	 */
	public int getHeight () {
		return height;
	}
	
	/**
	 * Getter
	 * 
	 * @return The width of the board
	 */
	public int getWidth () {
		return width;
	}
	
	/**
	 * It adds a piece to the board at the given coordinate, which is taken as the left upper corner of the
	 * bounding box of the piece.
	 * @param pos Coordinate on which to add the piece
	 * @param pt Type of the piece to be added
	 * @param piece Piece to be added 
	 * @throws TetrisException if the coordinate falls outside the limits of the board.
	 */
	public void putPiece (Coordinate pos, Piece piece) throws TetrisException {
		Objects.requireNonNull(pos, "Parameter pos cannot be null");
		Objects.requireNonNull(pt, "Parameter pt cannot be null");
		Objects.requireNonNull(piece, "Parameter piece cannot be null");

		if ((pos.getRow()>=height) || (pos.getColumn()>=width))
			throw new TetrisException("Board.isOccupied: Invalid coordinate " + pos);
		
		int[][] shape;
        shape = piece.getShape();

		// switch (pt) {
		// case I:
		// 	shape = ((PieceI)piece).getShape();
		// 	break;
		// case L:
		// 	shape = ((PieceL)piece).getShape();
		// 	break;
		// default: // This should never happen 
		// 	throw new RuntimeException("Unknown piece type");
		// }
		
		int row = pos.getRow();   //left upper corner
		int col = pos.getColumn();
		
		for (int i=0; i<shape.length; i++) {
			for (int j=0; j<shape[i].length; j++) {
				if (shape[i][j]==1) {
					gameboard[row+i][col+j] = piece;
					piecesTypes[row+i][col+j] = pt;
				}
			}
		}
	}
	
	/**
	 * Remove a piece from the board
	 *  
	 * @param piece Piece to be removed
	 */
	public void removePiece (Piece piece) {
		Objects.requireNonNull(piece, "Parameter piece cannot be null");
		
		for (int i=0; i<gameboard.length; i++) {
			for (int j=0; j<gameboard[i].length; j++) {
				if (gameboard[i][j] == piece) { // debería cambiarlo por un equals?
					gameboard[i][j] = null;
					piecesTypes[i][j] = null;
				}
			}
		}
	}
	
	/**
	 * Gets a copy of the piece at the coordinate received as argument
	 * 
	 * @param pos A coordinate within the board
	 * @return a copy of the piece at the coordinate received as argument
	 * @throws TetrisException  if the coordinate falls outside the limits of the board.
	 */
	public Piece copyOfPieceAt(Coordinate pos) throws TetrisException {
		Objects.requireNonNull(pos, "Parameter pos cannot be null");
		if ((pos.getRow()>=height) || (pos.getColumn()>=width))
			throw new TetrisException("Board.copyOfPieceAt: Invalid coordinate " + pos);
		
		if (gameboard[pos.getRow()][pos.getColumn()] == null)
			return null;
		
		// PieceType pt = piecesTypes[pos.getRow()][pos.getColumn()];
		Piece piece = gameboard[pos.getRow()][pos.getColumn()].clone();
        return piece;
		
		// switch (pt) {
		// case I:
		// 	return new PieceI((PieceI)piece); 
		// case L:
		// 	return new PieceL((PieceL)piece);
		// default: // This should never happen 
		// 	throw new RuntimeException("Unknown piece type");
		// }

	}
			
	@Override
	public String toString () {
		StringBuilder cb = new StringBuilder ();
		
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				char symbol = '·';
				if (gameboard[i][j]!=null) {
                    symbol =gameboard[i][j].getSymbol();

					// PieceType pt = piecesTypes[i][j];					
					// switch (pt) {
					// case I:
					// 	symbol = ((PieceI) gameboard[i][j]).getSymbol(); 
					// 	break;
					// case L:
					// 	symbol = ((PieceL) gameboard[i][j]).getSymbol(); 
					// 	break;
					// default: // This should never happen 
					// 	throw new RuntimeException("Unknown piece type");
					// }

				}
				cb.append(symbol);
			}
			cb.append('\n');
		}
		return cb.toString();
	}	
}
