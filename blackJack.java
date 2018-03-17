import java.util.*;
import java.io.*;

/*
  A very simple simulation of the card game black jack.
  User will get two random cards of certain value, and will be asked to be
  "hit" or "stay". Depending on how close they get to 21 will decide who wins.
*/
public class blackJack
{
  public static List<Integer> playersHand = new ArrayList<Integer>();
  public static List<Integer> dealersHand = new ArrayList<Integer>();

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
      System.exit(0);
    }
  }
}
