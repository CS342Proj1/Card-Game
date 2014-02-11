package pokertest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 

public class Game {
/**************************	  Main function  **********************************/
	public static void main(String[] args) {

		int numOfComputerPlayer = 1; //Initialize to 1 Computer player
		Deck deck = new Deck();	//The deck used in the game

		System.out.println("Welcome to Poker Game!");


	   Scanner scanner = new Scanner(System.in);
	while(true)
	   {
		   //prompt user to choose the number of opponent players (1-3)
		   System.out.println("Please enter the number of computer players:");
		   numOfComputerPlayer = scanner.nextInt();

	   	if(numOfComputerPlayer > 3 || numOfComputerPlayer < 1){
		   System.out.println("invalid number of players.");
	   	}
	   	else{
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
		  // sortHandCards(players.get(m));
		  printHand(players.get(m));
	   }
	   
	   //Discard and Draw phase
	 
	  player1.printHand();	//need to sort the order of cards

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
	  int[] idx={0,0,0,0}; 
	   int i=0;
	
	   
	  
	   InputStreamReader instr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(instr);
       StringTokenizer stok;
       String value;

       try {

// prompt the user and read in a line of input
    	   System.out.print("List the cards numbers you wish to discard (enter 0 for not discard): ");
           System.out.println();   
           value = stdin.readLine();
           System.out.println();
       

// use a StringTokenizer to extract each value entered from the input 
// line, then convert each value to an int and store it to a int array

           stok = new StringTokenizer(value);
           while (stok.hasMoreTokens())
           {
               idx[i] = Integer.parseInt(stok.nextToken());
               if(i>4){
            	   break;
               }
               i++;
           }
       } catch (IOException ioe)
       {
           System.out.println(ioe);
           System.exit(-1);
       }
	
	  //for debugging
	 // System.out.println("done scanning");
       
	  discardCards(player1, idx, i);
	  //drawing new cards for player1
	  reDraw(player1, deck);
	  player1.printHand();
	  Players.HandEval(player1);

	  for(int m = 1; m<numOfComputerPlayer+1; m++){
		  System.out.println("For computer " + m + ": ");
		  ((OpponentPlayer) players.get(m)).aiRunner();
		  reDraw(players.get(m), deck);
		  
		  printHand(players.get(m));
		  Players.HandEval(players.get(m));
		  System.out.println();
	   }
	  
	  
	  
	  
		scanner.close();
	}//end of main

/**************************	  Functions  **********************************/
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
			if (C.getRank() == 12) {
				return true;
			}
		}
		
		return false;
	}
	
	static void discardCards(Players p, int[] idx, int i){
		int count = 0;   
		  for(int j = 0;j<=i;j++){
			 
			   switch (idx[j]) {
			   	case 0: break;
			   	case 1:	
			   	case 2:
				case 3:
				case 4:
				case 5:
					discardCard(p, (idx[j]-1-count));break;

				default:System.out.println("invalid input.");
					break;
			   }//end of switch
			   count++;
		   }//end of for j */
		  System.out.println("Done with discarding cards.");
	}

	//discard a individual card
	static void discardCard(Players p, int n){
	
		if(hasAce(p) && n == 4){
			System.out.println("You cannot discard Ace");
		}
		else{
			p.getHandCards().remove(n);
		}
	}
	 
	static void reDraw(Players p, Deck deck){
		int size = p.getHandCards().size();
		Card newCard;
		if(size<5){
			  for(int j = 0;j<(5-size);j++){
				  newCard = deck.drawFromDeck();
				  p.getHandCards().add(newCard);
			  }
		}
	}
}//end of class
