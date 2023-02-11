public abstract class Shape {
    // instance variable(s)
    private String color;
    private boolean filled;
    private String name;

    /*
     * Constructor
     * Creates a shape that requires a Str name, bool fill, and Str color 
     */
    public Shape(String name, boolean filled, String color) {
        this.name = name;
        this.color = color;
        this.filled = filled;
    }

    /*
     * @return Shape's color
     */
    public String getColor() {
        return this.color;
    }

    /*
     * @return boolean depending on filled value
     */
    public boolean filled() {
        return this.filled;
    }

    /*
     * Created abstract perimeter, for the calculation will be different depending on the subclass
     */
    public abstract double perimeter();

    /*
     * Created abstract area, for the calculation will be different depending on subclass
     */
    public abstract double area();
    
    /*
     * @return formated toString()
     */
    public String toString() {
        String output = this.name + "[color=" + this.color + ", " + "filled=" + this.filled + "]";
        return output;
    }

}
