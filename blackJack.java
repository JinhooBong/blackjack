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
  public static List<Integer> playersHand = new ArrayList<Integer>();
  public static List<Integer> dealersHand = new ArrayList<Integer>();

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

  /*
    A method to simulate the dealing of cards
  */
  public static int dealCard()
  {
    Random rn = new Random();
    int num = rn.nextInt(10)+1;
    return num;
  }

  /*
    A method to set up the initial state of the game.
  */
  public static void initiate()
  {
    int userCard1 = dealCard();
    int userCard2 = dealCard();

    playersHand.add(userCard1);
    playersHand.add(userCard2);

    int dealerCard1 = dealCard();
    int dealerCard2 = dealCard();

    dealersHand.add(dealerCard1);
    dealersHand.add(dealerCard2);
  }

  public static void main(String args[])
  {
    // Initialize the deck first
    initializeDeck();
    System.out.println("Please enter your first name: ");
    Scanner input = new Scanner(System.in);
    String name = input.next();
    System.out.println("Welcome " + name + "!");
    System.out.println("Are you ready to play black jack? (yes/no)");
    String answer = input.next();
    if(answer.equals("yes") || answer.equals("Yes"))
    {
      // Play blackjack
      System.out.println("I will be your dealer today.");
      // Set up the cards to be dealt
      initiate();
      // Deals out two cards at random to user (face up)
      System.out.println("Here are your cards: " + "[" + playersHand.get(0) + "]" + " " + "[" + playersHand.get(1) + "]");
      System.out.println("Here is upfacing dealers card: " + "[" + dealersHand.get(0) + "]" + " " + "[ ]");
      int playerSum = playersHand.get(0) + playersHand.get(1);
      int dealerSum = dealersHand.get(0) + dealersHand.get(1);
      String response = null;
      while(playerSum <= 21)
      {
        System.out.println("Would you like to hit or stay?");
        response = input.next();
        if(response.equals("hit") || response.equals("Hit"))
        {
          int newCardNum = dealCard();
          playersHand.add(newCardNum);
          int i = 0;
          while(i < playersHand.size())
          {
            System.out.print("[" + playersHand.get(i) + "]");
            i++;
          }
          System.out.println("");
          playerSum+=newCardNum;
          if(playerSum == 21)
          {
            System.out.println("Congratulations! You got Black Jack!");
            System.exit(0);
          }
        }
        else if(response.equals("stay") || response.equals("Stay"))
        {
          System.out.println("I will reveal my cards.");
          // Reveal the face down dealers card
          System.out.println("[" + dealersHand.get(0) + "]" + " " + "[" + dealersHand.get(1) + "]");

          if(dealerSum < playerSum)
          {
            System.out.println("Congratulations! You beat the system.");
            System.exit(0);
          }
          else
          {
            System.out.println("Looks like you lost! Please try again.");
            System.exit(0);
          }
        }
      }
      System.out.println("Looks like you lost! Please try again.");
      System.exit(0);

      // Deals out two cards to system (one face up, one face down)
    }
    else
    {
      System.out.println("Sorry to see you go. Please come again!");
    }
  }
}
