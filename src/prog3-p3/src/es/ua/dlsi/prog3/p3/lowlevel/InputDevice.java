package es.ua.dlsi.prog3.p3.lowlevel;

import java.nio.BufferOverflowException;

/**
 * Class InputDevice.
 * Hereda de  {@link IODevice} esta clase crea un objeto el cual se encargará 
 * en mandar información que el usuario reciba para su comunicacion con otros 
 * objetos antónimos.
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class InputDevice extends IODevice{

    /**
     * Metodo de instancia: constructor InputDevice.
     * este metodo crea un objeto de tipo {@link InputDevice} y a su vez 
     * {@link IODevice} para su posterior comunicacion con el objeto 
     * {@link OutputDevice}. A traves de un canal {@link Channel}.
     */
	protected InputDevice() {
        super();
	}

    /**
     * Metodo de instancia: put. 
     * permite enviar un array de bytes al canal asociado. En caso de que un error 
     * ocurra se lanzarán excepciones (ver siguientes throws)
     *
     * @throws IllegalStateException en caso de que no tenga canal el objeto
     * @throws BufferOverflowException en caso de que no quede espacio en el 
     * canal al qeu está asociado el objeto.
     *
     * @param a byte [] array que se pondrá directamente en el canal al que está 
     * asociado.
     */
	protected void put(byte a[]) {
        for (int i = 0; i < a.length; i++)
            this.getChannel().input(a[i]);

        this.getChannel();
	}

    /**
     * Metodo de instancia: sendToChannel.
     * Este metodo envia un byte al canal asociado. En caso de que un error ocurra
     * se lanzarán excepciones (ver siguientes throws)
     *
     * @throws IllegalStateException en caso de que no tenga canal el objeto
     * @throws BufferOverflowException en caso de que no quede espacio en el 
     * canal al qeu está asociado el objeto.
     *
     * @param a byte que se enviará al canal asociado. 
     */
	protected void sendToChannel(byte a) {
        this.getChannel().input(a);
	}
}
