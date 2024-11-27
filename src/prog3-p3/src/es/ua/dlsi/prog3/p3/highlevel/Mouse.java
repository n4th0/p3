package es.ua.dlsi.prog3.p3.highlevel;

import java.nio.BufferOverflowException;

import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;

/**
 * Mouse.
 * Clase que representa un input a nuestro sistema. Estará conectado a un 
 * canal para su correcta conexión con el resto de dispositivos. Hereda de 
 * {@link InputDevice}
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class Mouse extends InputDevice{

    /**
     * Metodo de instancia: constructor Mouse.
     * este constructor llama al constuctor sin parámetros de la clase 
     * {@link InputDevice}. Crea el objeto de dicha clase para su posterior
     * sincronización con otros dispositivos.
     */
	public Mouse() {
        super();
	}

    /**
     * Metodo de instancia: put.
     * Este metodo recibe dos bytes por entrada y los almacena en el canal 
     * al que está asociado el dispositivo (para ver los errores pertinentes 
     * mirar abajo).
     *
     * @throws BufferOverflowException si ya hay demasiados datos en el 
     * buffer del canal.
     * @throws IllegalStateException si el dispostivo no tiene un canal 
     * asociado.
     * @param x byte representa el valor de la coordenada 'X' 
     * @param y byte representa el valor de la coordenada 'Y' 
     */
    public void put(byte x, byte y){
        byte []n = new byte[2];
        n[0] = x;
        n[1] = y;

        this.put(n);
    }
}
