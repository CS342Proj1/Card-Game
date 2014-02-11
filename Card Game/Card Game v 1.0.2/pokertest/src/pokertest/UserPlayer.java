package pokertest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UserPlayer extends player {
	

	
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
		 
		 int value;
		 
		 ArrayList<Integer> cardList = new ArrayList<Integer>();
		 


		Scanner scan = new Scanner(System.in);
		while(count < 4)
		 {
			System.out.print("Enter index of card to discard [enter '0' if you with to terminate] > ");
			if(count == 3 && checkAce() != true)
			{
				break;
			}
			  value = scan.nextInt();
			  
			  if(value <= 0 )
			  {
				  break;
			  }
			  
			   cardList.add(value-1);
			   count++;
		 }
		
		Collections.sort(cardList);
			
		 
		 if(count <= 3 || (count == 4 && this.checkAce() == true))
		 {
		 for(int C : cardList)
		 {
			 if(C > 0 && C < 6)
			 {
			 this.getHandCards().remove(C-i);
			 i++;
			 }
		 }
		 
		 }
		 else if(count > 3)
		 {
			 return -1;
		 }
		 
		 return count;
		 
	 }
		
	
	
}
