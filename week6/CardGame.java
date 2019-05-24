// David W. Clendenning Jr. - CardGame - Week 6
package week6;
import java.util.Collections;
import java.util.Stack;
import java.util.Scanner;

/**
 * @author Delaware Technical Community College
 * Wilmington Campus
 * 
 * TODO:
 * Write a simple card game with the following rules:
 * * Each player has 26 cards
 * * In each round, each player can take a look at the top card and decide to play that card
 * * * OR put that card at the bottom of their pile and play the second card instead.
 * * * The player may NOT look at the second card before making the decision
 * 
 * Notes:
 * * Notice the various methods of the java.util.Stack class that we did not previous have in our custom class such as size and get.
 * * Another useful method you might use for this assignment is the add method, which takes an integer argument
 * * * specifying the location/index where you want to add an item
 */
public class CardGame {
	// This time, we will use the java.util.Stack class instead of our custom class.
		static Stack<Integer> cardsDeck = new Stack<>();
		
		// p1 is "player"
		// p2 is "computer"
		static Stack<Integer> p1cards = new Stack<>();
		static Stack<Integer> p2cards = new Stack<>();
		static Stack<Integer> p1cardsWon = new Stack<>();
		static Stack<Integer> p2cardsWon = new Stack<>();
		
		public static void main(String[] args) {
			/* created for user input */
			Scanner input = new Scanner(System.in);
			// Debugging/test code commented out
			
			initializeCards();
			
			shuffleCards();
			
			System.out.println("All cards.");
			System.out.println(cardsDeck + "\n");
			
			dealCards();
			
			/* System.out.println("P1 cards.");
			 displayDeck(p1cards);
			 System.out.println(p1cards);
			 System.out.println(p1cards.peek());
			 System.out.println(p1cards.size());
			 p1cards.insertElementAt(p1cards.pop(), 0);
			 System.out.println(p1cards);
			 System.out.println(p1cards.peek());
			 System.out.println(p1cards.size());
			 System.out.println("P2 cards.");
			 displayDeck(p2cards); 
			 */

			
			/* 
			 * Loop that consists of nested if statements that allows game logic depending on their decision of playing a card
			 */
			for(int i = 0; i < 26; i++) {
				System.out.println("ROUND: " + (i + 1));
				System.out.println("P1 card: " + p1cards.peek() + "\t" + "P2 card: " + p2cards.peek());
				System.out.println("Would you like to play the first card? 1 for yes, 0 for no");
				int decision = input.nextInt();
				if(decision == 1) {
					if(p1cards.peek() > p2cards.peek()) {
						System.out.println("\nCards played this round: \n" + "P1 card: " + p1cards.peek()
						    + "\tP2 card: " + p2cards.peek() + "\nP1 wins this round!\n");
						p1cardsWon.push(p1cards.pop());
						p1cardsWon.push(p2cards.pop());
					}
					else {
						System.out.println("\nCards played this round: \n" + "P1 card: " + p1cards.peek()
					    + "\tP2 card: " + p2cards.peek() + "\nP2 wins this round!\n");
						p2cardsWon.push(p1cards.pop());
						p2cardsWon.push(p2cards.pop());
					}
				}
				else {
					/* 
					 * This method is originally from the vector class I believe and I used it in order to manipulate
					 * the card stack to pop the card to bottom of the stack
					 */
					p1cards.insertElementAt(p1cards.pop(), 0);
					if(p1cards.peek() > p2cards.peek()) {
						System.out.println("\nCards played this round: \n" + "P1 card: " + p1cards.peek()
					    + "\tP2 card: " + p2cards.peek() + "\nP1 wins this round!\n");
						p1cardsWon.push(p1cards.pop());
						p1cardsWon.push(p2cards.pop());
					}
					else {
						System.out.println("\nCards played this round: \n" + "P1 card: " + p1cards.peek()
					    + "\tP2 card: " + p2cards.peek() + "\nP2 wins this round!\n");
						p2cardsWon.push(p1cards.pop());
						p2cardsWon.push(p2cards.pop());
					}
				}
			}
			/*
			 * Logic that displays the winner
			 */
			if(p1cardsWon.size() > p2cardsWon.size()) {
				System.out.println("\nP1 has won with a score of: " + p1cardsWon.size());
			}
			
			else if(p1cardsWon.size() < p2cardsWon.size()) {
				System.out.println("\nP2 has won with a score of: " + p2cardsWon.size());
			}
			else {
				System.out.println("\nThere is a tie");
			}
			
		}
		
		static void initializeCards() {
			// Initialize deck of cards with integers
			for (int i= 0; i<52; i++) {
				cardsDeck.push(i);
			}
		}
		
		static void shuffleCards() {
			// Shuffle the Stack
			Collections.shuffle(cardsDeck);
		}
		
		static void displayDeck(Stack<Integer> deck) {
			// Simple method to display all items in deck of cards
			for (int i = 0; i < deck.size(); i++) {
				System.out.print(deck.get(i) + ", ");
				if (i%5 == 0 && i!=0) {
					System.out.print("\n");
				}
			}
		}
		
		static void dealCards() {
			// Deal cards to each player
			for (int i= 0; i<52; i++) {
				if (i%2 == 0) {
					p1cards.push(cardsDeck.pop());
				} else {
					p2cards.push(cardsDeck.pop());	
				}
			}
		}
}
