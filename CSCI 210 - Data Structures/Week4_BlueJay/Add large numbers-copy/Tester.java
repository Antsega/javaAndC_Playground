
public class Tester {
    public static void main(String args[]) {

                //first test
                // String first = "99999";
                // String second = "999";
        
                //second test
                String first = "89";
                String second = "9876";
        
                //third test
                //String first = "2147483647";
                //String second = "2147483647";
        
                //the 3 StackInterfaces here are required
                StackInterface<Integer> firstStack = new LinkedStack<Integer>();
                StackInterface<Integer> secondStack = new LinkedStack<Integer>();
                StackInterface<Integer> resultStack = new LinkedStack<Integer>();
        
                //you must write all of your code here...

                // iterates through string
                // converts each char to an int and pushes left to right into stack
                int firstStackLength = 0;
                for (int i = 0; i < first.length(); i++) {
                    Integer x = (Integer) (first.charAt (i) - '0');
                    firstStack.push(x);
                    firstStackLength++;
                }
                // iterates through string
                // converts each char to an int and pushes left to right into stack
                int secondStackLength = 0;
                for (int i = 0; i < second.length(); i++) {
                    Integer x = (Integer) (second.charAt (i) - '0');
                    secondStack.push(x);
                    secondStackLength++;    
                }

int tenths = 0;
int resultStackLength = 0;

// Start of Cases
// Case 1
// // if first string is longer
//                 if (firstStackLength > secondStackLength) {
//                     // iterating through firstStack
//                     for (int i = 0; i < firstStackLength; i++) {
//                             // grabbing the top of first stack
//                         int firstStackNumber = firstStack.pop();
                        
//                             // checking if secondStack is empty
//                         if (secondStack.isEmpty()) {
//                             // 0 is placeholder for nothing
//                         int secondStackNumber = 0;
//                             // combining results and adding tenth value
//                         int results = (firstStackNumber + secondStackNumber) + tenths;

//                         if (results > 9) {
//                             // pushing remainder of results / 10
//                             resultStack.push(results % 10);
//                             tenths = 1;
//                             resultStackLength++;
//                         }

//                         // else push 0
//                         // if results >= 10 reassign tenths = 1
//                         // otherwise tenths = 0
//                         else {      
//                                 resultStack.push((results % 10) / 10);
//                                 if (results >= 10) tenths = 1;
//                                 else tenths = 0; 
//                                 resultStackLength++;
//                         }
//                         // loop finished but leftover tenth value
//                         }


//                         else {
//                             int secondStackNumber = secondStack.pop();
//                             int results = (firstStackNumber + secondStackNumber) + tenths;
//                             if (results > 9) {
//                                 resultStack.push(results % 10);
//                                 tenths = 1;
//                                 resultStackLength++;
//                             }
//                         }                        
//                     }
//                 }

//                 resultStack.push(tenths);
//                 resultStackLength++;
//                 String resultsString = "";
//                 for (int i = 0; i < resultStackLength; i++) {
//                 int x = resultStack.pop();
//                     resultsString += String.valueOf(x);
//                 }
                
//                 // 1st Test Case
//                 System.out.println("99999 + 999 = " + resultsString);

// Case 2
// if second stack string is longer
if (secondStackLength > firstStackLength) {
    int caseTwoTenths = 0;

    // fills smaller stack with 0's as placeholders unitl same length
    do {
        firstStack.push(0);
        firstStackLength++;
    }
    while (firstStackLength < secondStackLength);

    // iterate through secondStack
    for (int i = 0; i < secondStackLength; i++) {
    int topOfFirstStack = firstStack.pop();
    int topOfSecondStack = secondStack.pop();
    int results = (topOfSecondStack + topOfFirstStack + caseTwoTenths);

    while (!secondStack.isEmpty()) {
        resultStack.push(results);
        // if the beginning or end of loop, tenth is 0; else 1
        if (i == 0 || i == secondStackLength ) caseTwoTenths = 0;
        else caseTwoTenths = 1;
        resultStackLength++;
    }
    }

    resultStack.push(caseTwoTenths);
    resultStackLength++;
    String resultsString = "";
    for (int i = 0; i < resultStackLength; i++) {
    int x = resultStack.pop();
        resultsString += String.valueOf(x);
    }
    
    // 1st Test Case
    System.out.println("Test");
    System.out.println("99999 + 999 = " + resultsString);
}
                // end of main }
            }
        }