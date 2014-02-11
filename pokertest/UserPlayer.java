package pokertest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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


}