/**
 * This program represents a rectangle.
 * 
 * @author: Anthony W. Smith 
 * @version: 5/31/2028
 */

public class Rectangle
{
    // instance variables
    private double length;
    private double width;
    
    // constructor method
    public Rectangle(double len, double w)
    {
        length = len;
        width = w;
    }

    // method that calculates area
    public void calculateArea()
    {
        System.out.println("Area is: " + (length + width));
    }
}
