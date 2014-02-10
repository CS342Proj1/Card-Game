package pokertest;
import java.util.Scanner; 
import java.util.List;
import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {

		int numOfComputerPlayer = 1; //Initialize to 1 Computer player
		Deck deck = new Deck();	//The deck used in the game

		System.out.println("Welcome to Poker Game!");


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

	   List<Players> players = new ArrayList<Players>();
	   players.add(player1);
	   players.add(player2);
	   players.add(player3);
	   players.add(player4);

	   dealCards(players, numOfComputerPlayer + 1, deck);

	   System.out.println("The cards are being delt to "+ (numOfComputerPlayer+1) +" players.");
	   
	   //this is for debuging
	   for(int m = 0; m<numOfComputerPlayer+1; m++){
		   printHand(players.get(m));
	   }
	   
	   //Discard and Draw phase
	   System.out.print("The cards in your hand are: ");
	   printHand(player1);	//need to sort the order of cards

	   System.out.println(" ");
	   //check if there is a Ace in hand
	   int discardNum = 0;
	   if(hasAce(player1) == true){
		   System.out.println("Since you have an Ace, you can keep the Ace and discard the other four cards.");
		   discardNum = 4; //later for counting the numbers user inputed.
		   
	   }
	   else{
		   System.out.println("You can discand three cards.");
		   discardNum = 3;
	   }
	   
	   //pump user to discard card
	   int index[]={0,0,0,0},i=0;
	  
	   System.out.print("List the cards numbers you wish to discard (enter 0 for not discard): > ");
	   
	   
	   
	 //I have problem with read in the numbers
	   Scanner scan = new Scanner(System.in);	
		   while(scan.hasNext()){
			   
			   index[i] = scan.nextInt();
			   discardNum--;
			   if(discardNum < 0){
		   		  	System.out.println("too many cards to discard.");
		   		  	break;
		   	  	}
			   i++;
		   }
		   scan.close();
		   
		   for(int j = 0;j<i;j++){
		   switch (index[j]) {
		   	case 0: break;
		   	case 1:	
		   	case 2:
			case 3:
			case 4:
			case 5:discardCard(player1, index[j]-1);break;

			default:System.out.println("invalid input.");
				break;
		   }
		   }
	   	  
	   	   //discardCard(player1, index-1);
	   
	   
	}//end of main


	public static void dealCards(List<Players> players, int numOfPlayers, Deck deck)
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
				((Players) p).getHandCards().add(C);
			}
		}


	}

	static void printHand(Players p)
	{
		//System.out.println("Hand: ");
		//Card C;
		int i =1;
		for(Card C : p.getHandCards())
		{	
			//C = p.handCards;
			System.out.print(i+") "+C.toString() + " ");
			i++;
		}
		System.out.println(" ");
	}


	static boolean hasAce(Players p){
		for(Card C: p.getHandCards()){
			if (C.getRank() == 13) {
				return true;
			}
		}
		
		return false;
	}
	
	
	static void discardCard(Players p, int n){
		p.getHandCards().remove(n);
	}
	
	/*static boolean fourOfAKind(Players p){
		 for(Card c: p.getHandCards()){
			 c.getRank() = 
		 }
	 }
	 
	 public boolean equalsSuit(Players p){
		 return p.getHandCards().getSuit().equals(paramCard.getSuit());
	 }
	 
	 public boolean next(Card paramCard){
		 if(equalsSuit(paramCard)){
			 return Math.abs(this.card-paramCard.card)==1;
		 }
		 else{
			 return false;
		 }
	 }*/
	 
	
}//end of class