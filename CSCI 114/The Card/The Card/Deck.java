import java.util.ArrayList;
import java.util.Random;
/**
 * Representing the creation a full deck
 * Contains methods to mainipulate the deck
 *
 * @Anthony Segarra
 */
public class Deck
{
    // constants
    public static final int TOTAL_CARDS = 52;
    public static final int CARDS_PER_SUIT = 13;
    // instance variables
    private ArrayList<Card> cards;          // creates AL named cards

    /**
     * Constructor for objects of class Deck
     * 52 card deck in numerical and suited order
     * Suit order --> Clubs, Diamonds, Hearts, and Spades
     */
    public Deck()
    {
        // create new, empty ArrayList
        cards = new ArrayList<>();
        
        // creates a deck of cards 
        // suit range 0 - 3
        // cards 2 - 14 
        // appends to cards
        for (int suitNum = 0; suitNum < 4; suitNum++) {
            for (int cardNum = 2; cardNum < 15; cardNum++) {
            cards.add(new Card(cardNum, suitNum));
            }
        }
    }
    
     /**
      *  Shuffles the deck in a random order.
      */ 
    public void shuffle(){
    
        Random r = new Random();
        // uses a temp array list
        ArrayList<Card> temp = new ArrayList<>();
        
        // removes each point randomly and add to another AL
        while (cards.size() > 0)
            temp.add(cards.remove(r.nextInt(cards.size())));
        
        // simply set points to temp
        cards = temp;
    }
    
    /**
      *  Removes the card at the top of the deck
      *  
      *  @return the card from the top of the deck
      */ 
    public Card dealCard() {
        // exit the program if the deck is empty
        // isEmpty() from ArrayList library
        if (cards.isEmpty()) {
            // sends error message to System.err
            System.err.println
                ("In Deck::dealCard() -- deck is empty");
            // also sends to standard output, to see it there too
            System.out.println
                ("In Deck::dealCard() -- deck is empty");
            System.exit(1);     // non-0 means error
        }
        // assumes index 0 is the top card of the deck
        // removes this card from the deck, reducing it's size
        return cards.remove(0);
    }
    
    /**
      *  Creates a row of 14 cards
      *  If row > 14 cards, creates new line
      *  @return println
      */ 
    public String toString() {
        StringBuilder out = new StringBuilder();
        
        int count = 0; // number of cards printed 
        // only traverse what cards are left in the deck
        for (Card card : cards) {                       // creates "card" elements in cards AL
            out.append(card.toString());                // appends card
            out.append(" ");                            // space char
            ++count;                                    // inc
            // lines of C_P_L / 13 cards
            if (count % CARDS_PER_SUIT == 0)
                out.append('\n');
        }
        
        return out.toString();
    }
}

