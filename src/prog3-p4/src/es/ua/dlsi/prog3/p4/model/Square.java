package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Class: Square.
 * inheirts from {@link AbstractPolygon}.
 * It represents a square with side, angle and position. 
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public class Square extends AbstractPolygon{
    /**
     * Instance atribute: side.
     * The side of the squre.
     */
    private double side;

    /**
     * Instance method: Square.
     * Default constructor of {@link Square}. It initializes the side  
     * to 0 and the position as not defined {@link Coordinate}.
     */
	public Square() {
	}

    /**
     * Instance method: Square.
     * Overloaded constructor of {@link Square}. It initializes the side and angle 
     * passed by parameter and the position as passed by parameter {@link Coordinate}.
     * @param c {@link Coordinate}
     * @param x double angle
     * @param y double side
     */
	public Square(Coordinate c, double x, double y) { 
        super();
        this.move(new Coordinate(c));
        if (y<0) 
            throw new IllegalArgumentException();

        //position = new Coordinate(c);
        this.rotate(x);
        side = y;
	}

    /**
     * Instance method: Square.
     * Copy constructor of {@link Square}. It initializes the side, angle and position
     * using the object passed by argument {@link Coordinate}.
     * @param c {@link Square}
     */
	public Square(Square c) {
        this.move(new Coordinate(c.getPosition()));
        //position = new Coordinate(c.position);
        rotate(c.getAngle());
        side = c.side;
	}

    /**
     * Instance method: getSide.
     * It returns the value of the atribute side.
     * @return side dobule
     */
    public double getSide(){return side;}

    /**
     * {@inheritDoc}
     */
    public void scale(double d){
        if (d<=0) 
            throw new IllegalArgumentException("bad pertentaje");
        side = (side*d)/100;
    }
    /**
     * {@inheritDoc}
     */
    public Square clone(){
        return new Square(this);
    }
    /**
     * Instance method: toString.
     * It returns the data of the object wrapped into a string with this format:
     * coordinate, angle and side.
     * @return string 
     */
    public String toString(){
        return super.toString()+",side="+side;
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side);
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
		Square other = (Square) obj;
		return Double.doubleToLongBits(side) == Double.doubleToLongBits(other.side);
	}
}
