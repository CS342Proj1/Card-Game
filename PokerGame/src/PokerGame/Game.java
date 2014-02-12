package PokerGame;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner; 
import java.util.List;
import java.util.ArrayList;

public class Game {

	private static Scanner scan;


	public static void main(String[] args) {

		int numOfComputerPlayer = 1; //Initialize to 1 Computer player
		//Deck deck = new Deck();	//The deck used in the game

		System.out.println("Welcome to Poker Game!");
		System.out.println("Designed by Dominick Rauba and Tongtong Liu");
		System.out.println();
		System.out.println();

	   while(true)
	   {
		   //prompt user to choose the number of opponent players (1-3)
		   System.out.println("Please enter the number of computer players:");
		   scan = new Scanner(System.in);
		   numOfComputerPlayer = scan.nextInt();

	   	if(numOfComputerPlayer > 3 || numOfComputerPlayer < 1)
	   	{
		   System.out.println("invalid number of players.");
	   	}
	   	else
	   	{
	   		break;
	   	}

	   }
	   
	    gamePlay(numOfComputerPlayer+1);
	    
	    System.out.println("Thank you for playing");
	    
	}//end of main

	/**************************	  Functions  **********************************/
	static void gamePlay(int numPlayers)
	{
			int draw;
			Deck deck = new Deck();	//The deck used in the game

		   UserPlayer player1 = new UserPlayer();
		   OpponentPlayers player2 = new OpponentPlayers();
		   OpponentPlayers player3 = new OpponentPlayers();
		   OpponentPlayers player4 = new OpponentPlayers();


		   ArrayList<Players> players = new ArrayList<Players>();
		   players.add(player1);
		   players.add(player2);
		   players.add(player3);
		   players.add(player4);

		   dealCards(players, numPlayers, deck);

		   player1.printHand();



		   if(player1.checkAce() == true )
		   {
			   System.out.println("Since you have an ace you can discard up to 4 cards.");
		   }


		  draw =  player1.discard();

		   for(int i = 0; i < draw; i++)
		   {
			   player1.getHandCards().add(deck.drawFromDeck());
		   }

		   player1.printHand();
		   HandEval(player1);
		   printValues(player1);


		   for(int i = 1; i < numPlayers; i++)
		   {
			   System.out.println("");
			   System.out.println("");
			   printHand(players.get(i));
			   HandEval(players.get(i));
			   ((OpponentPlayers) players.get(i)).aiRunner();

			   if(((OpponentPlayers) players.get(i)).isFourCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 4 cards.");
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else if(((OpponentPlayers) players.get(i)).isThreeCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 3 cards.");
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());

			   }
			   else if(((OpponentPlayers) players.get(i)).isTwoCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 2 cards.");
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else if(((OpponentPlayers) players.get(i)).isOneCard() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 1 card.");
				   ((OpponentPlayers) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else
			   {
				   System.out.println("Player " + (i+1) + " has discarded 0 cards.");
			   }
			   ((OpponentPlayers) players.get(i)).setAllZero();
			   System.out.println("Player " + (i+1) + "'s hand: ");
			   printHand(players.get(i));
			   HandEval(players.get(i));
			   printValues(players.get(i));
		   }



		determineWinner(players);
	}
	
	
	public static void determineWinner(ArrayList<Players> players)
	{
		ArrayList<Integer> scores = new ArrayList<Integer>();

		for(Players p : players)
		{
			p.getScore().add(p.getHighCard());
			p.getScore().add(p.getPair());
			p.getScore().add(p.getTwoPair());
			p.getScore().add(p.getThreeKind());
			p.getScore().add(p.getStraight());
			p.getScore().add(p.getFlush());
			p.getScore().add(p.getFullHouse());
			p.getScore().add(p.getFourKind());
			p.getScore().add(p.getStraightFlush());
		}


      for(Players p : players)
      {
    	  for(int i = 8 ; i >= 0 ; i--)
    	  {
    		  if(p.getScore().get(i) > 0)
    		  {
    			  p.setTopScore(i);
    			  scores.add(p.getTopScore());
    			  break;
    		  }
    	  }
      }
      
      int max = Collections.max(scores);
      
      System.out.println("");
      System.out.println("");
      
      if(Collections.frequency(scores, max) > 1) //There is a tie
      {
    	  
      }
      
      else
      {
    	  if(scores.get(0) == max)
    	  {
    		  System.out.println("Player 1 wins!!!");
    	  }
    	  else if(scores.get(1) == max)
    	  {
    		  System.out.println("Player 2 wins!!!");
    	  }
    	  
    	  else if(scores.get(2) == max)
    	  {
    		  System.out.println("Player 3 wins!!!");
    	  }
    	  
    	  else if(scores.get(3) == max)
    	  {
    		  System.out.println("Player 4 wins!!!");
    	  }  
      }
	}

	public static void dealCards(List<Players> players, int numOfPlayers, Deck deck)
	{	
		System.out.println("The cards are being delt...");
		int cardNumber;
		int i;
		Card C;
		Object p;


		for(cardNumber = 0; cardNumber < 5; cardNumber++)
		{
			for( i = 0; i < numOfPlayers; i++)
			{
				p = players.get(i);
				C = deck.drawFromDeck();
				((Players) p).getHandCards().add(C);
			}
		}


	}

	static void printHand(Players p)
	{
		Collections.sort(p.getHandCards(), new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});
		int i = 1;

		for(Card C : p.getHandCards())
		{	
			System.out.print(i + ") ");
			System.out.print(C.toString() + " ");
			i++;
		}
		System.out.println();
	}

	static boolean checkAce(Players p)
	{
		ArrayList<Card> evalHand =  p.getHandCards();

		for(Card C : evalHand)
		{
			if(C.getRank() == 12)
			{
				return true;
			}
		}
		return false;

	}

	static void HandEval(Players p)
	{
		//System.out.println("Evaluating Hand: ");

		highCard(p);
		onePair(p);
		twoPair(p);
		threeKind(p);
		straight(p);
		flush(p);
		fullHouse(p);
		fourKind(p);
		straightFlush(p);

	}

	static void printValues(Players p)
	{
		System.out.println("This hand's high card: " + (p.getHighCard()+1));

		if(p.getPair() > 0)
		{
			System.out.println("This hand has a pair." + (p.getPair()+1));
    	}

		if(p.getTwoPair() > 0)
		{
			System.out.println("This hand has two pairs." + (p.getTwoPair()+1));
		}
		if(p.getThreeKind() > 0)
		{
			System.out.println("This hand has three of a kind." + (p.getThreeKind()+1));
		}
		if(p.getStraight() > 0)
		{
			System.out.println("This hand has a straight." + (p.getStraight()+1));
		}
		if(p.getFlush() > 0)
		{
			System.out.println("This hand has a flush." + (p.getFlush()+1));
     	}
		if(p.getFullHouse() > 0)
		{
			System.out.println("This hand has a full house." + (p.getFullHouse()+1));
		}
		if(p.getFourKind() > 0)
		{
			System.out.println("This hand has four of a kind." + (p.getFourKind()+1));
		}
		if(p.getStraightFlush() > 0)
		{
			System.out.println("This hand has a straight flush." + (p.getStraightFlush()+1));
		}
	}

	static void highCard(Players p)
	{
		ArrayList<Card> evalHand = p.getHandCards();
		Collections.sort(evalHand, new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});

		p.setHighCard(evalHand.get(evalHand.size()-1).getRank()+1);
	}

	static void onePair(Players p)
	{
		ArrayList<Card> evalHand =  p.getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 2)
			{
				p.setPair(i+1);
				return;
			}
		}


	}

	static void twoPair(Players p)
	{
		boolean p1 = false, p2 = false;
		ArrayList<Card> evalHand = p.getHandCards();

		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}


		int rank1 = 0;
		int rank2 = 0;

		for(int i: ranks)
		{
			if(Collections.frequency(ranks,i) == 2 && p1 == false)
			{
				//p.setPair(C.getRank());
				rank1 = i;
				p1 = true;
			}

			else if(Collections.frequency(ranks,i) == 2 && i != rank1)
			{
				rank2 = i;
				p2 = true;
			}	
		}

		if(p1 == true && p2 == true)
		{
			if(rank1 > rank2)
			{
				p.setTwoPair(rank1+1);
				return;
			}

			else
			{
				p.setTwoPair(rank2+1);
				return;
			}
		}
	}

	static void threeKind(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 3)
			{
				p.setThreeKind(i+1);
				return;
			}
		}

	}

	static void straight(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		Collections.sort(evalHand, new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});

			int straightVal = evalHand.get(0).getRank();
			int i = 0;
			for(i = 0; i < evalHand.size(); i++)
			{
				if(evalHand.get(i).getRank() != straightVal)
				{
					return;
				}
				straightVal++;
			}


			p.setStraight(straightVal);

	}

	static void flush(Players p)
	{
	ArrayList<Card> evalHand = ((Players) p).getHandCards();
	Collections.sort(evalHand, new Comparator<Card>(){
		public int compare(Card C1, Card C2) {
				return C1.getRank() - C2.getRank();
		}});

	ArrayList<Integer> suits = new ArrayList<Integer>();

	for(Card C: evalHand)
	{
		suits.add(C.getSuit());
	}

	int suit = evalHand.get(0).getSuit();

		if(Collections.frequency(suits , suit) == 5)
		{
			p.setFlush(evalHand.get(4).getRank()+1);
			return;
		}



	}

	static void fullHouse(Players p)
	{
		if(p.getThreeKind() > 0 && p.getPair() > 0)
		{
			p.setFullHouse(p.getThreeKind());
			return;
		}
	}

	static void fourKind(Players p)
	{
		ArrayList<Card> evalHand = ((Players) p).getHandCards();
		ArrayList<Integer> ranks = new ArrayList<Integer>();

		for(Card C: evalHand)
		{
			ranks.add(C.getRank());
		}

		for(int i : ranks)
		{
			if(Collections.frequency(ranks , i) == 4)
			{
				p.setFourKind(i+1);
				return;
			}
		}
	}


	static void straightFlush(Players p)
	{
		if(p.getFlush() > 0 && p.getStraight() > 0)
		{
			p.setStraightFlush(p.getStraight());
			return;
		}
	}
}
