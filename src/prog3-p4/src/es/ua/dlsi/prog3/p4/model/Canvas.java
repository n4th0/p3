package es.ua.dlsi.prog3.p4.model;
import java.util.*;

/**
 * Class Canvas.
 * Canvas represents a canvas containing two-dimensional geometric figures. 
 * A canvas has a title and dimensions (whose default value is DEFAULT_SIZE),
 * specified by the width and height attributes. The canvas contains a list of 
 * figures of type Shape2D.
 * @author Nathan Rodiguez Moyses 48727425Q
 */
public class Canvas {

    /**
     * Class atribute: DEFAULT_SIZE.
     * Inizialized at 1000. It is the default size for width and height.
     */
    public static final float DEFAULT_SIZE = 1000;

    /**
     * Instance atribute: title.
     * The title of the class. It's a string
     */
    private String title;

    /**
     * Instance atribute: width.
     * The width of the canvas If it is not specified it will be 1000.
     */
    private double width;

    /**
     * Instance atribute: height.
     * The height of the canvas If it is not specified it will be 1000.
     */
    private double height;

    /**
     * Instance atribute: shapes.
     * Array list of shapes. its an agregation for the Shape2D entity.
     */
    private ArrayList<Shape2D> shapes;

    /**
     * Instance method: Canvas.
     * Canvas default constructor. It initializes the title as "default canvas"
     * and width and height as the Default size.
     */ 
	public Canvas() {
        shapes = new ArrayList<>();
        title = "default canvas";
        width = DEFAULT_SIZE;
        height = DEFAULT_SIZE;
	}
    /**
     * Instance method: Canvas.
     * Canvas copy constructor. It initializes the atributes as the title of the 
     * object passed by argument.
     * @param c {@link Canvas}
     */
	public Canvas(Canvas c) {
        shapes = new ArrayList<>(); 
        for (int i = 0; i < c.getNumShapes(); i++) {
            shapes.add(c.getShape(i+1).clone());
        }

        title = c.title;
        width = c.width;
        height = c.height;
	}

    /**
     * Instance method: Canvas.
     * Canvas overloaded constructor. It Inizializes as the folowing order: title, 
     * width amd lastly height
     * @param s String
     * @param a double
     * @param b double
     * @throws IllegalArgumentException if a || b less than 0
     */
	public Canvas(String s, double a, double b) {
        if (a<0 || b<0) 
            throw new IllegalArgumentException();
        
        shapes = new ArrayList<>();
        title = s;
        width = a;
        height = b;
	}

    /**
     * Instance method: addShape.
     * Adds a new object using the clone method to the array of Shapes2D called 
     * shapes making the agregation correctly implemented.
     * @param s {@link Shape2D}
     */
    public void addShape(Shape2D s){
        shapes.add(s.clone());
    }

    /**
     * Instance method: clone.
     * It will return a copy of the object with the position changed.
     * Usually it will use the copy constructor. You should read it for 
     * the better understanding of the method.
     * @return Canvas a copy of the object
     */
    public Canvas clone(){
        return new Canvas(this);
    }

    /**
     * Instance method: getShape.
     * gives a new shape due the index passed by parameter. It sees the vector
     * started by 1. It could throw an {@link IndexOutOfBoundsException}
     * @param n int 
     * @return a shape of the shapes arraylist
     */
    public Shape2D getShape(int n){
        // if (n <1 || n>shapes.size()) {
        //     throw new IndexOutOfBoundsException();
        // }

        return shapes.get(n-1).clone();
    }

    /**
     * Instance method: getWidth.
     * It returns the width of the figure.
     * @return width double
     */
    public double getWidth(){
        return width;
    }

    /**
     * Instance method: getHeight.
     * It returns the height of the figure.
     * @return height double
     */
    public double getHeight(){
        return height;
    }

    /**
     * Instance method: getNumShapes.
     * It returns the num of shapes of the canvas.
     * @return size double
     */
    public int getNumShapes(){
        return shapes.size();
    }

    /**
     * Instance method: removeShape.
     * It removes the figure accesed by index of the array.
     * It could trhow a {@link IndexOutOfBoundsException}.
     * @param n int position of the shape
     */
    public void removeShape(int n){
        shapes.remove(n-1);
    }

    /**
     * Instance method: toString.
     * Wraps the data of the object into a string with teh following schema.
     *  title+" ("+width+","+height+") with "+getNumShapes()+" shapes";
     * @return string {@link String}
     */
    public String toString(){
        return title+" ("+width+","+height+") with "+getNumShapes()+" shapes";
    }

}
