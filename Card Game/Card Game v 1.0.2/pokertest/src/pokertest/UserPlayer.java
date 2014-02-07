package pokertest;

public class UserPlayer extends player {
	
	static void printHand(player p)
	{
		
		System.out.print("The cards in your hand are: ");
		int i = 1;
		
		for(Card C : p.getHandCards())
		{	
			System.out.print(i + ") ");
			System.out.print(C.toString() + " ");
			i++;
		}
		System.out.println();
	}
	
	
}
