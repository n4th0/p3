package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Class: Rectangle.
 * A class what represents a rectangle.
 * inherits from {@link AbstractPolygon}.
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public class Rectangle extends AbstractPolygon{
    /**
     * Instance atribute: length.
     * The length of the rectangle.
     */
    private double length;
    /**
     * Instance atribute: width.
     * The length of the width.
     */
    private double width;

    /**
     * Instance method: Rectangle.
     * Default constructor of {@link Rectangle}. It initializes the length and width 
     * to 0 and the position as not defined {@link Coordinate}.
     */
	public Rectangle() {
        this.move(new Coordinate());
        length = 0;
        width = 0;
        //position = new Coordinate();
	}

    /**
     * Instance method: Rectangle.
     * Overloaded constructor of {@link Rectangle}. It initializes the length 
     * and width passed by parameter and the position as passed by parameter
     * @param c {@link Coordinate}
     * @param a double angle
     * @param b double length
     * @param d double width
     */
	public Rectangle(Coordinate c, double a, double b, double d) {
        if (b <0 || d <0) 
            throw new IllegalArgumentException();
        
        // position = new Coordinate(c);
        this.move(new Coordinate(c));
        length = b;
        width = d;

        this.rotate(a);
	}

    /**
     * Instance method: Rectangle.
     * Copy constructor of {@link Rectangle}. It initializes the length 
     * and width with the object passed by parameter and the position 
     * with the object passed by parameter
     * @param r {@link Rectangle}
     */
	public Rectangle(Rectangle r) {
        move(r.getPosition());
        this.length = r.length;
        this.width = r.width;
        //position = new Coordinate(r.position);
	}

    /**
     * Instance method: getLength.
     * returns the length of the object
     * @return length double
     */
    public double getLength(){ return length; }

    /**
     * Instance method: getWidth.
     * returns the width of the object
     * @return width double
     */
    public double getWidth(){ return width; }

    /**
     * Instance method: toString.
     * Wraps the data of the object into a string with teh following schema.
     * position+",angle=angle,length="+length+",width="+width;
     * @return stirng {@link String}
     */
    public String toString(){
        return super.toString()+",length="+length+",width="+width;
    }

    /**
     * {@inheritDoc}
     */
    public void scale(double a){
        if (a<=0) 
            throw new IllegalArgumentException("bad pertentaje");

        width = (width*a)/100;
        length = (length*a)/100;
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle clone(){
        return new Rectangle(this);
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(length, width);
		return result;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

}
