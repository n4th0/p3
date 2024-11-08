package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Shape2D.
 * this abstract class is the root of the class hierarchy by which we model 
 * two-dimensional figures. As you can tell from a quick glance at the UML diagram,
 * the figures in our model have a position in the plane, specified by a Coordinate 
 * object; this property has its respective getter. In addition, these figures can 
 * be moved (move()), scaled (scale()) and cloned (clone()).
 *
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public abstract class Shape2D {
    /**
     * Instance atribute: position.
     * A simple agreation with the class {@link Coordinate}. 
     */
    Coordinate position;

    /**
     * Instance method: Shape2D.
     * Defalult constructor of the class Shape2D.
     * It initializes the position as a new coordinate with no value of position.
     */
	protected Shape2D() {
        position = new Coordinate();
	}
    /**
     * Instance method: Shape2D.
     * Copy constructor of the class Shape2D.
     * It initializes the position as a new coordinate with the value of the object.
     * @param s {@link Shape2D}
     */
	protected Shape2D(Shape2D s) {
        position = new Coordinate(s.position);
	}
    /**
     * Instance method: Shape2D.
     * Overloaded constructor of the class Shape2D.
     * It initializes the position as a new coordinate with the value of the 
     * parameter.
     * @param s {@link Coordinate}
     */
	protected Shape2D(Coordinate s) {
        position = new Coordinate(s);
	}
    /**
     * Instance method: getPosition.
     * It returns a new {@link Coordinate} using the position as reference.
     * @return Coordinate {@link Coordinate}
     */
    public Coordinate getPosition(){
        return new Coordinate(position);
    }

    /**
     * Instance method: move.
     * It returns the coordinate of the object and put the new position as a 
     * new coordinate of the coordinate passed by parameter. If the parameter
     * is null it will not up date the position.
     *
     * @param c {@link Coordinate}
     * @return {@link Coordinate}
     */
    public Coordinate move(Coordinate c){
        if(c == null)
            return new Coordinate(position);

        Coordinate b = new Coordinate(position);
        position = new Coordinate(c);
        return b;
    }

    /**
     * Instance method: clone.
     * It will return a copy of the object with the position changed.
     * This position is passed by parameter. It does not check if the 
     * coordinate is null or not.
     * @param c {@link Coordinate}
     * @return {@link Shape2D} shape 2d
     */
    public Shape2D clone(Coordinate c){
        
        Shape2D p = this.clone();  
        p.position = new Coordinate(c);
        // p.move(new Coordinate(c));
        return p;
    }

    /**
     * Instance method: toString.
     * It wraps the data of the object in a string with format 
     * "(position)" It will be overwrited by the sons of the class.
     * @return string
     */
    public String toString(){
        return "("+position.toString()+")";
    }

    /**
     *
     * Instance method: scale.
     * abstract method to be implemented by subclasses of Shape2D to scale the 
     * dimensions of a figure. The scaling percentage is specified by the argument,
     * with respect to the current dimensions of the figure and can have any 
     * positive value greater than zero. For example, a value of 100 indicates 
     * keeping the dimensions of the figure unchanged. A value of 50 would indicate 
     * halving the dimensions and a value of 200 would indicate doubling the 
     * dimensions of the figure. This operation does not alter the position of a 
     * figure. It throws IllegalArgumentException if the specified percentage is 
     * negative or zero.
     * @param d doble it will be the percentage of scale.
     */
    public abstract void scale(double d);
    /**
     * Instance method: clone.
     * It will return a copy of the object with the position changed.
     * Usually it will use the copy constructor. You should read it for 
     * the better understanding of the method.
     * @return Shape2D object
     */
    public abstract Shape2D clone();

    /**
     * Instance method: hashCode.
     * determines the hash code for objects, pivotal for collections like 
     * HashMap and HashSet. The method has two variants: the general hashCode()
     * for objects and hashCode(int value) specifically for integers.  
     * @return result int
     */
	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

    /**
     * Instance method: equals.
     * Says if the object passed by atribute is equal or not from the same object.
     * Bassed on his parent class and/or his atributes.
     * @param obj Object to check if equals
     * @return boolean
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape2D other = (Shape2D) obj;
		return Objects.equals(position, other.position);
	}
}
