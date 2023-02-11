public class NewAdder extends Adder

{

    private int count;

 

    public NewAdder()
    {
       count = 0;
    }
 

    public void addIt(double amount)

    {

        super.addIt(amount / 2.0);

        count = count + 1;

    }

}

 
