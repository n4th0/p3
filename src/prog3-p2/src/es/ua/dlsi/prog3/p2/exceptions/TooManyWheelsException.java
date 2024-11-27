package es.ua.dlsi.prog3.p2.exceptions;

/**
 * TooManyWheelsException.
 * Excepción que se llamará cuando hay demasiadas ruedas en el vector 
 * 'wheels' de la clase {@link es.ua.dlsi.prog3.p2.model.Car}. Esta 
 * excepcion se llamará en el metodo 'addWheels'.
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class TooManyWheelsException extends Exception {

    /**
     * Constructor.
     * Constructor por defecto de la clase. Llama a la funcion 'super' de 
     * la clase 'Exception' la cual es padre de esta misma clase.
     */
	public TooManyWheelsException() {
        super();
	}

}
