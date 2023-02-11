public class Rectangle extends Shape {
    // instance variables
    private double length;
    private double width;

    // constructor
    /*
     * Assigns a length and width for a rectangle
     * 
     * Inherits Shape class constructor
     */
    public Rectangle(double length, double width, String color, boolean filled) {
        super("Rectangle", filled, color);
        this.length = length;
        this.width = width;
    }

    /*
     * Calculates area of a rectangle
     * 
     * @return length * width
     */

    public double area(){
        double area = this.length * this.width;
        return area;
    }

    /*
     * Calculates perimeter of a rectangle
     * 
     * @return (length + width) * 2 
     */
    public double perimeter() {
        double perimeter = 2 * (this.length + this.width);
        return perimeter;
    }

     /*
     * @return calls Shape.toString() and appends Rectangle's insance variables
     */
    public String toString() {
        String output = (super.toString() + "[length=" + this.length + ", width=" + this.width + "]");
        return output;
    }

}
