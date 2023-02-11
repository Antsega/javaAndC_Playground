public class Circle extends Shape {
    // instance variable
    private double radius;

    /*
     * Constructor
     * 
     * Creates a circle with a radius
     * 
     * Inherits Shape constructor
     */
    public Circle(double radius, String color, boolean filled) {
        super("Circle", filled, color);
        this.radius = radius;
    }

    /*
     * Calculates area of a circle
     * 
     * @return PI * radius^2
     */
    public double area() {
        double area = (Math.PI * Math.pow(this.radius, 2.0));
        return area;
    }

    /*
     * Calculates perimeter of a circle
     * 
     * @return 2 * PI * radius
     */
    public double perimeter() {
        double perimeter = (2.0 * Math.PI * this.radius);
        return perimeter;
    }

    /*
     * @return calls Shape.toString() and appends Circle's insance variables
     */
    public String toString() {
        String output = (super.toString() + "[radius=" + this.radius + "]");
        return output;
    }
}
