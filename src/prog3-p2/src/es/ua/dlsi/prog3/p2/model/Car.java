package es.ua.dlsi.prog3.p2.model;

import java.util.ArrayList;

import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;
import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.TooManyWheelsException;
import es.ua.dlsi.prog3.p2.exceptions.WrongTyreTypeException;

/**
 * Car.
 * Esta clase representa un vehículo al cual se le pueden añadir ruedas 
 * (Wheel) hasta el máximo indicado en la relación. Esta clase será la 
 * cabeza de nuestra aplicación. 
 * 
 * @author Nathan Rodriguez Moyses 48727425Q.
 */
public class Car {

    /**
     * Atributo de instancia wheels.
     * Este atributo representa la cantidad de ruedas que tiene el coche ahora 
     * mismo, como máximo tendrá 4 ruedas. Para añadir a este vector ruedas
     * se deberá realizar con 'addWheel'.
     */
    private ArrayList<Wheel> wheels;

    /**
     * Constructor.
     * Constructor sin parámetros. Este constructor crea un array para las 
     * ruedas que contenga el coche, estas como máximo serán 4. Esto se controlará
     * en la funcion 'addWheel'.
     */
    public Car(){
        wheels = new ArrayList<Wheel>();
    }

    /**
     * Copy constructor.
     * Constructor copia de la clase Car. Se hace una copia defensiva del array
     * que contine las ruedas del coche.  No hará ninguna comprobación. De si 
     * el objeto es null.
     *
     * @param c Car coche a copiar.
     */
    public Car(Car c){ 
        wheels = new ArrayList<Wheel>();
        for (int i = 0; i < c.wheels.size(); i++) {
            wheels.add(new Wheel(c.wheels.get(i)));
        }
    }

    /**
     * Metodo de instancia addWheel.
     * Método que añade la rueda pasada por parámetro tras hacer varias comprobaciones
     * - si el parametro es null lanzará una excepcion de argumentos
     * - si hay suficientes ruedas en el coche lanzará TooManyWheelsException
     * - si se intenta instalar una rueda con neumatico distinto lanzará WrongTyreTypeException
     *
     * @param w Wheel rueda a comprobar
     *
     * @throws TooManyWheelsException si ya hay 4 ruedas si hay más lanzará una {@link RuntimeException}
     * @throws WrongTyreTypeException si se intenta meter una rueda con distinto neumático
     */
    public void addWheel(Wheel w) throws TooManyWheelsException, WrongTyreTypeException {

        if (w == null) 
            throw new IllegalArgumentException("ERROR: wheel is null");

        if(wheels.size() == 4)
            throw new TooManyWheelsException();

        if(wheels.size() > 4)
            throw new RuntimeException();

        if(wheels.size() == 0){
            wheels.add(new Wheel(w));
            return;
        }

        if (w.getTyreType() == null) {
            for (int  i = 0; i < wheels.size(); i++) {
                if(wheels.get(i).getTyreType() != null){
                    throw new WrongTyreTypeException();
                }
            }
        }else{
            for (int  i = 0; i < wheels.size(); i++) {
                if(!w.getTyreType().equals(wheels.get(i).getTyreType())){
                    throw new WrongTyreTypeException();
                }
            }
        }

        wheels.add(new Wheel(w));
    }

    /**
     * Metodo de instancia getWheels.
     * Este metodo devuelve si el vector de ruedas está vacío un nuevo vector 
     * vacío de ruedas. Si El vector tiene algún componente se devolverá una 
     * copia defensiva del vector.
     * @return n ArrayList'Wheel' se trata de un nuevo vector de ruedas
     */
    public ArrayList<Wheel> getWheels(){ 
        if (wheels == null)
            throw new RuntimeException();

        if (wheels.isEmpty() || wheels.size() == 0) {
            return new ArrayList<Wheel>();
        }

        ArrayList<Wheel> n = new ArrayList<Wheel>();
        for (int i = 0; i < wheels.size(); i++) {
            n.add(new Wheel(wheels.get(i)));
        }

        return n;
    }

    /**
     * Metodo de instancia changeTyres.
     * Este metodo tiene como finalidad cambiar todos los neumáticos de todas las 
     * ruedas del Coche. Esto se hará capturando las excepciones necesarias.
     * - si el neumático es null se lanzará una {@link IllegalArgumentException}
     * - si se detecta una presión inadecuada se lanzará {@link PressureWheelException}
     *
     * @param t {@link TyreType} neumático que va a cambiar
     * @param pressure double presión a la que se va a cambiar.
     *
     * @throws PressureWheelException si el metodo inflate lanza esta excepción este 
     * metodo la volverá a lanzar. 
     */
    public void changeTyres(TyreType t, double pressure) throws PressureWheelException{ 

        if(t == null)
            throw new IllegalArgumentException("ERROR: changeTyres null TyreType");

        if (wheels.size() > 4)
            throw new RuntimeException();

        for (int i = 0; i < wheels.size(); i++) {
            try{
                wheels.get(i).setTyreType(new TyreType(t));
                wheels.get(i).inflate(pressure);
            }catch(NoTyreTypeException ex){
                throw new RuntimeException();
            }catch(PressureWheelException ex){
                System.out.println(ex.getMessage());
                throw new PressureWheelException(pressure);
            }
        }

    }

}

