package es.ua.dlsi.prog3.p1;

import java.util.*;

/**
 * First class made in java for programming 3 subject.
 * Esta clase propociona una cantidad de funciones alrededor de dos ideas 
 * La identificación del objeto. Se van contando los objetos que se crean.
 * El uso de la clase ArrayList entorno a la clase Integer.
 * Esto hace que se una clase completa a la hora de aprender la OOP.
 * 
 * @author Nathan Rodriguez Moyses 48727425Q
 */
class SummaryStatistics{

    /**
     * atributo de objeto NEXT_ID.
     * Lleva la cuenta de cuantos objetos se han creado. Es estático ya que 
     * debe ser único para la clase.
     */
    private static int NEXT_ID = 1;
    
    /**
     * atributo de objeto id.
     * identificador del objeto es distinto para cada objeto
     */
    private int id;

    /**
     * atributo de objeto values.
     * vector de enteros, nunca está a null.
     */
    private ArrayList<Integer> values;

    /**
     * Constructor. 
     * Este constructor no recibe parámetros e inicializa el atributo 
     * values a un vector de 0 elementos. Se sumará a 1 el NEXT_ID para 
     * llevar la cuenta de los objetos creados.
     */
    public SummaryStatistics(){
        id = NEXT_ID;
        NEXT_ID++;
        values = new ArrayList<Integer>(0);
    }

    /**
     * Constructor. 
     * El constructor construye un objeto con los valores que se introduzcan
     * por el vector que recibe por parámetro. 
     *
     * @param values  ArrayList de enteros que se copiarán de forma 
     * defensiva y se asignarán al atributo values
     */
    public SummaryStatistics(ArrayList<Integer> values){
        id = NEXT_ID;
        NEXT_ID++;

        this.values = new ArrayList<Integer>();

        for (int i = 0; i < values.size(); i++) {
            this.values.add(values.get(i));
        }
    }

    /**
     * Copy constructor. 
     * El constructor construye un objeto con los valores que se introduzcan
     * @param s SummaryStatistics Objeto que se copiará de forma defensiva  
     */
    public SummaryStatistics(SummaryStatistics s){
        this.id = NEXT_ID;
        NEXT_ID++;

        this.values = new ArrayList<Integer>(s.values);
    }

    /**
     * Método add.
     * introduce un valor en el vector que tiene como atributo el objeto
     * @param value int valor a introducir en el vector del objeto
     */
    public void add(int value){
        values.add(value);
    }

    /**
     * Getter de id.
     * esta funcion devuelve un int cuyo valor corresponde al id del objeto
     * @return int el id del objeto
     */
    public int getId(){
        return id;
    }

    /**
     * Getter de la media de values.
     * Retorna la media de los valores almacenados en values. 
     * Si values está vacío devolverá null
     * @return media del ArrayList values.
     */ 
    public Integer getAverage(){
        if(values.isEmpty())
            return null;

        Integer n = 0;

        for (int i = 0; i < values.size(); i++) {
            n += values.get(i);
        }

        n = n/values.size();
        return n;
    }

    /**
     * Getter del valor máximo del vector.
     * este método devuelve un Integer cuyo valor corresponde al valor máximo
     * del vector
     * @return valor máximo del ArrayList values.
     */
    public Integer getMax(){
        if(this.values.isEmpty())
            return null;

        Integer n = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            n = Math.max(n, values.get(i));
        }
        return n;

    }

    /**
     * Getter del valor mínimo del vector.
     * este método devuelve un Integer cuyo valor corresponde al valor mínimo
     * del vector
     * @return valor mínimo del ArrayList values.
     */
    public Integer getMin(){
        if(this.values.isEmpty())
            return null;

        Integer n = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            n = Math.min(n, values.get(i));
        }
        return n;
    }

    /**
     * Getter del tamaño del vector.
     * este método devuelve un int cuyo valor corresponde al valor del tamaño
     * del vector
     * @return valor del tamaño del ArrayList values.
     */
    public int getSize(){
        return values.size();
    }

    /**
     * Getter de la cantidad de objetos que se han generado.
     * Método estático. Devuelve un int que corresponde a cuántos objetos 
     * se han instanciado.
     * @return valor de cuantos objetos se han instanciado.
     */
    public static int COUNT_INSTANCES(){
        int a = NEXT_ID;
        a--;
        return a;
    }

}

