public class Adder
{
    private double balance;
   

    public Adder()
    {
       balance = 0.0;
    }

 

    public void addIt(double amount)

    {

       balance = balance + amount;

    }

 

    public double getBalance()

    {

       return balance;

    }

}