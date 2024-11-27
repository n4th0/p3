package es.ua.dlsi.prog3.p2.model;

import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;

/**
 * Wheel.
 * Esta clase representa la rueda de un vehículo a la cual se le puede asignar 
 * un tipo de neumático (TyreType) y cuyo estado viene determinado por el tipo de 
 * neumático que tiene asignado y la presión a la que se ha hinchado la rueda.
 *
 * @author Nathan Rodriguez Moyses 48727425Q.
 */
public class Wheel {

    /**
     * Atributo de instancia: pressure.
     * Presión de la rueda. Esto será representado con un double. Por 
     * defecto será 0 pero se podrá inflar con el metodo 'inflate'.
     */
    private double pressure;

    /**
     * Atributo de instancia: tyreType.
     * Este atributo estará a null por defecto y se podrá cambiar con el 
     * metodo 'setTyreType'. Este Objeto tiene como relación una agregación
     * 0..1.
     */
    TyreType tyreType;

    /**
     * Constructor.
     * Constructor por defecto del Objeto. Inicializa tanto el atributo 
     * pressure a 0 como el Tyretype a null. 
     */
    public Wheel(){
        pressure = 0;
        tyreType = null;
    }

    /**
     * Constructor.
     * Construcor cuyo parámetro se usará para completar la relacion 0..1 de 
     * agregación que tiene el objeto con la clase TyreType. NO SE HARÁ COPIA PROFUNDA.
     * Seguirá instanciando el atributo pressure como 0.
     *
     * @param t TyreType objeto que tendrá como tipo de neumático
     */
    public Wheel(TyreType t){
        pressure = 0;
        tyreType = t;
    }

    /**
     * Copy constructor.
     * Constructor copia. Este constructor no realizará copia profunda. Los objetos 
     * que se modifiquen dentro de la clase se verán afectados en el exterior del 
     * propio objeto. Esto se debe a que se copia la referencia y no el objeto en sí.
     *
     * @param w Wheel objeto a copiar
     */
    public Wheel(Wheel w){
        // if (w == null)
        //     throw new RuntimeException();
        
        pressure = w.pressure;
        tyreType = w.tyreType;
    }

    /**
     * Método de instancia: setTyreType.
     * Este método trivial instancia el atributo tyreType a la referencia que se le 
     * pasa por parámetro. No se hará copia profunda ya que se trata de una 
     * agregación y no una composición.
     *
     * @param t TyreType tipo de neumático que tendrá la rueda.
     */
    public void setTyreType(TyreType t){
        tyreType = t;
    }

    /**
     * Método de instancia: getTyreType.
     * Este metodo trivial devuelve el tipo de neumático que tiene la rueda. Devuelve 
     * la referencia del objeto, no creará ninguno nuevo.
     *
     * @return tyreType TyreType
     */
    public TyreType getTyreType(){
        return tyreType;
    }

    /**
     * Método de instancia: inflate.
     * Método que modifica el valor del atributo pressure tras una serie de 
     * comprobaciones. Si la presion es menor que 0 lanzará la excepción
     * {@link IllegalArgumentException}. Este atributo es de vital importancia
     * ya que se verá requerido para clases que contengan esta misma.
     *
     * @param p double presión a cambiar 
     *
     * @throws NoTyreTypeException lanzará esta excepcion cuando detecte que 
     * tyreType es null
     * @throws PressureWheelException se lanzará esta excepcion cuando se detecte que 
     * la presion pasada no pertenece al intevalo definido por la máxima y minima presion
     */
    public void inflate(double p) throws NoTyreTypeException, PressureWheelException{

        if (p < 0) 
            throw new IllegalArgumentException( "ERROR: inflate negative pressure");

        if (this.tyreType == null) 
            throw new NoTyreTypeException();

        if (p > tyreType.getMaxPressure() || p < tyreType.getMinPressure()) 
            throw new PressureWheelException(p);

        this.pressure = p;
    }
}

