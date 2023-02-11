import java.awt.Rectangle;

/**
 * Demonstrates how to create objects and call methods.  Uses the Rectangle
 * class from the Java library.
 * 
 * @author Anthony W. Smith 
 * @version 5/31/2018
 */
public class Rectangles
{
    public static void main(String[] args)
    {
        // create some Rectangle objects
        Rectangle myRectangle = new Rectangle(10, 10, 20, 30);
        Rectangle yourRectangle = new Rectangle(20, 40, 40, 50);
        Rectangle bigRectangle = new Rectangle(0, 0, 100, 200);
        
        // a method acts upon a particular object
        myRectangle.translate(20, 30);
        System.out.println("myRectangle is moved to: " + myRectangle.toString());
        
        // another example of a method call with params
        yourRectangle.grow(10, 20);
        System.out.println("\nyourRectangle grows to: " + yourRectangle.toString());
        
        // example of a method call with returned value
        System.out.println("\nyourRectangle’s height is now: " + yourRectangle.getHeight());
        
        // several object references can point to the same object
        Rectangle aRectangle = bigRectangle;
        System.out.println("\nbigRectangle and aRectangle both point to the same object: " +
                                                                        aRectangle.toString());
    }
}
