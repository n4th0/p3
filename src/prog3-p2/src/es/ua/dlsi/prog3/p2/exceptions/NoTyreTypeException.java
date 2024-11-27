package es.ua.dlsi.prog3.p2.exceptions;

/**
 * NoTyreTypeException.
 * Esta excepcion herda de la clase {@link Exception} esta excepcion
 * será lanzada en el  método inflate() de la clase {@link es.ua.dlsi.prog3.p2.model.Wheel}
 * esta se lanzará si se intenta inflar una rueda que no tiene neumático.
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */

public class NoTyreTypeException extends Exception {

    /**
     * Constructor.
     * Constructor de la clase {@link NoTyreTypeException} que hereda de la 
     * clase {@link Exception}.
     */
	public NoTyreTypeException() {
        super();
	}
}
