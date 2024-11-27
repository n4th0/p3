
package es.ua.dlsi.prog3.p2.model;

import java.util.Objects;

/**
 * TyreType. 
 * La responsabilidad de esta clase es la de almacenar los atributos de los 
 * distintos tipos de neumáticos que puedan existir. Se trata de una clase 
 * inmutable. Para hacerla inmutable no se permitirá la variación de ningún 
 * atributo. Se le pondrá la etiqueta 'final' para facilitar esto.
 *
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public final class TyreType {

    /**
     * Atributo de instancia description.
     * Descripción del neumatico privado para la encapsulación del objeto. Para
     * mantener la inmutabilidad de la clase se hará copia defensiva ahí donde se 
     * pueda.
     */
	private String description;

    /**
     * Atributo de instancia min_preassure.
     * Presión minima del neumatico, no puede ser menor de 0. Privado para la 
     * encapsulación del objeto. Para mantener la inmutabilidad de la clase se 
     * hará copia defensiva ahí donde se pueda.
     *
     */
    private double min_preassure;

    /**
     * Atributo de instancia max_preassure.
     * Presión máxima del neumatico, no puede ser menor de 0 ni menor que 
     * min_preassure. Privado para la encapsulación del objeto. Para mantener 
     * la inmutabilidad de la clase se hará copia defensiva ahí donde se pueda.
     */
    private double max_preassure;

    /**
     * Constructor.
     * Constructor con parámetros para construir el objeto. Se hace una copia
     * defensiva ya que la clase es inmutable. Lanzará una excepción en los 
     * siguientes casos:
     * - si la descripcion es null
     * - si la descripcion está vacía
     * - si la presión minima es menor que 0
     * - si la presión máxima es menor que la presión mínima
     * 
     *
     * @param desc String descriptción del neumatico. No puede estar vacía ni 
     * ser null
     * @param min double presión minima del neumatico. No puede ser menor o igual 
     * que 0
     * @param max double presión máxima del neumatico. No puede ser igual o menor 
     * que min.
     */
    public TyreType(String desc, double min, double max){
        if(desc == null || desc.isEmpty() || min < 0 || max < 0 || min > max)
            throw new IllegalArgumentException(
                    "ERROR: TyreType constructor parameters wrong");

        description = new String(desc);
        min_preassure = min;
        max_preassure = max;
    }

    /**
     * Copy constructure.
     * Constructor copia de la clase TyreType. Se hace copia defensiva en todos 
     * los atributos. No lanza ninguna excepción ya que se presupone que el 
     * objeto está bien creado. 
     *
     * @param t TyreType Objeto 
     */
    public TyreType(TyreType t){
        description = new String(t.description);
        min_preassure = t.min_preassure;
        max_preassure = t.max_preassure;
    }

    /**
     * Metodo de instancia: getMinPressure.
     * Devuelve el entero que representa la mínima presión del neumático. Se hace
     * una copia profunda porque el tipo de dato double es primitivo.
     *
     * @return min_preassure double
     */
    public double getMinPressure(){
        return min_preassure;
    }

    /**
     * Metodo de instancia: getMaxPressure.
     * Devuelve el entero que representa la máxima presión del neumático. Se hace
     * una copia profunda porque el tipo de dato double es primitivo.
     *
     * @return max_preassure double
     */
    public double getMaxPressure(){
        return max_preassure;
    }

    /**
     * Metodo de instancia: toString.
     * Este metodo devuelve un objeto de la clase String que repersenta el 
     * objeto, indicando su descripcion y su mínima y máxima presión (en este 
     * orden).
     * @return TyreType "+description+" ["+min_preassure+","+max_preassure+"]
     */
    public String toString(){
        return "TyreType "+description+" ["+min_preassure+","+max_preassure+"]";
    }

    /**
     * Metodo de instancia: equals.
     * Este metodo devuelve si un objeto es igual o no al objeto pasado por 
     * parámetro. Este metodo es sobreescritp de la clase padre Object. La 
     * implementación tendrá en cuenta todos los atributos de la clase.
     *
     * @param obj Object objeto a comparar. 
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TyreType other = (TyreType) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(max_preassure) == Double.doubleToLongBits(other.max_preassure)
				&& Double.doubleToLongBits(min_preassure) == Double.doubleToLongBits(other.min_preassure);
	}

}
