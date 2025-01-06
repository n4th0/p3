package es.ua.dlsi.prog3.problema3.score;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ranking {
	private SortedSet<Score> scores;
	
	public Ranking() {
		scores = new TreeSet<>();
	}
	
	public void addScore(Score score) {
		scores.add(score); 
	}
	
	public Score getWinner() throws EmptyRankingException {
		if (scores.isEmpty()) {
			throw new EmptyRankingException();
		}
		return scores.first();
	}
	
	public SortedSet<Score> getSortedRanking() {
		return Collections.unmodifiableSortedSet(scores);
	}
	
}
