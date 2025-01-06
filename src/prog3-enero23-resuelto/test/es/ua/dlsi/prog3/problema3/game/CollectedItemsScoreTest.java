package es.ua.dlsi.prog3.problema3.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.ua.dlsi.prog3.problema3.game.CollectedItemsScore;
import es.ua.dlsi.prog3.problema3.game.Item;
import es.ua.dlsi.prog3.problema3.score.Score;

public class CollectedItemsScoreTest {

	CollectedItemsScore scLaura;
	CollectedItemsScore scPeter;
	
	@Before
	public void setUp() throws Exception {
		scLaura = new CollectedItemsScore("Laura");
		scPeter = new CollectedItemsScore("Peter");
	}

	/* Comprueba que los nombres de los jugadores de los dos
	 * Score son correctos
	 */
	@Test
	public void testCollectedItemsScoreAndGetName() {
		Score<Item> score = scLaura; 
		assertEquals("Laura", score.getName());
		
		assertEquals("Laura", scLaura.getName());
		assertEquals("Peter", scPeter.getName());
	}

	/*Crea algunos Items. Inicialmente aplica score sobre los Scores scLaura y 
	 * scPeter con el mismo Item. Comprueba que compareTo da 0.
	 * Aplica sobre uno de ellos con score, un Item que incremente su puntuación.
	 * Comprueba ahora que el que ha aumentado, si es el que invoca a compareTo da un
	 * valor negativo y si es el menor el que lo invoca, da un valor positivo.
	 */
	@Test
	public void testCompareTo() {
			assertTrue(scPeter.compareTo(scLaura)==0);
		scPeter.score(new Item(15.0));
		scLaura.score(new Item(15.0));
			assertTrue(scPeter.compareTo(scLaura)==0);
		scPeter.score(new Item(7.0));
			assertTrue(scPeter.compareTo(scLaura)<0);
			assertTrue(scLaura.compareTo(scPeter)>0);
	}

	/*Crea varios Item. Con cada uno, crea las puntuaciones (score) sobre el 
	 * CollectedItemsScore scLaura y comprueba con getScore() que  los valores que se van
	 * obteniendo se van acumulando sucesivamente. Por ejemplo:
	 * Item(5) --> 5
	 * Item(2) --> 7
	 * Item(50) -->57
	 * ...
	 */
	@Test
	public void testScoreItem() {
			assertEquals(0,scLaura.getScore(),0.01);
		scLaura.score(new Item(5));
			assertEquals(5,scLaura.getScore(),0.01);
		scLaura.score(new Item(2));
			assertEquals(7,scLaura.getScore(),0.01);
		scLaura.score(new Item(50));
			assertEquals(57,scLaura.getScore(),0.01);
	}

	/* Comprueba toString sobre scPeter y comprueba que inicialmente es: "Peter:0.0"
	 * Crea varios items y aplica el método score sobre scPeter. Comprueba que
	 * la salida va cambiando de valor (puedes hacerlo con los mismos items
	 * del test anterior)
	 */
	@Test
	public void testToString() {
			//assertEquals("Peter:0.0",formatToString(scPeter.toString(),2));
			compareScores ("Peter:0.0",scPeter.toString());
			scPeter.score(new Item(5));
			//assertEquals("Peter:5.0",formatToString(scPeter.toString(),2));
			compareScores ("Peter:5.0",scPeter.toString());
			scPeter.score(new Item(1));
			//assertEquals("Peter:6.0",formatToString(scPeter.toString(),2));
			compareScores ("Peter:6.0",scPeter.toString());
			scPeter.score(new Item(1));
			//assertEquals("Peter:7.0",formatToString(scPeter.toString(),2));
			compareScores ("Peter:7.0",scPeter.toString());		
	}

	/**********************************************/
	//FUNCIONES DE APOYO

	/* Para las salidas Score.toString() compara los valores impresos
	 * de los Scores hasta una precisión de 0.01
	 * 
	 */
		void compareScores(String expected, String result ) {
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
	
}
