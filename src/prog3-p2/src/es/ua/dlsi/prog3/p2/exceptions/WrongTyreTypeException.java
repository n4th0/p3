package es.ua.dlsi.prog3.p2.exceptions;

/**
 * WrongTyreTypeException.
 * Excepcion que será llamada cuando se intente poner un neumático que no 
 * es el que tienen el resto de ruedas en el coche. Esta excepcion será
 * lanzada por el metodo 'changeTyres' de la clase {@link es.ua.dlsi.prog3.p2.model.Car}.
 *
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class WrongTyreTypeException extends Exception {

    /**
     * Constructor.
     * Constructor por defecto de la clase. Llama a la funcion 'super' de 
     * la clase 'Exception' la cual es padre de esta misma clase.
     * 
     */
	public WrongTyreTypeException() {
        super();
	}
}

