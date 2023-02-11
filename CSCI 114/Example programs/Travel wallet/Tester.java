/**
 * Tests TravelWallets.
 * 
 * @author Anthony W. Smith 
 * @version 5/31/2028
 */
public class Tester
{
    /**
     * main() method
     */
    public static void main(String[] args)
    {
        // Tom visits Bali.  Local currency is the Indonesian rupiah (Rp)
        TravelWallet tom = new TravelWallet(14836.40);      // 1 US$ buys 14836.40 Rp

        tom.spendLocal(2500.0);          // spend 2500.0 Rp
        tom.exchangeDollarsToLocal(75.0); // exchange $75.0 to rupiah
        
        // print the total amount of all of the money in the wallet, in US$
        System.out.println("Tom has US $" + tom.totalAmountInDollars());

        // Kay visits Hungary.  Local currency is the forint (Ft)
        TravelWallet kay = new TravelWallet(411.03);      // 1 US$ buys 411.03 Ft
        
        kay.spendLocal(7500.0);          // spend 7500.0 Ft
        kay.exchangeDollarsToLocal(25.0); // exchange $25.0 to forints
        
        // print the total amount of all of the money in the wallet, in US$
        System.out.println("Kay has US $" + kay.totalAmountInDollars());
    }
}
