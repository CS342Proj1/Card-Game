package pokertest;
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
/*	   UserPlayer player1 = new UserPlayer();
	   OpponentPlayer player2 = new OpponentPlayer();
	   OpponentPlayer player3 = new OpponentPlayer();
	   OpponentPlayer player4 = new OpponentPlayer();

	   Card c1 = new Card(0,4);
	   Card c2 = new Card(1,4);
	   Card c3 = new Card(1,7);
	   Card c4 = new Card(2,7);
	   Card c5 = new Card(3,7);

	   
	   UserPlayer testPlayer = new UserPlayer();
	   
	   testPlayer.getHandCards().add(c1);
	   testPlayer.getHandCards().add(c2);
	   testPlayer.getHandCards().add(c3);
	   testPlayer.getHandCards().add(c4);
	   testPlayer.getHandCards().add(c5);
	*/   
	   
	//   List<player> players = new ArrayList<player>();
	//   players.add(player1);
	//   players.add(player2);
	//   players.add(player3);
	//   players.add(player4);
	   
	//   dealCards(players, numOfComputerPlayer + 1, deck);
	 //  player1.printHand();
	//   System.out.println("Has Ace: " + checkAce(player1));
	//   HandEval(player1);
	   
	//   testPlayer.printHand();
	//   System.out.println("Has Ace: " + checkAce(testPlayer));
	//   HandEval(testPlayer);
	   
	}
	
	
	static void gamePlay(int numPlayers)
	{
			int draw;
			Deck deck = new Deck();	//The deck used in the game
			
		   UserPlayer player1 = new UserPlayer();
		   OpponentPlayer player2 = new OpponentPlayer();
		   OpponentPlayer player3 = new OpponentPlayer();
		   OpponentPlayer player4 = new OpponentPlayer();
		
		   
		   ArrayList<player> players = new ArrayList<player>();
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
			   ((OpponentPlayer) players.get(i)).aiRunner();
			   
			   if(((OpponentPlayer) players.get(i)).isFourCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 4 cards.");
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else if(((OpponentPlayer) players.get(i)).isThreeCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 3 cards.");
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   
			   }
			   else if(((OpponentPlayer) players.get(i)).isTwoCards() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 2 cards.");
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else if(((OpponentPlayer) players.get(i)).isOneCard() == true)
			   {
				   System.out.println("Player " + (i+1) + " has discarded 1 card.");
				   ((OpponentPlayer) players.get(i)).getHandCards().add(deck.drawFromDeck());
			   }
			   else
			   {
				   System.out.println("Player " + (i+1) + " has discarded 0 cards.");
			   }
			   ((OpponentPlayer) players.get(i)).setAllZero();
			   System.out.println("Player " + (i+1) + "'s hand: ");
			   printHand(players.get(i));
			   HandEval(players.get(i));
			   printValues(players.get(i));
		   }
		   
		   
		   
		determineWinner(players);
		
		
	}
	public static void determineWinner(ArrayList<player> players)
	{
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		for(player p : players)
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
		
	  
      for(player p : players)
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
      
      
      
     
      
    /*
      
      System.out.println("");
      System.out.println("");
      
      if(score1 > score2 && score1 > score3 && score1 > score4) //player1 wins indefinitely
      {
    	  System.out.println("Player 1 wins!!!");
      }
      
      else if(score2 > score1 && score2 > score3 && score2 > score4) //player2 wins indefinitely 
      {
    	  System.out.println("Player 2 wins!!!");
      }
      
      else if(score3 > score1 && score3 > score2 && score3 > score4) //player3 wins indefinitely
      {
    	  System.out.println("Player 3 wins!!!");
      }
      
      else if(score4 > score1 && score4 > score2 && score4 > score3) //player4 wins indefinitely
      {
    	  System.out.println("Player 4 wins!!!");
      }
      
      else //there was a tie somewhere
      {
    	  System.out.println("tie");
      }
      */
	}
	
	public static void dealCards(List<player> players, int numOfPlayers, Deck deck)
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
				((player) p).getHandCards().add(C);
			}
		}
		
		
	}
	
	static void printHand(player p)
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
	
	static boolean checkAce(player p)
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
	
	static void HandEval(player p)
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
	
	static void printValues(player p)
	{
		System.out.println("This hand's high card: " + p.getHighCard());
		
		if(p.getPair() > 0)
		{
			System.out.println("This hand has a pair." + p.getPair());
    	}
		
		if(p.getTwoPair() > 0)
		{
			System.out.println("This hand has two pairs." + p.getTwoPair());
		}
		if(p.getThreeKind() > 0)
		{
			System.out.println("This hand has three of a kind." + p.getThreeKind());
		}
		if(p.getStraight() > 0)
		{
			System.out.println("This hand has a straight." + p.getStraight());
		}
		if(p.getFlush() > 0)
		{
			System.out.println("This hand has a flush." + p.getFlush());
     	}
		if(p.getFullHouse() > 0)
		{
			System.out.println("This hand has a full house." + p.getFullHouse());
		}
		if(p.getFourKind() > 0)
		{
			System.out.println("This hand has four of a kind." + p.getFourKind());
		}
		if(p.getStraightFlush() > 0)
		{
			System.out.println("This hand has a straight flush." + p.getStraightFlush());
		}
	}
	
	static void highCard(player p)
	{
		ArrayList<Card> evalHand = p.getHandCards();
		Collections.sort(evalHand, new Comparator<Card>(){
			public int compare(Card C1, Card C2) {
					return C1.getRank() - C2.getRank();
			}});
		
		p.setHighCard(evalHand.get(evalHand.size()-1).getRank()+1);
	}
	
	static void onePair(player p)
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
	
	static void twoPair(player p)
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
	
	static void threeKind(player p)
	{
		ArrayList<Card> evalHand = ((player) p).getHandCards();
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
	
	static void straight(player p)
	{
		ArrayList<Card> evalHand = ((player) p).getHandCards();
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
	
	static void flush(player p)
	{
	ArrayList<Card> evalHand = ((player) p).getHandCards();
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
	
	static void fullHouse(player p)
	{
		if(p.getThreeKind() > 0 && p.getPair() > 0)
		{
			p.setFullHouse(p.getThreeKind());
			return;
		}
	}
	
	static void fourKind(player p)
	{
		ArrayList<Card> evalHand = ((player) p).getHandCards();
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
	
	
	static void straightFlush(player p)
	{
		if(p.getFlush() > 0 && p.getStraight() > 0)
		{
			p.setStraightFlush(p.getStraight());
			return;
		}
	}
}
