package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.NoLineForPrintingException;

/**
 * LinePrinter
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class LinePrinter extends OutputDevice{

    /**
     * Atributo de clase: MAX_LINE_LENGTH.
     * esta constante será utilizada en todos los objetos que se creen con  
     * esta clase. Estará inicializada a 80 para la reserva de caracteres para
     * el canal por el cual se comunicarán los objetos
     */
    private final static int MAX_LINE_LENGTH = 80;

    /**
     * Constructor LinePrinter.
     * hace llamada al constructor de {@link OutputDevice} almacena en el 
     * buffer el valor de la constante MAX_LINE_LENGTH +1 para reservar la 
     * capacidad del canal por el que se comuncará con otros objetos.
     */
	public LinePrinter() {
        super(MAX_LINE_LENGTH+1);
	}

    /**
     * Metodo de instancia: printLine.
     * devuelve un String que contiene la cadena leída del buffer. 
     * @throws NoLineForPrintingException si detecta que la string está vacía o
     * no se ha recibido correctamente.
     * @throws IllegalStateException si el dispositivo no tiene canal asociado.
     * @return s {@link String} la linea que se lee en el buffer del canal.
     */
    public String printLine() throws NoLineForPrintingException{
        if (!this.getChannel().hasData()) 
            throw new NoLineForPrintingException();

        String s = this.readStoredString();

        if (s.isEmpty()) 
            throw new NoLineForPrintingException();

        return s;
    }
}
