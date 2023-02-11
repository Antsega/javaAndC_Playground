
/**
 * Our Stock function, takes a stock by it's symbol and current price.
 * Has the ability to return; the Symbol, current price, and reflect a new price when altered by a percentage
 * @Anthony Segarra
 * @10 Sept 2022
 */
public class Stock
{
    // instance variables [start]
    double currentStockPrice;             // global variable to call stock's price  
    double percentChange;                 // global variable to call stock's percetange change
    final double percentConvertor = 0.01; // constant to convert changePrice input to percentage value 
    String stockSymb;                     // global variable to call stock's symbol
    // instance variables [end]
    
    // Constructor Function [start]
    public Stock(String symb, double currentPrice)  // template for Stock objects, takes a ('string', 00.00)
    {
        stockSymb = symb;                 // initilizes symb input to global stockSymb variable
        currentStockPrice = currentPrice; // initilizes currentPrice to global currentCtockPrice variable
    }
    // Constructor Function [end]

    // method(s) [start]
    public String getSymbol(){                    // return's the stock's symbol passed in Stock function; variable symb
        return stockSymb;   
    };
    public double getPrice(){                     // return's the stock's currentPrice passed in Stock function; variable currentPrice
        return currentStockPrice; 
    };
     public double changePrice(double byPercent){ // return's the stock's new price after the passed percentage change
        percentChange = byPercent;                                                                              // initilizes parameter byPercent, to a global variable 
        currentStockPrice = (currentStockPrice + (currentStockPrice * (percentChange * percentConvertor)));     // re-initilizes currentStockPrice to the price, plus the price amount changed by percentage input 
        return currentStockPrice;                                                                               // returns new currentStockPrice after percentage change
    }; 
    // method(s) [end]
    
    // comments [start]
        // 1) instance variable recasting
                // The reason for initilizing instance variables to parameter's is so they remain global and can be called in methods outside of the constructor function.
        // 2) changePrice 
                // percentage input is passed as XX.00 value and needed to be multiplied by 0.01 to correctly reflect a percentage value.
                // once the parameter is correctly reflecting a percentage value, it is multiplied by currentStockPrice to get the percentage of the stock's price
                // the result is then added to the current stock's price to accurately reflect the change of cost
    // comments [end]
}
