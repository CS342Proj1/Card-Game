package PokerGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import PokerGame.Players;

public class UserPlayer extends Players {



	 void printHand()
	{
		 ArrayList<Card> handCards = this.getHandCards();
		System.out.print("The cards in your hand are: ");
		int i = 1;

		Collections.sort(handCards, new Comparator<Card>(){
						public int compare(Card C1, Card C2) {
								return C1.getRank() - C2.getRank();
						}

		});

		for(Card C : this.getHandCards())
		{	
			System.out.print(i + ") ");
			System.out.print(C.toString() + " ");
			i++;
		}
		System.out.println();
	}

	  boolean checkAce()
		{
			ArrayList<Card> evalHand =  this.getHandCards();

			for(Card C : evalHand)
			{
				if(C.getRank() == 12)
				{
					return true;
				}
			}
			return false;

		}

   int discard()
	 {

		 int count = 0;
		 int i = 0;

		 //int value;

		 ArrayList<Integer> cardList = new ArrayList<Integer>();


		   InputStreamReader instr = new InputStreamReader(System.in);
	       BufferedReader stdin = new BufferedReader(instr);
	       StringTokenizer stok;
	       String value;

	       try {

	// prompt the user and read in a line of input
	    	   System.out.print("List the cards numbers you wish to discard (enter -1 to terminate): ");
	           System.out.println();   
	           value = stdin.readLine();
	           System.out.println();
	       

	// use a StringTokenizer to extract each value entered from the input 
	// line, then convert each value to an integer

	           stok = new StringTokenizer(value);
	           while (stok.hasMoreTokens())
	           {
	        	   cardList.add(Integer.parseInt(stok.nextToken()));
	               if(cardList.size()>4){
	            	   break;
	               }
	           }
	       } catch (IOException ioe)
	       {
	           System.out.println(ioe);
	           System.exit(-1);
	       }
	       Collections.sort(cardList);		//sort the input numbers in case user input not in order
	    for(int a :cardList){
	    	System.out.println(a);
	    }
	       count = cardList.size();
	
		 if(count <= 3 || (count == 4 && this.checkAce() == true))
		 {
			 for(int C : cardList)
			 {
				 if(C<0){
					 return -1;
				 }
				 this.getHandCards().remove(C-i-1);
				 i++;
			 }

		 }
		 else if(count > 3)
		 {
			 return -1;
		 }
		
		 return count;

	 }

}
