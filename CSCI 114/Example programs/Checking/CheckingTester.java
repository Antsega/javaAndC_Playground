
/**
 * Tests the Checking class.
 * 
 * @author Anthony W. Smith
 * @version 5/31/2028
 */
public class CheckingTester
{
    /**
     * main() method
     */
    public static void main(String[] args)
    {
        Checking business, personal;
        
        business = new Checking();
        personal = new Checking();
        
        System.out.println("Balance of new business account is $" + business.balance());
        
        business.deposit(100.0);
        System.out.println("Balance of business account is $" + business.balance());
        
        personal.withdraw(50.0);
        System.out.println("Balance of personal account is $" + personal.balance());
    }
}
