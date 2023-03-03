public class Tester2 {
    public static void main(String args[]) {


        String first = "89234234234332222344422";
        String second = "1233242342342342";

        StackInterface<Integer> stack1 = new LinkedStack<Integer>();
        StackInterface<Integer> stack2 = new LinkedStack<Integer>();
        StackInterface<Integer> resultStack = new LinkedStack<Integer>();
        
        int firstStackLength = 0; //first.length
        int secondStackLength = 0;
        int resultStackLength = 0;
        
        for (int i = 0; i < first.length(); i++) {
            Integer x = (Integer) (first.charAt (i) - '0');
            stack1.push(x);
            firstStackLength++;
        }

        // iterates through string
        // converts each char to an int and pushes left to right into stack

        for (int i = 0; i < second.length(); i++) {
            Integer x = (Integer) (second.charAt (i) - '0');
            stack2.push(x);
            secondStackLength++;    
        }

        int carry = 0;
        int output = 0;

        while(firstStackLength > 0 || secondStackLength > 0){
            int adder = 0;

            if(firstStackLength>0){
                int temp = stack1.pop();
                adder += temp;
                //adder += stack1.pop();
                System.out.println("firststack "+ temp);
                firstStackLength--;
            }

            if(secondStackLength>0){
                int temp = stack2.pop();
                adder += temp;
                //adder += stack2.pop();
                System.out.println("secondstack " + temp);
                secondStackLength--;
            }
            System.out.println("adder " + adder);

            output = carry + (adder);
            
            System.out.println("output " + output);

            carry = (Integer) (output/10);

            System.out.println("carry " + carry);

            System.out.println("result pushed " + output%10);
            resultStack.push(output%10);
            resultStackLength++;
            System.out.println();
            System.out.println();

        }
        if(carry != 0) resultStack.push(carry);
        
        String resultString = "";
        for (int i = 0; i < resultStackLength; i++) {
            int x = resultStack.pop();
            resultString += String.valueOf(x);
        }
        
        System.out.println("Answer 4294967294");
        System.out.println("String " + resultString);
}
}