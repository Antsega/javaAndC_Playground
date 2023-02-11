
/**
 * This program calculates the area of a rectangle.
 *
 * @author: Anthony Segarra
 * @version: 21 Aug 2022
 */
public class Rectangle
{
    // instance variables - replace the example below with your own
    private double length;
    private double width;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double len, double w)
    {
        // initialise instance variables
        length = len;
        width = w;
    }

    /** method that calculates area **/
    public void calculateArea()
    {
        // put your code here
        System.out.print("Area is: " + (length * width));
    }
}
