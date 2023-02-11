import java.util.ArrayList; // to create and manipulate array list(s)

public class Tester {

    public static void main(String[] args) {
        // creates new arrayList
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        // creates new shapes with desired values
        Triangle tri = new Triangle(3.0, 2.5, 2.0, "white", true);
        Rectangle rect = new Rectangle(2.0, 4.0, "red", true);
        Circle circ = new Circle(1.0, "yellow", false);

        // adds the shapes to the arrayList
        shapes.add(tri);
        shapes.add(rect);
        shapes.add(circ);

        // First traverse
        System.out.println("Starting shapes");
        /*
         * Loops through shapes AL
         * Sys.prnt : calls .toString() for each element
         * Sys.prnt : calls .perimeter() for each element, formats to 2 decimal places
         * Sys.prnt : calls .area() for each element and formats to 2 decimal places
         */
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).toString());
            System.out.printf("Perimeter is: " + String.format("%.2f", (shapes.get(i).perimeter())) + "\n");
            System.out.printf("Area is: " + String.format("%.2f", (shapes.get(i).area())) + "\n\n");
        }

        // Reassigning each shape's value(s)
        tri = new Triangle(3.0, 2.5, 2.0, "white", false);
        rect = new Rectangle(2.0, 4.0, "blue", true);
        circ = new Circle(1.0, "black", true);

        // reassign shapes index values after reassigning each shape's value(s)
        shapes.set(0, tri);
        shapes.set(1, rect);
        shapes.set(2, circ);

        // Final traverse
        System.out.println("Changed shapes");
        // Calls .toString() for each element in shapes AL
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).toString());
        }
    }
}
