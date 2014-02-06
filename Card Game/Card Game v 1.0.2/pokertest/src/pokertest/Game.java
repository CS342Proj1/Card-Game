package pokertest;
import java.util.Scanner; 
import java.util.List;
import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		
		int numOfComputerPlayer = 1; //Initialize to 1 Computer player
		Deck deck = new Deck();	//The deck used in the game
				
 

				
	   while(true)
	   {
		   //prompt user to choose the number of opponent players (1-3)
		   System.out.println("Please enter the number of computer players:");
		   Scanner scan = new Scanner(System.in);
		   numOfComputerPlayer = scan.nextInt();
		
	   	if(numOfComputerPlayer > 3 || numOfComputerPlayer < 1)
	   	{
		   System.out.println("invalid number of players.");
	   	}
	   	else
	   	{
	   		scan.close();
	   		break;
	   	}
	   }
	   
	   UserPlayer player1 = new UserPlayer();
	   OpponentPlayer player2 = new OpponentPlayer();
	   OpponentPlayer player3 = new OpponentPlayer();
	   OpponentPlayer player4 = new OpponentPlayer();
	   
	   List<player> players = new ArrayList<player>();
	   players.add(player1);
	   players.add(player2);
	   players.add(player3);
	   players.add(player4);
	   
	   dealCards(players, numOfComputerPlayer + 1, deck);
	   printHand(player1);
	   printHand(player3);
	   
	}
	
	
	public static void dealCards(List<player> players, int numOfPlayers, Deck deck)
	{	

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
				//System.out.println("player"+i+": ");
				//System.out.println(C.toString());
				((player) p).getHandCards().add(C);
			}
		}
		
		
	}
	
	static void printHand(player p)
	{
		System.out.println("Hand: ");
		//Card C;
		for(Card C : p.getHandCards())
		{	
			//C = p.handCards;
			System.out.println(C.toString());
		}
	}
	

	

}
