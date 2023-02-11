/*
 * Recreates the java.util.Stack class
 * 
 * @author Anthony Segarra
 * @version 11/13/2022
 */
public class Stack
{
    public static final int MAX = 9; 

    private int element[];      //array of ints
    private int top;            //index of item at top of the stack

    // creates array with max indexs
    // initialize's int top's value
    public Stack()
    {
        element = new int[MAX];
        top = -1;   //means stack is empty
    }
    
    
    // Evaluates the value of top
    // If top greater than or equal the limit of the stack, print "Overflow" and exit method; will never hit because cannot assign values outside of array index, however good practice to program for it
    // otherwise 
    // top is incremented; first call would make top = 0
    // assigns provided paramater to an individual index of the stack's array
    public void push(int number) {
        if (top >= MAX) {
            System.out.println("Stack overflow in push()");
            throw new IllegalArgumentException("Stack overflow in pop()");
        }
            top++;
            element[top] = number;
}

// evaluates the value of top; if top is -1, the Stack is empty and prints "underflow error"
// // @return throw error instead of an integer
// otherwise
// the value of the last element is grabbed in the array
// the array's top element is reassigned to 0
// decrements top value
// @return lastElement of original array
    public int pop() {
        if (top <= -1) {
            System.out.println("Stack underflow in pop()");
            throw new IllegalArgumentException("Stack underflow in pop()"); // added throw error so I didn't have to return an int, like -1
        }  
            int lastElement = element[top];
            element[top] = 0;
            top--;
            return lastElement;
}

    // evaluates the value of top
    // if top is less than negative 1, represents the Stack is empty
    //  // @return false
    // else @return true
    public boolean isEmpty() {
        if (top <= -1) return true;
        return false;
    }
}
