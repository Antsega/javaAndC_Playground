/**
 * Hello is an example of Java class syntax.
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class Hello
{
    // example instance variable
    private int doesNothing;

    /**
     * Constructor method for objects of class Hello
     */
    public Hello()
    {
        doesNothing = 0;    // initialize all instance variables
    }
 
    /**
     * Example method that sends output to the Terminal Window
     */
    public void sayHello()
    {
        System.out.print("Hello, world!\n");
        System.out.println("doesNothing is: " + doesNothing);
    }
}
