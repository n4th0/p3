package es.ua.dlsi.prog3.p3.highlevel.exceptions;

/**
 * NoLineForPrintingException.
 * Inherits from {@link Exception}. this exception will be thrown by 
 * {@link es.ua.dlsi.prog3.p3.highlevel.LinePrinter} actually the method 
 * PrintLine when the buffer is empty.
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class NoLineForPrintingException extends Exception {

    /**
     * Metodo de insancia: NoLineForPrintingException.
     * Este metodo crea un objeto de la clase {@link NoLineForPrintingException}
     * este objeto hereda de la clase {@link Exception} y se lanzará en caso de que 
     * el buffer del objeto impresora está vacío.
     */
	public NoLineForPrintingException() {
        super();
	}

}
