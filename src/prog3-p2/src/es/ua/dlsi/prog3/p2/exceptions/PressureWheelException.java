package es.ua.dlsi.prog3.p2.exceptions;

/**
 * PressureWheelException.
 * Esta excepcion tiene un atributo llamado pressure que representa la 
 * presion errónea con la que se ha intentado operar. Esta excepcion será
 * lanzada por los metodos addWheel de la clase {@link es.ua.dlsi.prog3.p2.model.Car}
 * y el otro método 'inflate' de la clase {@link es.ua.dlsi.prog3.p2.model.Wheel}.
 *
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public class PressureWheelException extends Exception {

    /**
     * Atributo de instancia: pressure.
     * Se inicializará a la presion pasada por parámetro al constructor 
     * esta presión es errónea por alguna de las condiciones de 'inflate'.
     */
    private double pressure;

    /**
     * Constructor. 
     * Cosntructor por defecto de la clase. Esta inicializará el atributo privado
     * 'pressure' a la presion que se le pase por parámetro. No hará ninguna 
     * comprovación.
     *
     * @param pressure double presion errónea con la que se está tratando.
     */
	public PressureWheelException(double pressure) {
        this.pressure = pressure; 
	}

    /**
     * Metodo de instancia: getMessage. 
     * metodo que devuelve un String con la presion errónea en el. Este método
     * se usará para imprimir cuando sea necesario la presion errónea
     * @return "Pressure of "pressure" BAR".
     *
     */
    public String getMessage(){
        return "Pressure of "+pressure+" BAR";
    }

}
