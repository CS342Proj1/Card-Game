package pokertest;

public class Game {

	public static void main(String[] args) {
		
		int numOfComputerPlayer = 1; //
		Deck deck = new Deck();
	
		Card C;
		Card[] userHand = null;
		
		UserPlayer player1 = new UserPlayer(userHand, "Sally");
		
		
		System.out.println( deck.getTotalCards() );

	   while (deck.getTotalCards()!= 0 )
	   {
		   C = deck.drawFromDeck();
		   System.out.println( C.toString() );
	   }
	   
	   //prompt user to choose the number of opponent players (1-3)
	   System.out.println("Please enter the number of computer players:");
	}

}
