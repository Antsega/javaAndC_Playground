
/**
 * Creates a travel wallet, converts local currency and calculates USD spent.
 * 
 * @Anthony Segarra
 * @17 Sept 2022
 */
public class TravelWallet
{
    // instance variables
    private double dollars = 100.00;         // wallet starting amount USD
    private double localCurrency = 10000.00; // wallet starting amount local currency
    private double exchangeRate = 0;         // default exchange rate
    
    // Constructor Start
    public TravelWallet(double exchangeRateInput)              // wallet template
    {
        exchangeRate = exchangeRateInput;                      // set's wallet amount to user input param
        localCurrency = dollars * exchangeRate;                // set's local wallet. Converts user input by exchange rate 
        
    }
    // Constructor End

    // Methods Start
    public double spendLocal(double localAmountSpent)   // subtracts input from local currency wallet
    {
        return localCurrency -= localAmountSpent;       // subtracts user input from localCurrency balance and returns value
    }
    
    public double exchangeDollarsToLocal(double dollarAmountToExchange){    // subtracts input from USD wallet and adds to local wallet
        dollars -= dollarAmountToExchange;                                  // takes amount to exchange away from USD wallet
        dollarAmountToExchange *= exchangeRate;                             // converts input to local currency
        return localCurrency += dollarAmountToExchange;                     // adds input to local wallet and returns value
        
    }
    
    public double totalAmountInDollars(){   // returns USD wallet's balance
        return dollars;                     
    }
    // Methods End
}

/* 
 Additional Comments
     1) instance variables are set to private so they cannot be altered elsewhere
 */
