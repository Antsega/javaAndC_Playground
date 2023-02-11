import java.util.ArrayList;

/**
 * Player's hand of cards
 * Ability to call entire hand
 * Ability to categorize hand based on card values
 * 
 * @Anthony Segarra
 * @version 10 Nov 22' V.3.0
 */
public class Hand {
    // instance variables

    // creates new ArrayList using the card class , calling it cards
    private ArrayList<Card> cards = new ArrayList<Card>();

    /*
     * targetting an ArrayList in Card
     * 
     * @return cards ArrayList previously created
     */
    public ArrayList<Card> getHand() {
        return cards;
    }

    /*
     * targetting Card class
     * makes accessible
     * 
     * @return cards.[index];
     */
    public Card getCard(int i) {
        return cards.get(i);
    }

    /**
     * appends newCard input to AL
     */
    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    /**
     * Tests if a hand is isValid
     * 
     * @return cards
     *         else
     * @return "Invalid Hand, contains duplicates"
     */
    public String toString() {
        if (isValid()) {
            return cards.toString();
        }
        return cards.toString() + " Invalid Hand, Contains Duplicates";
    }

    /*
     * if no card duplicates
     * appends each parameter to cards
     * 
     * if duplicate(s) occur, print error
     */
    public Hand(Card first, Card second, Card third, Card fourth, Card fifth) {

        if (isValid()) {
            this.cards.add(first);
            this.cards.add(second);
            this.cards.add(third);
            this.cards.add(fourth);
            this.cards.add(fifth);
        } else {
            System.err.println(("In Hand::Hand() -- duplicate card"));
            System.out.println(("In Hand::Hand() -- duplicate card"));
            System.exit(1);
        }
    }

    /*
     * Checks if two cards are the same rank and suit
     * 
     * loop i: 0 through cards.size, increment by one
     * loop j: 1 through cards.size, increment by one
     * if cards[i] and cards[j] have the same suit and rank
     * then two cards are identical
     * 
     * @return false
     * 
     * else
     * 
     * @return true
     */
    public boolean isValid() {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if ((cards.get(i).getRank() == cards.get(j).getRank())
                        && (cards.get(i).getSuit() == cards.get(j).getSuit())) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Creates a string; cateogory
     * if (isValid is true)
     * then, check if (category method is true)
     * 
     * @return if true then replace string with new category value
     * else
     * 
     * @return Invalid Hand
     */
    public String toCategory() {
        String category = ""; // the default value, for no pair
        if (isValid()) {
            if (royalFlush())
                category = " Royal flush";
            else if (fullHouse())
                category = " Full House";
            else if (straightFlush())
                category = " Straight flush";
            else if (flush())
                category = " Flush";
            else if (straight())
                category = " Straight";
            else if (fourOfAKind())
                category = " Four of a kind";
            else if (threeOfAKind())
                category = " Three of a kind";
            else if (twoPair())
                category = " Two pair";
            else if (onePair())
                category = " One pair";
            else
                category = " No pair";

            return category;
        }
        return "Invalid Hand";
    }

    // Methods below give access from CountRank in the Hand class {start}
    /*
     * Creates new object using CountRank class
     * 
     * @return onePair()'s return statement
     */
    public boolean onePair() {
        CountRank cr = new CountRank(this);
        return cr.onePair();
    }

    /*
     * Creates new object using CountRank class
     * 
     * @return twoPair()'s return statement
     */

    public boolean twoPair() {
        CountRank cr = new CountRank(this);
        return cr.twoPair();
    }

    /*
     * Creates new object using CountRank class
     * 
     * @return threeOfAKind()'s return statement
     */
    public boolean threeOfAKind() {
        CountRank cr = new CountRank(this);
        return cr.threeOfAKind();
    }

    /*
     * Creates new object using CountRank class
     * 
     * @return if threeOfAKind is true for cr
     */
    public boolean fullHouse() {
        CountRank cr = new CountRank(this);
        return cr.fullHouse();
    }

    /*
     * Creates new object using CountRank class
     * 
     * @return if fourOfAKind is true for cr
     */
    public boolean fourOfAKind() {
        CountRank cr = new CountRank(this);
        return cr.fourOfAKind();
    }

    /*
     * 
     * Set a min and max
     * Creates new object using CountRank class
     * loop through cards in this class and save each value as i
     * reassigns min if individual card's rank is less than min
     * reassigns max if individual card's rank is less than min
     * 
     * if checks if straight low Ace
     * 
     * @return return from straight()
     * 
     * else
     * 
     * @return return from straight()
     * 
     */
    public boolean straight() {
        int min = 16;
        int max = -1;
        CountRank cr = new CountRank(this);
        for (Card i : this.cards) {
            if (i.getRank() < min) {
                min = i.getRank();
            }
        }
        for (Card i : this.cards) {
            if (i.getRank() > max) {
                max = i.getRank();
            }
        }
        if (min == 2 && max == 14) {
            return cr.straight(1, 4);
        }
        return cr.straight(min, max);

    }

    /*
     * loops through cards and saves i as a card
     * assign suit to card's suit
     * if the next card's suit is not the same
     * 
     * @return false
     * else
     * 
     * @return true
     * 
     */
    public boolean flush() {
        int suit = -1;
        for (Card i : this.cards) {
            if (suit == -1) {
                suit = i.getSuit();
            } else if (i.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    /*
     * Evaluates straightFlush
     * creates new CountRank object
     * if flush & straight
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean straightFlush() {
        CountRank cr = new CountRank(this);
        if (flush() && straight()) {
            return true;
        }
        return false;
    }

    /*
     * creates a new CountRank class called cr
     * if (top straight) && flush() true
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean royalFlush() {
        CountRank cr = new CountRank(this);
        if (cr.straight(10, 14) && flush()) {
            return true;
        }
        return false;
    }
    // Methods above give access from CountRank in the Hand class {end}
}
