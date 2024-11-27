
package es.ua.dlsi.prog3.p3.lowlevel;

import java.nio.BufferUnderflowException;

/**
 * OutputDevice.
 * Clase {@link OutputDevice} qeu crea un objeto que se comunicará con el exterior 
 * dandole la informacion que se guarda en el canal asociado a este objeto. Esta 
 * clase es antónima a {@link InputDevice}. Hereda de {@link IODevice}
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class OutputDevice extends IODevice {

	/**
	 * DON'T TOUCH THIS METHOD!!! The earth will collapse on itself if you ever think of doing it!
	 * 
	 * Reads a string from the channel. 
	 * 
	 * The channel MUST contain a string of characteres encoded as
	 * 
	 * [length][A-Ba-b0-9]+
	 * 
	 * which means that the first byte is the string length, and the rest of bytes are the actual string 
	 * 
	 * @return the string read, as an String object, or an empty if there is no data in the channel 
	 * @throws BufferUnderflowException if the channel becomes empty before the whole string is read, i.e. the data in the channel is corrupted
	 * @throws IllegalStateException if there is no channel associated to this device 
	 */
	protected String readStoredString() {
		byte[] data = null;
		char[] string = null;
		data = get(1);
		if (data.length != 1) 
			return "";
		int string_length = data[0];		
		data = get(string_length);
		if (data.length != string_length)
			throw new BufferUnderflowException();
		string = new char[string_length];
		for (int i=0; i < string_length; i++)
			string[i] = (char) data[i];
		return String.valueOf(string);
	}

    /**
     * Metodo de instancia: constructor OutputDevice.
     * este constructor se encarga de llamar al constructor de la clase {@link IODevice}
     * cuyo parámetro es un integer a para que se cree un buffer del tamaño que se 
     * quiera.j
     * @param a int tamaño del buffer que tendrá el objeto de la clase {@link IODevice}.
     */
    protected OutputDevice(int a){
        super(a);
    }

    /**
     * Metodo de instancia: get.
     * Lee como máximo num_bytes del canal asociado. Devuelve un array de bytes de 
     * tamaño igual al número de bytes leídos (que puede ser cero si el canal no 
     * contiene datos).
     * @throws IllegalArgumentException en caso de que sea o más grande que el buffer o 
     * más pequeño que 0 
     * @throws IllegalStateException en caso de que no tenga canal asociado.
     *
     * @param numBytes int tamaño del array que se devolverá en caso de qeu no hayan
     * tantos datos se devolverá el máximo de datos que se puedan.
     * @return b/n byte [] array de bytes que se devolverá. Su longitud es independiente.
     */
    protected byte [] get(int numBytes){

        if (numBytes<=0 || numBytes>this.getBufferSize())
            throw new IllegalArgumentException("ERROR: OutputDevice.get");

        byte [] n = new byte[numBytes];

        for (int i = 0; i < numBytes ; i++) {
            try{
                n[i] = this.getChannel().output();
            }catch(BufferUnderflowException e){
                byte [] b = new byte[i];
                for (int j = 0; j < b.length; j++) {
                    b[j] = n[j];
                }
                return b;
            }
        }
        return n;
    }

    /**
     * Metodo de instancia: receiveFromChannel.
     * este objeto lee un byte del canal al que está asociado.
     * @throws IllegalStateException en caso de qeu no tenga canal asociado el objeto.
     * @throws BufferUnderflowException en caso de que el buffer del canal 
     * esté vacio.
     * @return byte que corresponde al byte leido en el canal asociado.
     */
    protected byte receiveFromChannel() {
        return getChannel().output();
    }


}
