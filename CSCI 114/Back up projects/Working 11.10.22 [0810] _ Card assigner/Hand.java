import java.util.ArrayList;

/**
 * Placeholder for a player's playing hand
 * 
 * 
 *
 * @Anthony Segarra
 */
public class Hand {
    // instance variables
    // ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<Card>();

    public ArrayList<Card> getHand() {
        return cards;
    }

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
     * @return AL
     */
    public String toString() {
        if (isValid()) {
            return cards.toString();
        }
        return "Invalid Hand";
    }

    public Hand(Card first, Card second, Card third, Card fourth, Card fifth) {
        this.cards.add(first);
        this.cards.add(second);
        this.cards.add(third);
        this.cards.add(fourth);
        this.cards.add(fifth);
    }

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
                category = "Flush";
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
                category = "No pair";

            return category;
        }
        return "Invalid Hand";
    }

    public boolean onePair() {
        CountRank cr = new CountRank(this);
        return cr.onePair();
    }

    public boolean twoPair() {
        CountRank cr = new CountRank(this);
        return cr.twoPair();
    }

    public boolean threeOfAKind() {
        CountRank cr = new CountRank(this);
        return cr.threeOfAKind();
    }

    public boolean fullHouse() {
        CountRank cr = new CountRank(this);
        return cr.fullHouse();
    }

    public boolean fourOfAKind() {
        CountRank cr = new CountRank(this);
        return cr.fourOfAKind();
    }

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

    public boolean straightFlush() {
        CountRank cr = new CountRank(this);
        if (flush() && straight()) {
            return true;
        }
        return false;
    }

    public boolean royalFlush() {
        CountRank cr = new CountRank(this);
        if (cr.straight(10, 14) && flush()) {
            return true;
        }
        return false;
    }

}
