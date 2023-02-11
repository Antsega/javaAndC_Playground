
/**
 * Implements a bank checking account.
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class Checking
{
    private double balance;

    /**
     * Constructor for objects of class Checking
     */
    public Checking()
    {
        // set balance to 0.0 when a new Checking object is created
        balance = 0.0;
    }

    /**
     * Withdraws money from the account
     * 
     * @param   amount  amount of the withdrawal 
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     * Deposits money into the account
     * 
     * @param   amount  amount of the deposit 
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
       
    /**
     * Returns account balance
     * 
     * @return     current balance of the account 
     */
    public double balance()
    {
        return balance;
    }
}
