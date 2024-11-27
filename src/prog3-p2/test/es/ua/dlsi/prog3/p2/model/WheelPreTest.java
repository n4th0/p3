package es.ua.dlsi.prog3.p2.model;

import static org.junit.Assert.*;
import org.junit.Test;

import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;

public class WheelPreTest {

	@Test
	public void testConstructor1() {
		Wheel w = new Wheel();
		assertNull(w.getTyreType());
	}
	
	@Test
	public void testConstructor2() {
		TyreType t = new TyreType("205/65 R16",2,4);
		Wheel w = new Wheel(t);
		assertNotNull(w.getTyreType());
	}
	
	@Test
	public void testSetTyreType() {
		TyreType t = new TyreType("205/65 R16",2,4);
		Wheel w = new Wheel();
				
		assertNull(w.getTyreType());
		
		w.setTyreType(t);
		
		assertNotNull(w.getTyreType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInflate1() {
		TyreType t = new TyreType("205/65 R16",2,4);
		Wheel w = new Wheel(t);
		try {
			w.inflate(-1);
		} catch (NoTyreTypeException | PressureWheelException e) {
			fail("Unexpected exception "+e.getMessage());
		}
	}

	@Test
	public void testInflate2() {
		Wheel w = new Wheel();
        boolean excpt = false;

		try {
			w.inflate(4);
		} catch ( PressureWheelException e) {
			fail("Unexpected exception "+e.getMessage());
        }catch( NoTyreTypeException ex){
            excpt = true;
        }

        assertTrue(excpt);
	}

	@Test
	public void testInflate3() {
		Wheel w = new Wheel(new TyreType("205/65 R16",2,4));
        boolean excpt = false;
		try {
			w.inflate(10);
		} catch ( PressureWheelException e) {
            excpt = true;
        }catch(NoTyreTypeException ex){
        }
        assertTrue(excpt);
	}

}
