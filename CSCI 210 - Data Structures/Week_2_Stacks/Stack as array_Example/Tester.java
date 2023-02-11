/*
 * Tests the Stack class
 * 
 * @author Anthony Segarra
 * @version 11/13/2022
 */

// Creates an instance of the Stack class
    // pushes 5 values to the stack
    // pops each index while stack still contains values
    // calls .pop() again for underflow testing
public class Tester
{
    public static void main()
    {
        Stack s = new Stack();

        for (int x = 1; x < 6; ++x)
            s.push(x);

        while (!s.isEmpty())
            System.out.println(s.pop());

        //test empty stack error            
        s.pop();
    }
}
