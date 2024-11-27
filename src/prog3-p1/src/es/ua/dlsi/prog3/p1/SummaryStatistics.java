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
     * Lleva la cuenta de cuantos objetos se han creado. Es estático ya que debe ser 
     * único para la clase.
     */
    private static int NEXT_ID = 1;
    
    /**
     * atributo de objeto id.
     * identificador del objeto es distinto para cada objeto se obtendrá a partir del 
     * atributo estático NEXT_ID.
     */
    private int id;

    /**
     * atributo de objeto values.
     * vector de enteros, nunca está a null. Este se modificará en las funciones
     * 'add', y en los constructores
     */
    private ArrayList<Integer> values;

    /**
     * Constructor. 
     * Este constructor no recibe parámetros e inicializa el atributo 
     * values a un vector de 0 elementos.
     * Se sumará a 1 el NEXT_ID para llevar la cuenta de los objetos creados.
     * Es un constructor que no recibe parámetros.
     */
    public SummaryStatistics(){
        id = NEXT_ID;
        NEXT_ID++;
        values = new ArrayList<Integer>(0);
    }

    /**
     * Constructor. 
     * El constructor construye un objeto con los valores que se introduzcan
     * por el vector que recibe por parámetro. Se le sumará 1 al atributo de clase
     * NEXT_ID y se le asignará el identificador correspondiente al objeto.
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
     * El constructor construye un objeto con los valores que tenga el objeto
     * en el atributo 'values'. Se le asignará un nuevo id al objeto sumándole 
     * 1 al atributo de clase 'NEXT_ID'. Se hará una copia defensiva del atributo
     * values.
     * @param s SummaryStatistics Objeto que se copiará de forma defensiva  
     */
    public SummaryStatistics(SummaryStatistics s){
        this.id = NEXT_ID;
        NEXT_ID++;

        this.values = new ArrayList<Integer>(s.values);
    }

    /**
     * Metodo de instancia add.
     * Introduce un valor en el vector que tiene como atributo el objeto
     * este valor debe ser un integer y se le asignará una posicion consecuente al
     * orden de introducción al vector.
     * @param value int valor a introducir en el vector del objeto
     */
    public void add(int value){
        values.add(value);
    }

    /**
     * Metodo de instancia getter de id.
     * Esta funcion devuelve un int cuyo valor corresponde al id del objeto,
     * se usará para tener constancia de qué objeto se está usando en cada momento.
     * @return int el id del objeto
     */
    public int getId(){
        return id;
    }

    /**
     * Metodo de instancia getter de la media de values.
     * Retorna la media de los valores almacenados en el atributo values. Si 
     * el vector values está vacío, devolverá null.
     * @return n media del ArrayList values.
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
     * Metodo de instancia getter del valor máximo del vector.
     * este método devuelve un Integer cuyo valor corresponde al valor máximo
     * del vector, si el vector values está vacio, devolverá null.
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
     * Metodo de instancia getter del valor mínimo del vector.
     * este método devuelve un Integer cuyo valor corresponde al valor mínimo
     * del vector, si el vector values está vacío, devolverá null.
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
     * Metodo de instancia getter del tamaño del vector.
     * Este método devuelve un int cuyo valor corresponde al valor del tamaño
     * del vector.
     * @return valor del tamaño del ArrayList values.
     */
    public int getSize(){
        return values.size();
    }

    /**
     * Metodo de instancia getter de la cantidad de objetos que se han generado.
     * Método estático. Devuelve un int que corresponde a cuántos objetos 
     * se han instanciado, esto se hará restando 1 a NEXT_ID y devolviendo este 
     * valor.
     * @return valor de cuantos objetos se han instanciado.
     */
    public static int COUNT_INSTANCES(){
        int a = NEXT_ID;
        a--;
        return a;
    }

}

