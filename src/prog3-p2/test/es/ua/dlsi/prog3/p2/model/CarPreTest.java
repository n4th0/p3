package es.ua.dlsi.prog3.p2.model;

import static org.junit.Assert.*;

import org.junit.Test;

import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;
import es.ua.dlsi.prog3.p2.exceptions.TooManyWheelsException;
import es.ua.dlsi.prog3.p2.exceptions.WrongTyreTypeException;

public class CarPreTest {

	@Test
	public void testConstructor() {
		Car c = new Car();
		assertEquals(c.getWheels().size(),0);
	}
		
	@Test
	public void testAddWheel3() {
		Car c = new Car();
		
		try {
			TyreType t = new TyreType("205/65 R16",1.5,4);
			
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
		} catch (TooManyWheelsException | WrongTyreTypeException e) {
			fail("Unexpected exception "+e.getClass());
		}
	}

	@Test
	public void testAddWheel1() {
		Car c = new Car();
        boolean n = false;
		
		try {
			TyreType t = new TyreType("205/65 R16",1.5,4);
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel(t));
		} catch (TooManyWheelsException e) {
            n = true;
        }catch( WrongTyreTypeException e){
        }
        assertTrue(n);
	}

	@Test
	public void testAddWheel2() {
		Car c = new Car();
        boolean n = false;
		
		try {
			TyreType t = new TyreType("205/65 R16",1.5,4);
			c.addWheel(new Wheel(t));
			c.addWheel(new Wheel());
		} catch (TooManyWheelsException e) {
        } catch( WrongTyreTypeException e){
            n = true;
        }
        assertTrue(n);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testChangeTyres1() {
		 Car c = new Car();

         try{
		 	Wheel w = new Wheel();
		 	c.addWheel(w);
		 	c.addWheel(w);
		 	c.addWheel(w);
		    c.changeTyres(null, 2.25);
         }catch(TooManyWheelsException | PressureWheelException | WrongTyreTypeException ex){
        	 System.out.print(ex.getClass());
         }
	}

	@Test
	public void t1() {
		 Car c = new Car();
         boolean n = false;
         if (c.getWheels().size() == 0 || c.getWheels() == null ) {
             n = true;
         }
         assertTrue(n);
	}
    



}
