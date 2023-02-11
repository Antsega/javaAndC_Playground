
/**
 * Loops through a player's hand
 * Creates and assigns a new array to evaluate each card's value(s)
 * Player's hand is evaluated and categorized by a hierarchy
 * 
 * @return true if hand meets condition(s)
 *         else
 * @return false if condition(s) are not met
 *
 * @author Anthony Segarra
 * @version 10 Nov 2022 V.3.0
 */
public class CountRank {
    // instance variables
    private int rankCount[];

    /**
     * Creates an array of 15 spots; 0 - 14
     * loops through Hand object and assigns values to rankCount's index's; zero
     * through fourteen
     * 
     * Hand::getHand() -- > returns cards object from Hand class
     * .size() -- > get's the number of elements from an arrayList
     * Card::get(i) -- > pulls index[i] from array list cards
     * Card::getRank() -- > returns rank value from Card class
     * 
     * let x = hand.cards.[i].rank
     * rankCount[x] += 1 to assign rankCount's index values, increase by one
     * 
     * if (statement === true)
     * make rankCount[1] > 4 && rankCount[1] < 10
     * makes conditions true for straight, Aces low
     */
    public CountRank(Hand h) {
        rankCount = new int[15];
        for (int i = 0; i < h.getHand().size(); i++) {
            int x = h.getHand().get(i).getRank();
            rankCount[x] += 1;
            if (x == 14) {
                rankCount[1] += Math.floor(Math.random() * 10) + 5;
            }
        }
    }

    /*
     * loops through rankCount array
     * if rankCount has a value of 2
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean onePair() {
        for (int i = 0; i < 15; i++) {
            if (rankCount[i] == 2) {
                return true;
            }
        }
        return false;
    }

    /*
     * loops through rankCount array
     * each time rankCount's index has a value of two
     * add one to your count var
     * if rankCount has a value of two again, will add one to count again
     * if this has happened twice, we know twoPair to be true
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean twoPair() {
        int count = 0;
        for (int i = 0; i < 15; i++) {
            if (rankCount[i] == 2) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    /*
     * loops through rank count's values
     * if rankCount has a value of three
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean threeOfAKind() {
        for (int i = 0; i < 15; i++) {
            if (rankCount[i] == 3) {
                return true;
            }
        }
        return false;
    }

    /*
     * loops from min to max arguements, as the ranges; inclusive
     * if rankCount has a value of zero for a card between min and max args
     * 
     * @return false
     * else
     * 
     * @return true
     * 
     */
    public boolean straight(int min, int max) {
        for (int i = min; i <= max; i++) {
            if (rankCount[i] == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * if onePair() and threeOfAKind() == true
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean fullHouse() {
        if (onePair() && threeOfAKind()) {
            return true;
        }
        return false;
    }

    /*
     * loops through rankCount's values
     * if rankCount has a value of 4
     * 
     * @return true
     * else
     * 
     * @return false
     */
    public boolean fourOfAKind() {
        for (int i = 0; i < 15; i++) {
            if (rankCount[i] == 4) {
                return true;
            }
        }
        return false;
    }

    /*
     * creates new StringBuilder called out
     * starts the string as '{'
     * i looping through rankCount[i] values
     * if i is not the last index, append to out
     * if i is the last index, append and close string
     * 
     * @return out.toString();
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');

        for (int i = 0; i < rankCount.length; i++) {
            if (i == rankCount.length - 1) {
                out.append(rankCount[i]);
                out.append('}');

            } else {
                out.append(rankCount[i]);
                out.append(", ");
            }

        }
        return out.toString();
    }

}
