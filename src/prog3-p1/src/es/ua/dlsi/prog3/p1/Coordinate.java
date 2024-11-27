package es.ua.dlsi.prog3.p1;
import java.util.*;

/**
 * first class made in java for programming 3 subject.
 * Clase inmutable para la asignatura de programacion 3
 * se ha hecho la clase final y sus atributos privados 
 * sin setters más que el que se proporciona en el constructor
 * Esto hace que se una clase completa a la hora de aprender la OOP.
 *
 * 
 * @author Nathan Rodriguez Moyses 48727425Q
 */
public final class Coordinate {

    /**
     * Components.
     * Array de componentes del objeto.
     */
    private double components[];

    /**
     * Constructor.
     * Constructor que crea el objeto mediante el array que se le ha pasado por 
     * parámetro. Hace una copia defensiva del array para conservar la 
     * inmutabilidad de la clase Coordinate. Si este array es apunta a null 
     * se creará un objeto cuya longitud es 0, manteniendo así la inmutabilidad de la 
     * clase.
     *
     * @param components vector de doubles que se usarán para instanciar 
     * el atributo 'components'. Esto se hará de manera defensiva para manetener 
     * la inmutabilidad de la clase
     */
    public Coordinate(double components[]) {
        if (components == null) {
            this.components = new double[0];
            return;
        }

        // defensive copy
        double comp[] = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            comp[i] = components[i];
        }

        this.components = comp;
    }

    /**
     * Copy constructor.
     * Cosntructor que crea un objeto a partir de la copia defensiva que proporciona 
     * el getter del atributo components. Esto se consigue creando un objeto 
     * double con la longitud del objeto creado.
     *
     * @param coordinate este objeto será proporcionado por el código cliente 
     * se podrá crearse a partird el constructor con parámetros 'components'
     * se hará una copia defensiva de este objeto
     */
    public Coordinate(Coordinate coordinate) {
        this.components = coordinate.getComponents();
    }

    /**
     * getComponents.
     * Devuelve un array de doubles idéntico a los componentes del objeto. Esto se 
     * hará de manera defensiva para manetener la inmutabilidad de la clase. 
     *
     *
     * @return comps array que tiene como referencias los doubles del
     * atributo 'components', esto hace que se mantenga la inmutabilidad de 
     * la clase
     */
    public double[] getComponents() {
        double comp[] = new double[this.getDimensions()];

        for (int i = 0; i < comp.length; i++) {
            comp[i] = this.components[i];
        }

        return comp;
    }

    /**
     * GetDimensions.
     * Devuelve la longitud de los componentes del objeto esto siempre será una 
     * copia defensiva ya que un integer es un dato primario el cual se atribuirá 
     * una nueva direccion de memoria nueva.
     *
     * @return components.length se obtiene a partir del atributo length del
     * atributo 'components'
     */
    public int getDimensions() {
        return components.length;
    }

    /**
     * HashCode.
     * Genenerador de hascode, lo genera automáticamente eclipse Source\generate 
     * hascode. Devuelve un número de 32 bits ( int ) para cualquier objeto. 
     *
     * @return un identificador del objeto utiliza el metodo Arrays.hashCode(components)
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(components);
        return result;
    }


    /**
     * Equals.
     * El método equals() compara dos cadenas y devuelve verdadero si las 
     * cadenas son iguales y falso si no lo son. Lo genera automáticamente eclipse 
     * Source\generate equals.
     *
     * @return booleano que determina si los objetos son iguales o no
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Coordinate other = (Coordinate) obj;
        return Arrays.equals(components, other.components);
    }
}
