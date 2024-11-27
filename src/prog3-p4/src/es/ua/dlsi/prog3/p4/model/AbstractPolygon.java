package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Class AbstrcatPolygon.
 * Inherits from {@link Shape2D}. Abstract class that represents a polygon
 * it can rotate, with the new atribute angle.
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public abstract class AbstractPolygon extends Shape2D {
    /**
     * Instance atribute: Angle.
     * The angle what has got the polygon.
     */
    private double angle;

    /**
     * Instance method: AbstractPolygon.
     * Constructor of the class. Creates a new Coordinate without
     * position.
     */
	protected AbstractPolygon() {
        super(new Coordinate());
        //position = new Coordinate();
        angle = 0;
	}

    /**
     * Instance method: AbstractPolygon.
     * Constructor of the class. Creates a new Coordinate with the position 
     * that contains the argument c. 
     * @throws IllegalArgumentException if the angle is not in [0, 360)
     * @param c {@link Coordinate}
     * @param d double angle
     */
    protected AbstractPolygon(Coordinate c, double d){
        super(new Coordinate(c));
        if (d<0 || d>=360) 
            throw new IllegalArgumentException("bad angle");

        //position = new Coordinate(c);
        angle = d;
    }

    /**
     * Instance method: AbstractPolygon.
     * Copy constructor of the class. It makes a new Coordinate using deep Copy
     * to still getting the agregation correctly implemented.
     * @param a {@link AbstractPolygon} object
     */
    protected AbstractPolygon(AbstractPolygon a){
        super(new Coordinate(a.getPosition()));
        //position = new Coordinate(a.position);
        angle = a.angle;
    }

    /**
     * Instance method: getAngle.
     * It returns the angle of the object.
     * @return angle double.
     */
    public double getAngle(){ return angle; }

    /**
     * Instance method: toString.
     * It wraps the data of the object in a string with format "(position),angle=[a]"
     * @return string
     */
    public String toString(){return super.toString()+",angle="+getAngle();}

    /**
     * Instance method: rotate.
     * It rotates the polygon updating the angle atribute. It could initialize the 
     * angle too.
     * @throws IllegalArgumentException if the angle is greater or equal than 360 or -360
     * @param d double angle to rotate
     */
    public void rotate(double d){
        if (d<=(-360) || d>=360)
            throw new IllegalArgumentException("bad angle");

        angle = angle+d;

        if (angle >= 360) {
            angle -=360;
        }else if (angle < 0) {
            angle +=360;
        }
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(angle);
		return result;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		AbstractPolygon other = (AbstractPolygon) obj;
		return Double.doubleToLongBits(angle) == Double.doubleToLongBits(other.angle);
	}
}
