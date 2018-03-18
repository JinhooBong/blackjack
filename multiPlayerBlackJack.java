import java.util.*;
import java.io.*;

/*
  A simulation of the card game black jack.
  User will get two random cards of certain value, and will be asked to be
  "hit" or "stay". Depending on how close they get to 21 will decide who wins.

  http://www.blackjack-direct.com/blackjack-rules.html
  - The rules of black jack that I created the game to cater towards.
  - Options I inlcuded: hit or stand.
  - Excluded surrender, double down, and split options.

*/
public class multiPlayerBlackJack
{
  /* An ArrayList of Lists holding each players individual hands */
  public static List<List<Integer>> multiPlayersHands = new ArrayList<List<Integer>>();
  /* A list holding the dealers hand */
  public static List<Integer> dealersHand = new ArrayList<Integer>();
  /* A list holding the sum value of each players hand's card values */
  public static List<Integer> sumOfPlayersHand = new ArrayList<Integer>();

  /*
    A method to simulate the dealing of cards.
    Ranges from values of 1-11 with 11 being an "Ace".
  */
  public static int dealCard()
  {
    Random rn = new Random();
    int num = rn.nextInt(11)+1;
    return num;
  }

  /*
    A method to set up each players initial hands.
  */
  public static void initiatePlayersHands(int numOfPlayers, String[] nameArray)
  {
    /* Initializing the number of players */
    for(int i = 0; i < numOfPlayers; i++)
    {
      List<Integer> playersHand = new ArrayList<Integer>();
      multiPlayersHands.add(playersHand);
    }

    /* Dealing two cards to each player */
    for(int i = 0; i < numOfPlayers; i++)
    {
      int userCard1 = dealCard();
      int userCard2 = dealCard();

      (multiPlayersHands.get(i)).add(userCard1);
      (multiPlayersHands.get(i)).add(userCard2);

      // Initializing the sum of each players hand's card values.
      int sumAtHand = userCard1 + userCard2;
      sumOfPlayersHand.add(sumAtHand);
      if(sumOfPlayersHand.get(i) > 21)
      {
        System.out.println(nameArray[i] + ", sorry it looks like you bust.");
      }

      //!!! Need to add action when players already bust in the beginning.
      //!!! Need to add action when player gets blackjack in the beginning.

      //multiPlayersHands.remove(i);
      //nameArray.remove(i);
    }


  }

  /*
    A method to set up the dealers initial hand.
  */
  public static void initiateDealersHand()
  {
    int dealerCard1 = dealCard();
    int dealerCard2 = dealCard();

    dealersHand.add(dealerCard1);
    dealersHand.add(dealerCard2);
  }

  /*
    A method to show players their cards
  */
  public static void displayHand(String[] nameArray)
  {
    for(int i = 0; i < nameArray.length; i++)
    {
      //System.out.println((multiPlayersHands.get(i)).size());
      System.out.println("Here are " + nameArray[i] + "'s cards: [" +
      (multiPlayersHands.get(i)).get(0) + "] " + "[" +
      (multiPlayersHands.get(i)).get(1) + "]");
    }
  }

  public static void main(String args[])
  {
    // Initialize the deck first
    //initializeDeck();
    Scanner input = new Scanner(System.in);
    System.out.println("How many will be joining us? (Max is 6 players)");
    int num = input.nextInt();
    if(num > 6)
    {
      System.out.println("Sorry. Too many players.");
      System.exit(0);
    }

    /* An array to store names of the players */
    String[] names = new String[num];

    for(int i = 1; i <= num; i++)
    {
      System.out.println("Please enter name of player " + i + ": ");
      String temp = input.next();
      names[i-1] = temp;;
    }
    System.out.println("");
    if(num == 1)
    {
      System.out.println("Welcome " + names[0] + "!");
      System.out.println("Are you ready to play black jack? (yes/no)");
    }
    else
    {
      System.out.println("Welcome players!");
      System.out.println("Are you all ready to play black jack? (yes/no)");
    }
    String answer = input.next();
    System.out.println("");
    if(answer.equals("yes") || answer.equals("Yes"))
    {
      /* Start the game */
      System.out.println("I will be your dealer today.");
      System.out.println("");
      /* Setting up the initial stages of the game */
      initiatePlayersHands(num, names); // this will place two cards in each players hands
      initiateDealersHand(); // this places two cards in dealers hand
      // for(int i = 0; i < multiPlayersHands.size(); i++)
      // {
      //   System.out.println(sumOfPlayersHand.get(i));
      // }
      displayHand(names);
      System.out.println("");
      System.out.println("Here are the dealers cards: " + "[ ]" + " " + "[" + dealersHand.get(1) + "]");
      int dealerSum = dealersHand.get(0) + dealersHand.get(1);
      String response = null;

      // System.out.println("names length: " + names.length);
      // System.out.println("sum array length: " + sumOfPlayersHand.size());

      int y = 0; /* An iterator for the names to indicate current player */
      int i = 0; /* An iterator for the sums to indicate current players hand sum*/
      /* Iterating through the list of sums of each players hands. */
      while(i < sumOfPlayersHand.size()-1)
      {
        /* Iterating through each player */
        for(int j = 0; j < names.length; j++)
        {
          boolean wantsHit = true;
          /* While the current players hand is less than 21. */
          while(sumOfPlayersHand.get(j) <= 21 && wantsHit == true)
          {
            System.out.println("");
            System.out.println(names[j] + ", would you like to hit or stand?");
            response = input.next();
            /* If response is to hit, then deal a new card */
            if(response.equals("hit") || response.equals("Hit"))
            {
              // wantsHit remains true;
              int newCard = dealCard();
              // adding the new card to current players hands
              (multiPlayersHands.get(j)).add(newCard);
              System.out.println(names[j] + ", here are your new cards: ");
              /* To iterate through the current player's hand */
              int n = 0;
              // Printing out the current player's hand.
              while(n <= (multiPlayersHands.get(j)).size()-1)
              {
                System.out.print("[" + (multiPlayersHands.get(j)).get(n) + "]");
                n++;
              }
              System.out.println("");
              /* Updating sum of current player's hand */
              int newSum = sumOfPlayersHand.get(j) + newCard;
              sumOfPlayersHand.set(j, newSum);
              // If at any point, the sum of current player's hand is 21
              if(sumOfPlayersHand.get(j) == 21)
              {
                System.out.println("Congratulations! You got Blackjack!");
                System.exit(0);
              }
              // If at any point, the current player busts
              if(sumOfPlayersHand.get(j) > 21)
              {
                System.out.println("Sorry you bust.");
                i++;
              }
            }
            else if(response.equals("stand") || response.equals("Stand"))
            {
              wantsHit = false;
              System.out.println("");
              System.out.println("Alright. Moving onto the next player.");
              //y++;
              i++;
            }
          }
        }
        if(i == names.length)
        {
          System.out.println("Ok. Moving onto the dealer");
        }
        i++;
      }

      /* Details regarding the dealers actions. */
      System.out.println("");
      System.out.println("I will now reveal my cards.");
      // Reveal the face down dealers card
      System.out.println("[" + dealersHand.get(0) + "]" + " " + "[" + dealersHand.get(1) + "]");
      if(dealerSum < 17)
      {
        System.out.println("I will hit until my hand totals at least 17");
      }
      // Dealer must hit until his hand total is at least 17 or busts
      while(dealerSum <= 17)
      {
        int newDealCard = dealCard();
        dealersHand.add(newDealCard);
        dealerSum+=newDealCard;
        for(int k = 0; k < dealersHand.size(); k++)
        {
          System.out.print("[" + dealersHand.get(k) + "] ");
        }
        System.out.println("");
      }

      if(dealerSum == 21)
      {
        // When there is only one player
        if(num == 1)
        {
          System.out.println("Looks like I got Blackjack. You lost!");
          System.exit(0);
        }
        // When there are more than one player
        System.out.println("Sorry fellas, looks like I got Blackjack. Please try again!");
        System.exit(0);
      }
      else if(dealerSum > 21)
      {
        if(num == 1)
        {
          System.out.println("Darn! Looks like I bust. Congratulations you win!");
          System.exit(0);
        }
        System.out.println("Darn! Looks like I bust. Let's see who won.");
        System.out.println("");
        /* Since dealer busted, checking for player with highest values */
        // Temporarily set first players sum to be highest
        int tempHighest = sumOfPlayersHand.get(0);
        int index = 0;
        // Check for player with highest value of cards
        for(int x = 1; x <= sumOfPlayersHand.size()-1; x++)
        {
          if(sumOfPlayersHand.get(x) > tempHighest)
          {
            tempHighest = sumOfPlayersHand.get(x);
            index = x;
          }
        }
        System.out.println("Congratulations " + names[index] + "! You beat the dealer.");
        System.out.println("");
        System.exit(0);
      }
      else
      {
        // Temporarily set first players sum to be highest
        int tempHighest = sumOfPlayersHand.get(0);
        int index = 0;
        int potentialTie;
        // Check for player with highest value of cards
        for(int x = 1; x <= sumOfPlayersHand.size()-1; x++)
        {
          if(sumOfPlayersHand.get(x) > tempHighest)
          {
            tempHighest = sumOfPlayersHand.get(x);
            index = x;
          }

          //!!! Need to add conditional where two players get tie

        }

        if(tempHighest > dealerSum && tempHighest <= 21)
        {
          System.out.println("Congratulations " + names[index] + "! You beat the dealer.");
          System.out.println("");
          System.exit(0);
        }
        else if(tempHighest == dealerSum)
        {
          System.out.println("Looks like " + names[index] + " and the dealer have a draw!");
          System.out.println("");
          System.exit(0);
        }
        else
        {
          System.out.println("Dealer wins. Please try again!");
          System.out.println("");
          System.exit(0);
        }
      }
    }
    else
    {
      System.out.println("Sorry to see you go. Please come again!");
      System.exit(0);
    }
  }
}
