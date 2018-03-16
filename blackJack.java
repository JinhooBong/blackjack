import java.util.*;
import java.io.*;

/*
  A simulation of the card game black jack.
  User will get two random cards of certain value, and will be asked to be
  "hit" or "stay". Depending on how close they get to 21 will decide who wins.
*/
public class blackJack
{
  // Declaring an instance of a HashMap
  public static Map<String, List<Integer>> deck = new HashMap<String, List<Integer>>();

  public static void initializeDeck()
  {
    //!!! There must be a better way to store values. This takes too much space.

    // initializing lists of integers
    List<Integer> valOne = new ArrayList<Integer>();
    valOne.add(1);
    List<Integer> valTwo = new ArrayList<Integer>();
    valTwo.add(2);
    List<Integer> valThree = new ArrayList<Integer>();
    valThree.add(3);
    List<Integer> valFour = new ArrayList<Integer>();
    valFour.add(4);
    List<Integer> valFive = new ArrayList<Integer>();
    valFive.add(5);
    List<Integer> valSix = new ArrayList<Integer>();
    valSix.add(6);
    List<Integer> valSeven = new ArrayList<Integer>();
    valSeven.add(7);
    List<Integer> valEight = new ArrayList<Integer>();
    valEight.add(8);
    List<Integer> valNine = new ArrayList<Integer>();
    valNine.add(9);
    List<Integer> valTen = new ArrayList<Integer>();
    valTen.add(10);
    List<Integer> valJack = new ArrayList<Integer>();
    valJack.add(10);
    List<Integer> valQueen = new ArrayList<Integer>();
    valQueen.add(10);
    List<Integer> valKing = new ArrayList<Integer>();
    valKing.add(10);
    List<Integer> valAce = new ArrayList<Integer>();
    valAce.add(1);
    valAce.add(11);

    // Now adding elements to the deck.
    deck.put("1", valOne);
    deck.put("2", valTwo);
    deck.put("3", valThree);
    deck.put("4", valFour);
    deck.put("5", valFive);
    deck.put("6", valSix);
    deck.put("7", valSeven);
    deck.put("8", valEight);
    deck.put("9", valNine);
    deck.put("10", valTen);
    deck.put("Jack", valJack);
    deck.put("Queen", valQueen);
    deck.put("King", valKing);
    deck.put("Ace", valAce);
  }

  public static void main(String args[])
  {
    // Initialize the deck first
    initializeDeck();
    System.out.println("Please enter your name: ");
    Scanner input = new Scanner(System.in);
    String name = input.next();
    System.out.println("Welcome " + name + "!");
    System.out.println("Are you ready to play black jack? (yes/no)");

    String answer = input.next();
    if(answer.equals("yes") || answer.equals("Yes"))
    {
      // Play blackjack
      System.out.println("I will be your dealer today.");
      // Deals out two cards at random to user (face up)
      System.out.println("Here are your cards:");


      // Deals out two cards to system (one face up, one face down)
    }
    else
    {
      System.out.println("Sorry to see you go. Please come again!");
    }
  }
}
