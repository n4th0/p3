package es.ua.dlsi.prog3.problema3.score;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import es.ua.dlsi.prog3.problema3.game.CollectedItemsScore;
import es.ua.dlsi.prog3.problema3.game.Item;
import es.ua.dlsi.prog3.problema3.score.Ranking;

public class RankingTest {
	
	final String kRANKING1 = "Collected items ranking = [Julia:5.0]\n" ;	
	final String kRANKING2 = "Collected items ranking = [Julia:5.0, Sara:1.0]\n" ;	
	final String kRANKING3 = "Collected items ranking = [Julia:11.0, Frank:6.0, Sara:3.0]\n" ; 
			
	
	Ranking<CollectedItemsScore> itemsRanking;
	CollectedItemsScore itemScore;
	
	
	@Before
	public void setUp() throws Exception {
		itemsRanking = new Ranking<CollectedItemsScore>();
		itemScore = null; 
	} 

	
	/* Se añade inicialmente a MovementScore la ubicación  inicial de Julia.
	 * Se crea para Julia los 2 tipos de Scores y se añaden a los distintos Ranking. Se 
	 * comprueba que la salida de los ranking (construida en el método auxiliar makeOutputToString())
	 * coincide con kRANKING1.
	 * Realiza lo mismo ahora para Sara, creando los 2 tipo de Scores a partir de los siguientes elementos:
	 * Item(1)
	 * Coordinate(0,67)
	 * y añadiéndolos a los distintos Ranking anteriores.
	 * Comprobar que la salida con makeOutputToString(), coincide con kRANKIG2
	 */
	@Test
	public void testAddScore1() {
		try {
			addScoresGame("Julia",null,true);	
			addScoresGame("Julia",new Item(5),false);
			addScoresToRanking();
			compareRankings(kRANKING1, rankingsToString());
					
			addScoresGame("Sara",null,true);
			addScoresGame("Sara",new Item(1),false);
			addScoresToRanking();
			System.out.println(rankingsToString());
			compareRankings(kRANKING2, rankingsToString());
		} catch (Exception e) {
			fail ("Error, no debió lanzar la excepcion "+e.getClass().getName());
		}
	}

	/* Partiendo, por ejemplo del testAddScore1(), puedes añadir nuevos elementos a los distintos Scores de
	 * los distintos Player. Añadir un nuevo player, pFrank, crear Scores para él y comprobar en pantalla
	 * qué salida obtienes (con System.out.println(makeOutputToString()); 
	 * Para evitar que te quede un test muy largo, puedes usar los métodos de ayuda que hay al final
	 * de este test suite, para crear/añadir nuevos valores a los distintos scores, y para añadir éstos
	 * a los distintos Ranking.
	 */
	@Test
	public void testAddScore2() {
		try {
			addScoresGame("Sara",null,true);
			addScoresGame("Sara",new Item(1),false);
			addScoresGame("Sara",new Item(2),false);
			addScoresGame("Sara",null,false);
			
			addScoresToRanking();		
			
			addScoresGame("Frank",null,true);
			addScoresGame("Frank",new Item(1),false);
			addScoresGame("Frank",new Item(2),false);
			addScoresGame("Frank",new Item(3),false);
			
			addScoresToRanking();
			
			addScoresGame("Julia",null,true);
			addScoresGame("Julia",new Item(5),false);
			addScoresGame("Julia",new Item(6),false);
			addScoresGame("Julia",null, false);
			addScoresToRanking();
			
			//System.out.println(makeOutputToString());
			
			compareRankings(kRANKING3, rankingsToString());
			
		} catch (Exception e) {
			fail ("Error, no debió lanzar la excepcion "+e.getClass().getName());
		}
	}

	/* Comprobación de la excepción EmptyRankingException con getWinner()
	 * cuando no hay valores en los rankings.
	 */
	@Test(expected=EmptyRankingException.class)
	public void testGetWinnerException() throws EmptyRankingException {
			itemsRanking.getWinner();
	}

	

	
	
	/******************************************************************/
	//FUNCIONES DE APOYO
	/* Permite, para el jugador 'name', incrementar los distintos Scores si newScores es false, o
	 * iniciar los distintos Scores para el jugador si newScores es true. Si un determinado score no 
	 * queremos incrementarlo, se pasa null por parámetro 
	 */
	private void addScoresGame (String name, Item is, boolean newScores) {
		if (newScores) {
			itemScore = new CollectedItemsScore(name);
		}
		//Anadimos el valor del Item al CollectedItemScore 
		if (is!=null) {
			itemScore.score(is);
		}
	}
	
	
	/* Añade los distintos valores de los Scores a los Ranking*/
	private void addScoresToRanking () {
		itemsRanking.addScore(itemScore);
	}
	
		
	/* Para las salidas Score.toString() compara los valores impresos
	 * de los Scores hasta una precisión de 0.01
	 * 
	 */
	private void compareScores(String expected, String result ) {
		String ex[]= expected.split(":");
		String re[]= result.split(":");
		if (ex.length!=re.length) fail("Lineas distintas");
		if (ex.length==2) {
			if (ex[0].trim().equals(re[0].trim())) {
				double ed = Double.parseDouble(ex[1]);
				double rd = Double.parseDouble(re[1]);
		
				assertEquals(ex[0],ed,rd,0.01);
			}
			else fail("Nombres jugadores distintos: esperado=<"+ex[0].trim()+"> obtenido=<"+re[0].trim()+">");
		}
		else
			assertEquals(expected.trim(),result.trim());		
	}	
	
	
	/* Se usa para comparar los valores impresos de los rankings con una precisión 
	 * de 0.01
	 * [Sara:1.4142135623730951, Julia:14.866068747318506]"
	 */
	private void compareRankings(String expected, String result) {
		String exp[]=expected.split("\n");
		String res[]=result.split("\n");
		boolean iguales = true;
		for (int i=0; i<exp.length && iguales; i++) {
			
			String exp1[]=exp[i].split(", ");
			String res1[]=res[i].split(", ");
			if (exp1.length!=res1.length) 
				fail("Error: cantidad de jugadores distintos en el ranking "+res[i]);
			for (int k=0; k<exp1.length; k++) { //Para cada Score
				if (k==exp1.length-1) //Es el último Score
					compareScores(exp1[k].substring(0, exp1[k].indexOf(']')).trim(),res1[k].substring(0, res1[k].indexOf(']')).trim());
				else 
					compareScores(exp1[k].trim(),res1[k].trim());
				
			}
		
		}
	}
	
	/* Construye la salida como String, con los distintos Ranking */
	private String rankingsToString () {
		StringBuilder ps = new StringBuilder();
		ps.append("Collected items ranking = "+itemsRanking.getSortedRanking()+"\n");
		return ps.toString();
	}
}
