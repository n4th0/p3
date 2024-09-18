
import java.util.Arrays;
// package es.ua.dlsi.prog3.p1;

/**
 * first class made in java for programming 3 subject
 * @author n4th0
 */
public final class Coordinate {

    private double components[];

    /**
     * constructor
     * @param components double [] 
     */
    public Coordinate(double components[]) {
        if (components.length == 0) {
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
     * copy constructor
     * @param coordinate param where we are going to get all the object
     */
    public Coordinate(Coordinate coordinate) {
        this.components = coordinate.getComponents();
    }

    /**
     * it returns the components of the object
     * @return the components of the class 
     * i'm using the defensive compy to make the class unmutable
     */
    public double[] getComponents() {
        double comp[] = new double[this.getDimensions()];
        for (int i = 0; i < comp.length; i++) {
            comp[i] = this.components[i];
        }
        return comp;
    }

    /**
     * getter of the dimension of the component
     * @return the component's length
     */
    public int getDimensions() {
        return components.length;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(components);
        return result;
    }


    /**
     * It returns if its equals or not
     * @return if the objects are equals
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
