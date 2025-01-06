package es.ua.dlsi.prog3.problema3.score;

@SuppressWarnings("serial")
public class EmptyRankingException extends Exception {
	public EmptyRankingException() {
		super("Empty ranking!");
	}
}
