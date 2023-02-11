/**
 * Write a description of class CountRank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CountRank {
    // instance variables
    private int rankCount[];

    /**
     * Creates an array of 15 spots; 0 - 14
     * loops through Hand object and assigns values to rankCount's index's; zero
     * through fourteen
     * Hand::getHand() -- > returns cards object from Hand class
     * .size() -- > get's the number of elements from an arrayList
     * Card::get(i) -- > pulls index[i] from array list cards
     * Card::getRank() -- > returns rank value from Card class
     * let x = hand.cards.[i].rank
     * rankCount[x] += 1 to assign rankCount's index values, increase by one but
     * starting at index 1 since card values are
     */
    public CountRank(Hand h) {
        rankCount = new int[15];
        for (int i = 0; i < h.getHand().size(); i++) {
            int x = h.getHand().get(i).getRank();
            rankCount[x] += 1;
            if (x == 14) {
                rankCount[1] += 9;
            }
        }
    }

    /*
     * loops through rankCount arr
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
     * loops from min to max args, as the ranges
     * if rankCount has a value of zero for a card between min and max args
     * 
     * @return false
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
}

/*
 * 
 * h.getCard(i).getRank()
 * The way this works is:
 * -h is a Hand, containing Card objects
 * -getCard() is a Hand method, takes a param, and returns this Card object from
 * the hand
 * -then getRank() is a Card method, returns the rank of the Card object
 */