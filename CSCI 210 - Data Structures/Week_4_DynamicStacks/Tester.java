/*
/ Intakes any length of integers initially casted as strings.
/ pushes them into their own individual stack.
/
/ pops each stack one by one and adds the value(s), pushing the result into a new stack, 
/ carrying a 1 if applicable; e.g 9 + 8 --> carry 1, push 7.
/
/ loops through both stacks until completly empty
/ ensures to push any left over carry value(s), when applicable.
/ loops through the resultsStack and pops each value to print the first and second stack's total sum
*/


/*
 * Uncomment associated test cases to test program correctly
 * e.g lines 22 through 31. Choose associated String's with
 *  lines 115 through 121 result String
 */
public class Tester {
    public static void main(String args[]) {

                //first test
                String first = "99999";
                String second = "999";
        
                //second test
                // String first = "89";
                // String second = "9876";
        
                //third test
                // String first = "2147483647";
                // String second = "2147483647";
        
                //the 3 StackInterfaces here are required
                StackInterface<Integer> firstStack = new LinkedStack<Integer>();
                StackInterface<Integer> secondStack = new LinkedStack<Integer>();
                StackInterface<Integer> resultStack = new LinkedStack<Integer>();

                // initializes the stack lengths
                int firstStackLength = 0; 
                int secondStackLength = 0;
                int resultStackLength = 0;
                
                // iterates through first String
                // converts each char and pushes into associated Stack
                for (int i = 0; i < first.length(); i++) {
                    Integer x = (Integer) (first.charAt (i) - '0');
                    firstStack.push(x);
                    firstStackLength++;
                }
        
                // iterates through second String
                // converts each char and pushes into associated Stack
                for (int i = 0; i < second.length(); i++) {
                    Integer x = (Integer) (second.charAt (i) - '0');
                    secondStack.push(x);
                    secondStackLength++;    
                }
                
                // initializes carry and output variables
                int carry = 0;
                int output = 0;
        
                // while there is content in either stack, run loop until stacks are empty
                while(firstStackLength > 0 || secondStackLength > 0){

                    // initializes adder variable, resets every iteration
                    int adder = 0;
                    
                    // if there are values in first stack
                    // top of stack is popped and added to adder
                    // decrement first StackLength
                    if(firstStackLength>0){
                        int temp = firstStack.pop();
                        adder += temp;
                        firstStackLength--;
                    }
                    
                    // if there are values in second stack
                    // top of stack is popped and added to adder
                    // decrement second StackLength
                    if(secondStackLength>0){
                        int temp = secondStack.pop();
                        adder += temp;
                        secondStackLength--;
                    }
                    
                    // saves (carry + adder)
                    output = carry + adder;
                    
                    // carry is floored 
                    carry = (Integer) (output/10);
                    
                    // pushes to resultStack
                    // increments resultStackLength
                    resultStack.push(output%10);
                    resultStackLength++;
        
                }

                // handles any extra carry and pushes to resultStack
                // increments resultStackLength
                if(carry != 0) {
                    resultStack.push(carry);
                    resultStackLength++;
                };
                
                // adds the top of resultStack until empty, to a String
                String resultString = "";
                for (int i = 0; i < resultStackLength; i++) {
                    int x = resultStack.pop();
                    resultString += String.valueOf(x);
                }
                
                // // prints case 1 result
                System.out.println("99999 + 999 = " + resultString);
                
                // // prints case 2 result
                // System.out.println("89 + 9876 = " + resultString);

                // prints case 3 result
                // System.out.println("2147483647 + 2147483647 = " + resultString);
}
            }
        