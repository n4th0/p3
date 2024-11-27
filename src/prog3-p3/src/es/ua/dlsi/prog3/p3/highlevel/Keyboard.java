package es.ua.dlsi.prog3.p3.highlevel;
import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

/**
 * Keyboard.
 *
 * clase Keyboard hereda de la clase {@link InputDevice}
 * haciendo que sea un objeto de tipo input, esto hace que se comunique con el 
 * canal mandando informacion y no reciviendo. Usa el el constructor sin parámetros
 * de la clase herdada.
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class Keyboard extends InputDevice{

    /**
     * Metodo de clase: keyboard (constructor).
     * el constructor llama al constructor de {@link InputDevice} para 
     * crear el objeto que se comunicará con el canal.
     */
	public Keyboard() {
        //super();
	}

    /**
     * Metodo de clase: put.
     * metodo el cual se enviará datos al canal. 
     * @param n char it will put the character into the channel of 
     * the object who is comunicating.
     */
    public void put(char n){
        this.sendToChannel((byte)n);
    }
}
