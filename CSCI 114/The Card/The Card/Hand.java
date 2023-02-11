import java.util.ArrayList;
/**
 * Placeholder for a player's playing hand
 * 
 * 
 *
 * @Anthony Segarra
 */
public class Hand
{
    // instance variables
    ArrayList<Card> cards = new ArrayList<>();  
    
    /**
     * appends newCard input to AL 
     */
    public void addCard(Card newCard) {
        cards.add(newCard);
    }
    
    /**
     * @return AL
     */
    public String toString() {
        return cards.toString();
    }
    
}
