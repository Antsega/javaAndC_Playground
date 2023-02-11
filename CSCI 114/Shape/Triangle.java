public class Triangle extends Shape {

    // instance variable(s)
    private double side1;
    private double side2;
    private double side3;

    // constructor
    /*
     * assigns values to a triangle for each side as well as Shape's requirement's
     * 
     * inherits shape constructor with super
     */
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super("Triangle", filled, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /*
     * calls side2, divides by two and multiplies by side1
     * 
     * @return area of triangle
     */
    public double area() {
        double area = (this.side2 / 2) * this.side1;
        return area;
    }

    /*
     * adds all sides together, saves as perimeter
     * 
     * @return perimeter of triangle
     */
    public double perimeter() {
        double perimeter = this.side1 + this.side2 + this.side3;
        return perimeter;
    }

    /*
     * @return calls Shape.toString() and appends Triangle's insance variables
     */
    public String toString() {
        String output = (super.toString() + "[side 1=" + this.side1 + ", side 2=" + this.side2 + ", side 3="
                + this.side3 + "]");
        return output;
    }
}
