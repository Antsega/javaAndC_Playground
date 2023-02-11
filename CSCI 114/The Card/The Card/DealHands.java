import java.util.ArrayList;     // array list library
import java.util.Scanner;       // user input
/**
 * Simulation for 5 player card game
 *
 * @Anthony Segarra
 */
public class DealHands
{ 
    /**
      * Uses a deck of 52 cards, and can only support up to 10 players
      * Asks user input for how many players 
      * Deals cards to each player
      * Prints each player's hand
      * Returns the remaining cards, if any
      * 
      * Will throw error if exceeding max players
    */
    public void main() {
        Deck Deck = new Deck();                                             // calls Deck class
        Scanner in = new Scanner(System.in);                                // calls scanner and creates new class
        
        System.out.println("A brand new, fresh deck,\n" + Deck.toString()); // print organized deck
        Deck.shuffle();                                                     // shuffle deck
        System.out.println("\nShuffled\n" + Deck.toString());               // print shuffled deck
        System.out.print("How many players? ");                             // prompt user input
        int playerCount = in.nextInt();                                     // saves user input
        
        ArrayList<Hand> hands = new ArrayList<>();                          // creates new ArrayList
        for (int counter = 0; counter < playerCount; counter++) {
            hands.add(new Hand());                                          // add Hand objects for number of players
        }
        
        // deal cards to each player one at a time till each player has five cards
        for (int index = 0; index < playerCount; index++) 
            for (int tick = 0; tick < 5; tick++) 
                hands.get(index).addCard(Deck.dealCard());
                
        // print each hand
        System.out.println("Print each hand\n");
        for (int index = 0; index < playerCount; index++)
            System.out.println(hands.get(index).toString());
        System.out.println();
        
        // print what remains in the Deck
        System.out.println("What remains");
        System.out.println(Deck.toString());
        
        // error testing
        // assumes purposefully throws playerCount out of range for error
        /**
            for (int index = 0; index < (playerCount * 100); index++) 
            for (int tick = 0; tick < 5; tick++) 
                hands.get(index).addCard(Deck.dealCard());
        **/
        }
    }
