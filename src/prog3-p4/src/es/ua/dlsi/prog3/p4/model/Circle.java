package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Class: Circle.
 * Subclass of Shape2D that models a circle. The centre of the circle corresponds 
 * to the position of the figure (in Shape2D) and its radius is specified by the 
 * radius attribute, which cannot be negative.
 * @author Nathan Rodiguez Moyses 48727425Q
 *
 */
public class Circle extends Shape2D{
    /**
     * Instance atribute: radius.
     * It represents the radius of the circle.
     */
    private double radius;

    /**
     * Instance method: Circle.
     * Default constructor of {@link Circle}. It initializes the radius to 0
     * and the position as not defined {@link Coordinate}.
     */
	public Circle() {
        super(new Coordinate());
        radius = 0;
        // position = new Coordinate();
	}

    /**
     * Instance method: Circle.
     * Overloaded constructor of {@link Circle}. It initializes the radius to d
     * and the position as passed by argument 
     * @param c {@link Coordinate}.
     * @param d double 
     */
	public Circle(Coordinate c, double d) {
        super(new Coordinate(c));
        if (d<0) 
            throw new IllegalArgumentException("negative radius");
        radius = d;
        // position = new Coordinate(c);
	}

    /**
     * Instance method: Circle.
     * Copy constructor of {@link Circle}.  IT will do a deep copy of all the 
     * atributes of the class.
     * @param c {@link Circle}
     */
	public Circle(Circle c) {
        super(new Coordinate(c.getPosition()));
        // this.position = new Coordinate(c.position);
        this.radius = c.radius;
	}

    /**
     * Instance method: getRadius.
     * It returns the value of the radius atribute.
     * @return radius.
     */
	public double getRadius() {
        return radius;
	}

    /**
     * Instance method: toString.
     * It returns the data of the object parsed to a string
     * format: (coordinate),radius=[radius]
     * @return string 
     */
    public String toString(){
        return super.toString()+",radius="+getRadius();
    }

    /**
     * {@inheritDoc}
     */
    public Circle clone(){
        return new Circle(this);
    }

    /**
     * {@inheritDoc}
     */
    public void scale(double d){
        if (d<=0) 
            throw new IllegalArgumentException("bad pertentaje");
        
        radius = (radius*d)/100;
    }
    /**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return Objects.hash(radius);
	}
    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        if(!super.equals(obj))
			return false;
		Circle other = (Circle) obj;
		return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
	}
}
