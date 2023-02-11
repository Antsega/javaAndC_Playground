/**
 * Tests the card game classes.
 *
 * @author Anthony Segarra
 * @version 10 Nov 22' V.2.0
 */
public class Tester {
        /**
         * main() method
         */
        public static void main(String[] args) {
                // No pair
                System.out.println("No pair");
                Hand noPair1 = new Hand(new Card(10, 3), new Card(3, 0), new Card(13, 2), new Card(5, 1),
                                new Card(14, 3));
                System.out.print(noPair1.toString());
                System.out.print(noPair1.toCategory());
                System.out.println("\n");

                // One pair
                System.out.println("One pair");
                Hand onePair1 = new Hand(new Card(12, 2), new Card(14, 3), new Card(10, 2), new Card(14, 0),
                                new Card(11, 1));
                System.out.print(onePair1.toString());
                System.out.print(onePair1.toCategory());
                System.out.println("\n");

                // Two pair
                System.out.println("Two pair");
                Hand twoPair1 = new Hand(new Card(12, 0), new Card(3, 0), new Card(14, 3), new Card(14, 1),
                                new Card(3, 2));
                System.out.print(twoPair1.toString());
                System.out.print(twoPair1.toCategory());
                System.out.println("\n");

                // Three of a kind
                System.out.println("Three of a kind");
                Hand threeOfAKind1 = new Hand(new Card(14, 3), new Card(14, 0), new Card(6, 2), new Card(2, 2),
                                new Card(14, 1));
                System.out.print(threeOfAKind1.toString());
                System.out.print(threeOfAKind1.toCategory());
                System.out.println("\n");

                // Straight
                System.out.println("Straight");
                Hand straight1 = new Hand(new Card(13, 3), new Card(10, 1), new Card(14, 1), new Card(12, 0),
                                new Card(11, 2));
                System.out.print(straight1.toString());
                System.out.print(straight1.toCategory());
                System.out.println();
                // aces low
                System.out.println("Extra credit - aces low");
                Hand straight2 = new Hand(new Card(4, 3), new Card(3, 1), new Card(5, 1), new Card(2, 0),
                                new Card(14, 2));
                System.out.print(straight2.toString());
                System.out.print(straight2.toCategory());
                System.out.println("\n");

                // Flush
                System.out.println("Flush");
                Hand flush1 = new Hand(new Card(8, 2), new Card(3, 2), new Card(11, 2), new Card(5, 2),
                                new Card(14, 2));
                System.out.print(flush1.toString());
                System.out.print(flush1.toCategory());
                System.out.println("\n");

                // Full house
                System.out.println("Full house");
                Hand fullHouse1 = new Hand(new Card(14, 3), new Card(9, 0), new Card(14, 0), new Card(14, 1),
                                new Card(9, 3));
                System.out.print(fullHouse1.toString());
                System.out.print(fullHouse1.toCategory());
                System.out.println("\n");

                // Four of a kind
                System.out.println("Four of a kind");
                Hand fourOfAKind1 = new Hand(new Card(14, 3), new Card(9, 3), new Card(14, 1), new Card(14, 2),
                                new Card(14, 0));
                System.out.print(fourOfAKind1.toString());
                System.out.print(fourOfAKind1.toCategory());
                System.out.println("\n");

                // Straight flush
                System.out.println("Straight flush");
                // (an aces high straight flush is a royal flush)
                Hand straightFlush1 = new Hand(new Card(5, 1), new Card(2, 1), new Card(4, 1), new Card(6, 1),
                                new Card(3, 1));
                System.out.print(straightFlush1.toString());
                System.out.print(straightFlush1.toCategory());
                System.out.println();
                // aces low
                System.out.println("Extra credit - aces low");
                Hand straightFlush2 = new Hand(new Card(4, 3), new Card(3, 3), new Card(14, 3), new Card(5, 3),
                                new Card(2, 3));
                System.out.print(straightFlush2.toString());
                System.out.print(straightFlush2.toCategory());
                System.out.println("\n");

                // Royal flush
                System.out.println("Royal flush");
                Hand royalFlush1 = new Hand(new Card(13, 0), new Card(10, 0), new Card(14, 0), new Card(11, 0),
                                new Card(12, 0));
                System.out.print(royalFlush1.toString());
                System.out.print(royalFlush1.toCategory());
                System.out.println("\n");

                // Invalid hand
                System.out.println("Invalid hand");
                Hand invalidHand1 = new Hand(new Card(13, 0), new Card(7, 2), new Card(2, 3), new Card(10, 1),
                                new Card(13, 0));
                System.out.print(invalidHand1.toString());
                System.out.println("\n");
        }
}