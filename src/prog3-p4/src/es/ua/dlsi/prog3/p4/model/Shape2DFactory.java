package es.ua.dlsi.prog3.p4.model;

/**
 * Class Shape2DFactory.
 * Factory class whose responsibility is to create figures of the Shape2D hierarchy.
 *
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public class Shape2DFactory {

    /**
     * Instance method: createShape2D.
     * It creates shapes 2D and returns them. If s is circle creates a circle and so on.
     * It could throw a {@link IllegalArgumentException}.
     * @param s {@link String} 
     * @return {@link Shape2D} a new object 
     */
    public static Shape2D createShape2D(String s){

        if (s.equals("Circle")) {
            return new Circle();
        }else if (s.equals("Square")) {
            return new Square();
        }else if (s.equals("Rectangle")) {
            return new Rectangle();
        }

        throw new IllegalArgumentException("no shape scrapped");
    }

}
