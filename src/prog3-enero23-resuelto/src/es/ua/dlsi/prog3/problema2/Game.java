package es.ua.dlsi.prog3.problema2;

import java.util.Objects;

/**
 * Represents a game play of Tetris 
 */
public class Game {
	private Board board;
	private Piece currentPiece;
	// private PieceType currentPieceType;
	private Coordinate currentPosition;
	
	/**
	 * Constructor of the Game class
	 * 
	 * @param height of the board to be used during the game
	 * @param width of the board to be used during the game
	 * @throws TetrisException if the board cannot be built
	 */
	public Game (int height, int width) throws TetrisException {
		
		board = new Board (height, width);
		currentPiece = null;
	}
	
	/**
	 * Rotate the current piece.
	 */
	public void rotateCurrentPiece () {		
		if (currentPiece == null)
			return;  // Nothing to do
	
		try {
			board.removePiece(currentPiece);
            currentPiece.rotate();
			
			// switch (currentPieceType) {
			// case I:
			// 	((PieceI) currentPiece).rotate(); 
			// 	break;
			// case L:
			// 	((PieceL) currentPiece).rotate(); 
			// 	break;
			// default: // This should never happen 
			// 	throw new RuntimeException("Unknown piece type");
			// }
			
			board.putPiece(currentPosition, currentPiece);			
		} catch (TetrisException e) {
			System.err.println("Problem rotating piece: "+ e.getMessage());
		}
	}
	
	
	public void moveCurrentPieceLeft () {
		// ...
	}
	
	public void moveCurrentPieceRight () {
		// ...
	}
	
	public void  moveCurrentPieceDown () {
		// ...
	}
	
	/**
	 * Create a new piece of the indicated type and make it to be the current piece
	 * 
	 * @param pt type of the piece to be created
	 */
	public void nextPiece (Piece p){
		Objects.requireNonNull(p, "Paramter pt cannot be null");
		
		// switch (pt) {
		// case I:
		// 	currentPiece = new PieceI(); 
		// 	break;
		// case L:
		// 	currentPiece = new PieceL(); 
		// 	break;
		// default: // This should never happen 
		// 	throw new RuntimeException("Unknown piece type");
		// }
		
		try {
			currentPosition = new Coordinate(0, board.getWidth() / 2 - 2);
            currentPiece = p;
			// currentPieceType = pt;

			board.putPiece(currentPosition, currentPiece);
		} catch (TetrisException e) {
			throw new RuntimeException("This should never happend: " + e.getMessage());
		}
		
	}
	
	@Override
	public String toString () {
		return board.toString();
	}
	
	public static void main(String[] args) {
		PieceI pi = new PieceI();
		PieceL pl = new PieceL();
	
		System.out.println(pi);
		System.out.println(pl);
		
		pi.rotate();
		pl.rotate();
		
		System.out.println(pi);
		System.out.println(pl);
		
		try {
			Board b = new Board(10,10);
			System.out.println(b);
			
			b.putPiece(new Coordinate(5,5), pi);
			b.putPiece(new Coordinate(0,0), pl);
			System.out.println(b);
			
			b.removePiece(pi);
			System.out.println(b);
		} catch (TetrisException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Game g = new Game (10,10);
			g.nextPiece(new PieceI()); // dependecy injection creo
			System.out.println(g);
			g.rotateCurrentPiece();
			System.out.println(g);
		} catch (TetrisException e) {
			System.out.println(e.getMessage());
		}
	}
} 
